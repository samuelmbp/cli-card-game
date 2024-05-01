package org.samuelraducan;

public class Main {
    public static void main(String[] args) {
        System.out.println("CLI Card Game");

        Card card = new Card("a", "a", 1);
        System.out.println(card);

        Deck deck = new Deck();
        System.out.println(deck.getDeckOfCards());

    }
}