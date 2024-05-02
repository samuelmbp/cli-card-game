package org.samuelraducan;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> deckOfCards;

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public Deck() {
        this.deckOfCards = new ArrayList<>();
        populateDeckCards();
    }

    public Card dealCard() {
        if(this.deckOfCards.isEmpty()) {
            System.out.println("The deck of cards is empty.");
            return null;
        }

        return deckOfCards.remove(0);
    }

    private void populateDeckCards() {
        String[] suits = {"u2764", "u2600", "u2666", "u2663" };
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 13, 14};

        for (String suit: suits) {
            for (int i = 0; i < symbols.length; i++) {
                Card card = new Card(suit, symbols[i], values[i]);
                deckOfCards.add(card);
            }
        }
    }
}
