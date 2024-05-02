package org.samuelraducan;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("CLI Card Game");

        Deck deck = new Deck();
        System.out.println(deck.getDeckOfCards().stream().count());

//        Card firstCard = deck.dealCard();
//        System.out.println(firstCard);

//        deck.sortDeck();


//        deck.sortDeck(Comparator.comparing(Card::getSuit));

        deck.shuffleDeck();

        deck.dealCard();
        deck.dealCard();
        deck.dealCard();
        deck.dealCard();

        System.out.println(deck.getDeckOfCards().stream().count());

//        deck.resetDeck();

        deck.printDeck();
    }
}