package org.samuelraducan.sanjida;

import org.samuelraducan.Game;

public class War extends Game {

    public War(String title, String rules) {
        super("War", "The rules of the game are as follows: Each player turns up a card at the same time. \n " +
                "The player with the higher card takes both cards and wins that round. \n " +
                "If the cards are of the same rank, it is War. Both players turn another card, and the player with the higher card takes all cards in the pile. \n" +
                "The player with the most cards win the game");
    }

    @Override
    public void play() {

    }

    @Override
    public boolean playAgain() {
        return false;
    }
}
