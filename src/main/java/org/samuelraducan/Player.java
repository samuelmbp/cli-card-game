package org.samuelraducan;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private final List<Card> playersCards;
    private int score;

    public Player(String name) {
        this.name = name;
        this.playersCards = new ArrayList<>();
        this.score = 0;
    }

    public void drawCard(Card card) {
        playersCards.add(card);
    }

    public void removeCard(Card card) {
        playersCards.remove(card);
    }

    public void getCardCount() {
        for(Card card : playersCards) {
            System.out.println(card);
        }
    }

    public Card getCard(int position) {
        if (position < 0 || position >= playersCards.size()) {
            System.out.println("Invalid position. Please enter a position between 0 and " +
                    (playersCards.size() - 1));
            return null;
        }

        return playersCards.get(position);
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    public void clearCards() {
        playersCards.clear();
    }


    public int getScore() {
        return score;
    }
}
