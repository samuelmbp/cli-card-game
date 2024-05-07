package org.samuelraducan;

public class Card implements Comparable<Card> {

    private final String suit;
    private final String symbol;
    private final int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }


    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String suitSymbol = "";
        switch (suit) {
            case "\u2764":
                suitSymbol = "♥";
                break;
            case "\u2600":
                suitSymbol = "♦";
                break;
            case "\u2666":
                suitSymbol = "♣";
                break;
            case "\u2663":
                suitSymbol = "♠";
                break;
        }
        return String.format("%-2s%s %-8s", symbol, suitSymbol, "(" + value + ")");
    }


    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.value, other.value);
    }
}