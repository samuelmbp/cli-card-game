package org.samuelraducan;

import org.samuelraducan.sanjida.GoodKingBadQueen;

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