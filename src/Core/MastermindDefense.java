package Core;

import java.util.Random;
import java.util.Scanner;
import Affichage.Display;

public class MastermindDefense {

    Config conf = null ;
    Scanner sc = new Scanner(System.in);

    int[] Try;
    int[] Solution;
    char Colors;
    int Correct;
    boolean victory =  false;
   String tryString;

    public MastermindDefense()
    {
        conf = Config.getInstance();
        Try = new int [conf.getNbcase()];
        Solution = new int [conf.getNbcase()];

    }


    public void SetRandomSolution() {
         /*
         nombres a convertir par la suite en couleur ex : 1 = Jaune / 2 = Bleu avec les nombres defini en fonction des parametres
         */

        for (int j = 0; conf.getNbrcolors() > j; j++)
        {
            Random rand = new Random();
            Solution[j] = rand.nextInt(conf.getNbrcolors());
        }
    }

    public void SetUserTry () {
        int NbColors = conf.getNbrcolors();
        Scanner sc = new Scanner(System.in);
        tryString = sc.next();

        for (int i = 0; i < conf.getNbcase() ; i++)
        {
            Try [i] = Integer.parseInt(String.valueOf(tryString.charAt(i)));
        }
    }

    boolean UnCorrect = false;
    int NbUncorrectColors = 0 ;


    public void Research()
    {
        Correct = 0;
        NbUncorrectColors = 0;
        for(int i = 0 ; conf.getNbcase() > i ; i++)
        {
            if (Solution[i] == Try[i])
            {
                Correct = Correct + 1 ;
            }
        }
        System.out.println("Nombre de bonne combinaison : "  + Correct);


        for (int j = 0; conf.getNbcase() > j; j++) {
            UnCorrect = false;
            for (int i = 0; i < conf.getNbcase() & UnCorrect == false; i++) {
                if (Solution[i] == Try[j]) {
                    UnCorrect = true;
                    NbUncorrectColors = NbUncorrectColors + 1;
                }
            }
        }

        System.out.println("Nombre de couleur présente : " + NbUncorrectColors);

        if (Correct == conf.getNbcase())
        {
            victory = true;
        }
    }



    public void Core()
    {
        SetRandomSolution();

        if(conf.getDevelloperMode() == true)
        {
            System.out.print("La solution est : ");
            for (int solution : Solution) {
                System.out.print(solution);
            }
            System.out.println();
        }

            for (int i = 0 ; i < conf.getNbrtry() && victory == false ; i ++ )
        {
            SetUserTry();
            Research();
            System.out.println();
            System.out.println("il vous reste : " + (conf.getNbrtry()-i) + " essais " );
            System.out.println();
        }

        if (victory == false )
        {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("            Loose !!!!          ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }

        if(victory==true)
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