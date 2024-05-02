package org.samuelraducan;

public class Main {
    public static void main(String[] args) {
        System.out.println("CLI Card Game");

        Deck deck = new Deck();
        System.out.println(deck.getDeckOfCards().stream().count());

//        for(Card card : deck.getDeckOfCards()) {
//            System.out.println(card);
//        }

        Card firstCard = deck.dealCard();
        System.out.println(firstCard);

    }
}