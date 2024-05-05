package org.samuelraducan.sanjida;

import org.samuelraducan.*;

import java.util.LinkedList;
import java.util.Scanner;

public class War extends Game {
    private GameConsole gameConsole;
    private Deck deckOfCards;
    private Player player;
    private Player computer;
    private Scanner scanner;

    public War(String title, String rules) {
        super(title, rules);
        this.scanner = new Scanner(System.in);
        this.gameConsole = new GameConsole();  // initialises the game console
        this.deckOfCards = new Deck();
    }

    public void startGame() {
       String usersInput = scanner.nextLine();
        if (usersInput.equals("1")) {
        } else if (usersInput.equals("2")) {
            printRules();
            System.out.println();
            System.out.println("Please press 1 to play, or 2 to see the rules");
            startGame();
        } else {
            System.out.println("Invalid input. Please press 1 or 2");
            System.out.println();
            System.out.println("Please press 1 to play, or 2 to see the rules");
            startGame();
        }
    }


//    public void

//    deck1.addAll(deckOfCards.sublist())
    @Override
    public void play() {
        gameConsole.welcomeMessage("War");
        System.out.println("Please press 1 to play, or 2 to see the rules");
        startGame();

        deckOfCards.shuffleDeck();
        LinkedList<Card>deck1 = new LinkedList<>();
        LinkedList<Card>deck2 = new LinkedList<>();
        deck1.addAll(deckOfCards.getDeckOfCards().subList(0, 26));              //26 cards for p1
        deck2.addAll(deckOfCards.getDeckOfCards().subList(26, deckOfCards.getDeckOfCards().size()));
//        System.out.println(deck1);
//        System.out.println(deck2);
//        System.out.println(deck1.stream().distinct().count());
//        System.out.println(deck2.stream().distinct().count());

        Card player1Card = deck1.pop();
        Card player2Card = deck2.pop();
        System.out.println(player1Card.toString());
        System.out.println(player2Card.toString());
        System.out.println(deck2.stream().distinct().count());
        // add override logic here
    }

    @Override
    public boolean playAgain() {
            // add override logic here
        return false;
    }
}
