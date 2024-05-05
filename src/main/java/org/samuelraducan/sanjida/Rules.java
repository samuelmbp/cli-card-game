package org.samuelraducan.sanjida;

public class Rules {
    private String rules = "The rules of the game are as follows: \n" +
            "Each player turns up a card at the same time. \n" +
            "The player with the higher card takes both cards and wins that round. \n" +
            "If the cards are of the same rank, it is War.\n" +
            "Both players turn another card, and the player with the higher card takes all cards in the pile. \n" +
            "The player with the most cards win the game";

    public String getRules() {
        return rules;
    }
}
