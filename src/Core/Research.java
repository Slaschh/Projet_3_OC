package Core;

import Affichage.Display;

import java.util.Scanner;

public class Research
{
    int mode;
    Display inter;

    public Research(Display inter)

    {
        this.inter = inter;
           }
    /**
     * Set Game Mode
     */

    public void SetGameModeResearch() {

        this.inter.DisplayAvailableMode();
        Scanner sc = new Scanner(System.in);
       mode = sc.nextInt();
        if (mode == 1) {
            this.inter.DisplaySelectedAttaque();
            ResearchAttaque game = new ResearchAttaque(this.inter);
            game.GameResearchAttaque();
        } else if (mode == 2) {
            this.inter.DisplaySelectedDefense();
            ResearchDefense game = new ResearchDefense(this.inter);
            game.GameResearchDefense();
        } else if (mode == 3) {
            this.inter.DisplaySelectedDuel();
            ResearchDuel game = new ResearchDuel(this.inter);
            game.GameDuelCore();
            /**
             * Mettre Methode class ResearchDuel
             */
        }
    }
}

