package org.samuelraducan.sanjida;

public class Rules {
    private String rules = "The rules of the game are as follows: \n" +
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
//If you capture a King, that is good: all players give you 5 cards.
//If you capture a Queen, that is bad: you award 5 cards to all players.


// if the player gets a K then they get 5 cards from the player
// if the player gets a Q, then they GIVE 5 cards to the player
// and if neither, then whoever has the highest value wins and keeps both cards