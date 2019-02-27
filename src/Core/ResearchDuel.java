package Core;

import Affichage.Display;

public class ResearchDuel {
    Display inter;
    ResearchAttaque attaque;
    ResearchDefense defense;
    Config conf = null;
    boolean victory = false;

    public ResearchDuel(Display inter) {
        this.inter = inter;
        this.defense = defense;
        this.attaque = attaque;
        conf = Config.getInstance();

    }

    public void GameDuelCore() {
        ResearchAttaque attaque = new ResearchAttaque(this.inter);
        ResearchDefense defense = new ResearchDefense(this.inter);

        System.out.println("Définition de la solution Computer");
        attaque.SetRandomNumber();
        if(conf.getDevelloperMode() == true)
        {
            System.out.print("La solution est : ");
            for (int solution : attaque.solution )
            {
                System.out.print(solution);
            }
            System.out.println();

        }

        System.out.println("Définition de la solution user");
        defense.SetSolutionUser();
        defense.InitialisationDesLimites();


        for (int i = 0 ; i < conf.getNbrtry() && attaque.victory == false && defense.victory == false ; i++)
        {
            System.out.println("User : ");
            attaque.setNumber_User();
            attaque.ConversionStringInt();
            attaque.ResearchCore();

            System.out.println();
            System.out.println("Computer : ");
            defense.SetSolutioncomputer();
            defense.ResearchDichotomique();
        }

        if(attaque.victory==true)
        {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("        Compuet Victory !!!!       ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }
        if(defense.victory==true)
        {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("      User Victory !!!!     ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }
        else
        {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("            Loose !!!!          ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }
        }

        /**

         if (defense.intermediaire == defense.solutionUser) {
         }

         if (attaque.tryleft == 0) {


         } else if (attaque.numberUser == attaque.solution) {
         inter.DisplayVictoryResearchAttaque(attaque.nbtry);
         }
         **/
    }







