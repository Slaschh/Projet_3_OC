package Affichage;

import Core.Config;
import Core.Mastermind;

public class Display {

Config conf = null;


public Display()
{
    conf = Config.getInstance();
}

    /**
     * Display all availabe game with intial configuration
     */


    public void DisplayAvailableGame(){
         System.out.println("Paramètre de jeux");
        System.out.println("---------------------------------");
        System.out.println("Nombre d'essai = " + conf.getNbrtry());
        System.out.println("Nombre de combinaison = " + conf.getNbrcombinaison());
        System.out.println("Nombre de couleur = " + conf.getNbrcolors());
        System.out.println("---------------------------------");
        System.out.println("Choix du jeux : ");
        System.out.println("Jeux recherche plus ou moins ==> 1");
        System.out.println("Jeux Mastermind ==> 2");
    }

    /**
     *Display a selected Game
         */

      public void DiplaySelectedGameResarch(){
            System.out.println("Vous avez choisi le jeu Plus ou Moins");
        }

      public void DisplaySelectedGameMastermind(){
            System.out.println("Vous avez choisi le jeu Mastermind");
        }



    /**
     * Affichage des modes disponible
     */

    public void DisplayAvailableMode() {
             System.out.println("Choix de jeux");
             System.out.println("---------------------------------");
             System.out.println("Mode Attaque (vous devez devinez la combinaison)     ==> 1");
             System.out.println("Mode Defense (l'IA doit devinez votre combinaison)   ==> 2");
             System.out.println("Mode Duel (vous jouez contre l'IA)                   ==> 3");
         }

    /**
     * Affichage du mode selectionné
     */

    public void DisplaySelectedAttaque() {
        System.out.println("Vous avez choisi le mode Attaque");
    }
    public void DisplaySelectedDefense() {
        System.out.println("Vous avez choisi le mode Defense");
    }
    public void DisplaySelectedDuel(){
            System.out.println("vous avec choisi le mode Duel");
        }

    /**
     /* Display during the Game.
     */
    public void DisplaySetNumber (){ System.out.println("Entrez votre nombre  :");}


    /**
     * Display during the game ResearchAttaque
     */

    public void DisplayTooSmallResearchAttaque (int nbtry){ System.out.print("+");}
    public void DisplayTooBigResearchAttaque (int nbtry) { System.out.print("-");}
    public void DisplayVictoryResearchAttaque(int nbtry){ System.out.print("=");}
    public void DisplayLooseAttaque () { System.out.println( "Perdu !!!");

        System.out.println("---------------------------------");}

    /**
     * Display for the game ResearchDefense
     */

    public void DisplayLooseDefense(int solutionUser)
    {
        System.out.println( "Perdu !!!");
        System.out.println("La solution était " + solutionUser);
        System.out.println("---------------------------------");
    }

    public void DisplayTooSmallResearchDefense (int intermediaire)
    {
        System.out.println(intermediaire);
        System.out.println("-");

    }

    public void DisplayTooBigResearchDefense (int intermediaire)
    {
        System.out.println(intermediaire);
        System.out.println("+");
    }


    public void DisplayVictoryResearchDefense(int intermediaire, int tryleft){
        System.out.println(intermediaire);
        System.out.println("Victory !!!");
        System.out.println("Il vous reste : " +tryleft + " essais");
    }

    /**
     * Display for the MastermindAttaque
     */

    /**
     * Display for the MastermindDefense
     */

    public void AffichageProposition(int [] tableauProposition)
    {
        System.out.print("Solution proposé : ");

        for (int proposition: tableauProposition)
        {
            System.out.print(proposition);
        }
        System.out.println();
    }

    /**
     * Board for translate the letter color into a number
     */


    public void BoardColor()
    {

    }

    public void TranslateColorToNumber(char Colors)
    {

    }

  /*  public void TranslateNumberToColor (int number)
    {
        char Colors;

        for (int i = 0 ; i < conf.getNbrcolors(); i++)
        {
            if (i == number)
            {
                Colors = tab[i];
            }
        }


    }
    */
}








