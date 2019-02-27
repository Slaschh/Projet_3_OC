package Core;

import Affichage.Display;

public class MastermindDuel {

    Display inter;
    MastemindAttaque attaque;
    MastermindDefense defense;

    public MastermindDuel() {
        this.inter = inter;
        this.defense = defense;
        this.attaque = attaque;
    }

    public void MasterMindDuelCore() {
        MastemindAttaque attaque = new MastemindAttaque();
        MastermindDefense defense = new MastermindDefense();
        System.out.println("Definition solution user : ");
        attaque.SetSolution();
        attaque.CreationTableau();

        System.out.println("definition de la solution computer");
        defense.SetRandomSolution();

        if (defense.conf.getDevelloperMode() == true) {
            System.out.print("La solution est : ");
            for (int solution : defense.Solution) {
                System.out.print(solution);
            }
            System.out.println();
        }


        for (int i = 0; i < attaque.conf.getNbrtry() && defense.victory == false && attaque.victory == false; i++) {

            System.out.println();
            System.out.println("Computer ");
            attaque.SetProposition();
            attaque.ComparePropositionAndSolution();
            attaque.AnalyseSituation();
            System.out.println("user ");
            defense.SetUserTry();
            defense.Research();


        }
        if (attaque.victory == true) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("        User Victory !!!!       ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }
        if (defense.victory == true) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("      Computer Victory !!!!     ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }

    }
}
