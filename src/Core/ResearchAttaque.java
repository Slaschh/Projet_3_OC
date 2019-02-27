package Core;

import Affichage.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class ResearchAttaque {

    int [] solution ;
    int [] numberUser;
   String numberUserString;
    Display inter;
    Config conf = null;
    int tryleft;
    int nbtry;
    int nbcorrect;
    boolean victory = false;



    public ResearchAttaque(Display inter)
    {
        conf = Config.getInstance();
        this.inter = inter;
        solution = new int [conf.getNbcase()];
        numberUser = new int [conf.getNbcase()];
        tryleft = conf.getNbrtry();
        nbtry = 0;
        nbcorrect = 0;
        victory = false ;
    }

    static final Logger logger = LogManager.getLogger(ResearchAttaque.class);



    /**
     * Set the random solution
     */
    public void SetRandomNumber()
    {

        Random rand = new Random();

        for( int i = 0 ; i < conf.getNbcase(); i++)
        {
            solution[i] = rand.nextInt (10);
        }


    }

    /**
     * Set Number
     */

    public void setNumber_User()
    {
        inter.DisplaySetNumber();
            Scanner sc = new Scanner(System.in);
            numberUserString  = sc.next();
    }

    public int[] ConversionStringInt()
    {
        for (int i = 0; i < conf.getNbcase() ; i++)
        {
            numberUser [i] = Integer.parseInt(String.valueOf(numberUserString.charAt(i)));
        }
        return numberUser;
    }

    /**
     * Comparaison entre les valeurs solution et Numberuser
     */




    public void ResearchCore()
    {
        nbcorrect = 0;
        victory = false ;
        for (int i = 0 ; i < conf.getNbcase(); i++)
        {
            if (solution[i] < numberUser[i]) {
                inter.DisplayTooBigResearchAttaque(nbtry);
            } else if (solution[i] > numberUser[i]) {
                inter.DisplayTooSmallResearchAttaque(nbtry);
            } else if (solution[i] == numberUser[i]) {
                inter.DisplayVictoryResearchAttaque(nbtry);
                nbcorrect++ ;
            }
        }
        System.out.println();
        if (nbcorrect == conf.getNbcase()){victory = true;}


        tryleft = conf.getNbrtry() - nbtry;
        nbtry = nbtry + 1;


    }





    /**
     * Activation de la méthode ResearchCore
     */

    public void GameResearchAttaque()
    {
        SetRandomNumber();

        if(conf.getDevelloperMode() == true)
        {
            System.out.print("La solution est : ");
            for (int solution : solution )
            {
                System.out.print(solution);
            }
            System.out.println();

        }

        for (int i = 0 ; i < conf.getNbrtry() && victory == false ; i++)
        {
            setNumber_User();
            ConversionStringInt();
            ResearchCore();
            System.out.println("il vous reste : " + (conf.getNbrtry()-i) + " essais " );        }


        if (tryleft == 0 )
        {
           inter.DisplayLooseAttaque();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }
        else if (victory = true)
        {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("          Victory !!!!          ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();}
        }
    }









