package org.samuelraducan.samuel;

import org.samuelraducan.Card;

public class WildCard extends Card {

    private static final int WILD_CARD_VALUE = 14;
    private static final int WILD_CARD_SCORE = 20;

    public WildCard(String suit, String symbol, int value) {
        super(suit, symbol, value);
    }

    public void handleAceCard() {
        if (getValue() == WILD_CARD_VALUE) {
            System.out.println("I am setting value to 20");
            System.out.println("New value" + getValue());
            setValue(WILD_CARD_SCORE);
        }
    }
}
