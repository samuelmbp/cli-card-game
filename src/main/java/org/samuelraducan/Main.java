package org.samuelraducan;

import org.samuelraducan.samuel.ClashOfCards;
import org.samuelraducan.samuel.WarRules;

public class Main {
    public static void main(String[] args) {
        Game game;

        ChooseGame gameLoader = new GameLoader();
        do {
            gameLoader.printGames();
            game = gameLoader.chooseGame();
            game.printRules();
            game.play();
        } while (game.playAgain());
    }
}