package org.samuelraducan.sanjida;

public class Rules {
    private String rules =  "The rules of the game are as follows: \n" +
            "Each player turns up a card at the same time. \n" +
            "The player with the highest card takes both cards and wins that round. \n" +
            "If the cards are of the same rank, it is a tie.\n" +
            "But if you can capture a King, you are awarded 5 cards from your opponent. \n" +
            "However, if you capture a Queen, you lose 5 cards \n" +
            "The player with the most cards win the game";

    public String getRules() {
        return rules;
    }
}
