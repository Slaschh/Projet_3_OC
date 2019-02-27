package Core;

import Affichage.Display;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameSelector {


    int jeux;


    Display inter = new Display();




    /**
     * Utilisation de l'inteface SelectMode pour le choix du mode
     */
    static final Logger logger = LogManager.getLogger(GameSelector.class);

    public void Choose()
    {
        logger.trace("Entering Selection Game");
        this.inter.DisplayAvailableGame();
        Scanner sc = new Scanner(System.in);
        jeux = sc.nextInt();
        if (jeux == 1) {
            logger.trace("Exiting Game Selector");
            Research game = new Research(this.inter);
            this.inter.DiplaySelectedGameResarch();
            game.SetGameModeResearch();

        } else if (jeux == 2) {
            logger.trace("Exiting Game Selector");
            Mastermind game = new Mastermind();
            this.inter.DisplaySelectedGameMastermind();
            game.setgamemastermind();

        } else {
            System.out.println("Erreur" + jeux);
            logger.error("error Selection");

        }

    }
}



