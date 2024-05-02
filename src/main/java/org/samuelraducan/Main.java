package org.samuelraducan;

public class Main {
    public static void main(String[] args) {
        System.out.println("CLI Card Game");

        Deck deck = new Deck();
        System.out.println(deck.getDeckOfCards().stream().count());

        deck.shuffleDeck();

        deck.dealCard();
        deck.dealCard();
        deck.dealCard();
        deck.dealCard();

        System.out.println(deck.getDeckOfCards().stream().count());

//        deck.resetDeck();

//        deck.printDeck();
//        deck.resetDeck();

        Card card1 = new Card("diamond", "♦️", 2);
        Card card2 = new Card("diamond", "♦️", 3);
        Card card3 = new Card("diamond", "♦️", 4);
        Card card4 = new Card("diamond", "♦️", 5);
        Player sanjida = new Player("Sanjida");

        sanjida.drawCard(card1);
        sanjida.drawCard(card2);
        sanjida.drawCard(card3);
        sanjida.drawCard(card4);
//        sanjida.getCardCount();

        Card test = sanjida.getCard(4);
        System.out.println(test);

        sanjida.getCardCount();
        System.out.println(sanjida.getScore());
        sanjida.removeCard(card1);
        sanjida.getCardCount();
        sanjida.increaseScore(10);
        System.out.println(sanjida.getScore());


    }
}