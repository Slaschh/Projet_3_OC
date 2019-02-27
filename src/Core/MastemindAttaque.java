package Core;

import Affichage.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;


public class MastemindAttaque {

    static final Logger logger = LogManager.getLogger(MastemindAttaque.class);

    Display inter = new Display();
    Config conf = null;

    Scanner sc = new Scanner(System.in);
    int[] tableauProposition;
    int[][] tableauTest;
    int[] Solution;

    int correctNumber;
    Random rand;
    int correct;
    boolean unCorrectPosition = false;
    int NbUncorrectColors;
    int Case;
    int colors;
    boolean victory = false;
    private char Colors;
    int nbCase;
    int nbColors;
    String solutionString;

    public MastemindAttaque() {
        logger.trace("Entering Mastermind Attaque");
        conf = Config.getInstance();
        tableauProposition = new int[conf.getNbcase()];
        tableauTest = new int[conf.getNbcase()][conf.getNbrcolors()];
        Solution = new int[conf.getNbcase()];
        rand = new Random();
        nbCase = conf.getNbcase();
        nbColors = conf.getNbrcolors();


    }

    /**
     * Parametre de classe et création des variable
     */


    /**
     * Création de la solution
     */

    public void SetSolution() {

        System.out.println("Entrez votre solution : ");
        int NbColors = conf.getNbrcolors();
        Scanner sc = new Scanner(System.in);
        solutionString = sc.next();

        for (int i = 0; i < conf.getNbcase(); i++) {
            Solution[i] = Integer.parseInt(String.valueOf(solutionString.charAt(i)));
        }
    }

    /**
     * On créer notre premier tableau avec le nombre de couleur choisi
     */
    public void CreationTableau() {

        for (int j = 0; j < conf.getNbcase(); j++) {
            Case++;
            for (int i = 0; i < conf.getNbrcolors(); i++) {
                colors++;
                tableauTest[j][i] = 0;
            }
        }
    }

/*
On viens chercher une valeur aléatoir dans chaque tableau
*/

    public void SetRandomPropositon() {
        for (int i = 0; i < conf.getNbcase(); i++) {
            tableauProposition[i] = rand.nextInt(conf.getNbrcolors());
        }
    }


    public void AnalyseSituation() {
        System.out.println("Analyse");
        for (int Case = 0; Case < conf.getNbcase(); Case++) {

            for (int colors = 0; colors < conf.getNbrcolors(); colors++) {

                if (tableauTest[Case][colors] == 2) {
                    correctNumber++;
                    tableauProposition[Case] = colors;


                    if (correctNumber == conf.getNbcase()) {
                        inter.AffichageProposition(tableauProposition);
                        victory = true;
                    }
                } else {

                }
            }
        }
    }

    public void ConsultationTableauTest() {
        for (int i = 0; i < conf.getNbcase(); i++) {

            for (int j = 0; j < conf.getNbrcolors(); j++) {
                System.out.print(tableauTest[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void SetProposition() {

        int Case = 0;

        RandomProposition(nbCase, nbColors, Case);


    }

    public void RandomProposition(int nbCase, int nbColors, int Case) {

        if (nbCase == Case) {
            inter.AffichageProposition(tableauProposition);
        } else {
            int Colors = rand.nextInt(nbColors);

            if (tableauTest[Case][Colors] == 0) {
                tableauProposition[Case] = Colors;
                RandomProposition(nbCase, nbColors, Case + 1);
            } else {
                RandomProposition(nbCase, nbColors, Case);
            }
        }
    }
    /*
    On compare la proposition aléatoire avec la solution.
     */

    public void ComparePropositionAndSolution() {
        correctNumber = 0;
        NbUncorrectColors = 0;
        correct = 0;

        for (int i = 0; i < conf.getNbcase(); i++) {
            if (Solution[i] == tableauProposition[i]) {
                correct = correct + 1;
                tableauTest[i][tableauProposition[i]] = 2;
            }
        }

        System.out.println("Nombre de bonne combinaison : " + correct);


        for (int i = 0; conf.getNbcase() > i; i++) {
            unCorrectPosition = false;
            for (int j = 0; conf.getNbcase() > j & unCorrectPosition == false; j++) {
                if (Solution[j] == tableauProposition[i]) {
                    unCorrectPosition = true;
                    NbUncorrectColors = NbUncorrectColors + 1;
                    if (tableauTest[i][tableauProposition[i]] != 2) {
                        tableauTest[i][tableauProposition[i]] = 1;
                    }
                }

            }

        }
        System.out.println("Nombre de couleur présente : " + NbUncorrectColors);

        for (int i = 0; i < conf.getNbcase(); i++) {
            boolean noColors = false;
            for (int j = 0; j < conf.getNbcase() & noColors == true; j++) {
                if (Solution[j] != tableauProposition[i]) {
                    noColors = true;
                    NbUncorrectColors++;

                    if (NbUncorrectColors == conf.getNbcase()) {
                        tableauTest[j][i] = -1;
                    }
                }

            }
        }
    }


    public void MastermindAttaqueCore() {
        SetSolution();
        CreationTableau();


        for (int i = 0; i < conf.getNbrtry() & victory == false; i++) {


            SetProposition();
            ComparePropositionAndSolution();
            AnalyseSituation();
            System.out.println();
            System.out.println("Essai N° " + i);

        }
        if (victory == false) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("            Loose !!!!          ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }

        if (victory == true) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("          Victory !!!!          ");
            System.out.println("--------------------------------");
            System.out.println();
            GameSelector newGame = new GameSelector();
            newGame.Choose();
        }

    }
}






