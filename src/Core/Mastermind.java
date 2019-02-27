package Core;

import Affichage.Display;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mastermind {

    static final Logger logger = LogManager.getLogger(GameSelector.class);

    Display inter = new Display();

    int jeux;

    Config conf = null;

    /**
     * Création d'un tableau de convertion pour les class attaque et defense
     */

    static char[] tab = new char[10];

    public Mastermind()
    {
        conf = Config.getInstance();
    }


    public void setgamemastermind() {
        logger.trace("Entering MasterMind Selection");
        this.inter.DisplayAvailableMode();
        Scanner sc = new Scanner(System.in);
        jeux = sc.nextInt();
        if (jeux == 3)
        {
            MastermindDuel game = new MastermindDuel();
            game.MasterMindDuelCore();
        }

        if (jeux == 1) {
            MastermindDefense game = new MastermindDefense();
            logger.trace("Exiting MasterMind Selection ");
            game.Core();
        }
        if (jeux == 2) {
            MastemindAttaque game = new MastemindAttaque();
            logger.trace("Exiting MasterMind Selection");
            game.MastermindAttaqueCore();

        } else {
            logger.error("Invalid entering");
        }
    }


    /**
     * Methode to convert char to number
     */









}
