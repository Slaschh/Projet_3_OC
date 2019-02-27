package Core;

import Affichage.Display;

import java.util.Scanner;

public class ResearchDefense {

    int [] solutionUser;
    Display inter;
    Config conf = null;
    int [] limiteInf;
    int [] limiteSup;
    int [] SolutionComputer;
    String [] tableauPlusOuMoins;
    int tryleft;
    int nbtry = 0;
    String solutionUserString;
    boolean victory = false;

    public ResearchDefense(Display inter) {
        conf = Config.getInstance();
        this.inter = inter;
        this.inter.DisplaySetNumber();
        Scanner sc = new Scanner(System.in);
        solutionUser = new int[conf.getNbcase()];
        SolutionComputer = new int [conf.getNbcase()];
        tableauPlusOuMoins = new String [conf.getNbcase()];
        limiteSup = new int[conf.getNbcase()];
        limiteInf = new int[conf.getNbcase()];

    }


    public void SetSolutionUser()
    {
        inter.DisplaySetNumber();
        Scanner sc = new Scanner(System.in);
        solutionUserString = sc.next();

        for (int i = 0; i < conf.getNbcase() ; i++)
        {
            solutionUser [i] = Integer.parseInt(String.valueOf(solutionUserString.charAt(i)));
        }

    }
    /**
     * Mise en place des limites
     */
public void InitialisationDesLimites()
{
    for (int i = 0 ; i < conf.getNbcase() ; i++)
    {
        limiteInf [i] = 0 ;
        limiteSup [i] = 10 ;
    }

}


public void SetSolutioncomputer()
{
    for (int i = 0 ; i < conf.getNbcase() ; i++)
    {
        SolutionComputer[i] = (limiteInf[i] + limiteSup[i]) / 2 ;
    }
}




    public void ResearchDichotomique() {

        /**
         * Mise en place de la boucle de comaraison
         */
        /**
         * parametre initial
         * @param intermediaire = 5 (10 / 2)
         *
         */
        int correct = 0;
        System.out.println();
        for (int ComputerTry:SolutionComputer)
        {
          System.out.print(ComputerTry);
        }
        System.out.println();


        for (int i = 0; i < conf.getNbcase(); i++)
        {
            if (SolutionComputer[i] < solutionUser[i])
            {
                limiteInf [i] = SolutionComputer [i];
                tableauPlusOuMoins[i] = "+" ;

            }
            if (SolutionComputer[i] > solutionUser[i]) {
                limiteSup [i] = SolutionComputer[i];
               tableauPlusOuMoins[i] = "-";
            }
            if (SolutionComputer[i] == solutionUser [i])
            {
                limiteSup [i] = SolutionComputer [i];
                limiteInf [i] = SolutionComputer [i];
               tableauPlusOuMoins [i] = "=";
               correct++;
            }
        }

        for (String Try: tableauPlusOuMoins)
        {
            System.out.print(Try);
        }
        System.out.println();

        if(correct == conf.getNbcase())
        {
            victory = true;
        }

    }


    public void GameResearchDefense() {

             SetSolutionUser();
             InitialisationDesLimites();


      for(int i =0 ; i < conf.getNbrtry() && victory == false ; i++)
      {
            SetSolutioncomputer();
            ResearchDichotomique();
          System.out.println("il vous reste : " + (conf.getNbrtry()-i) + " essais " );

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


