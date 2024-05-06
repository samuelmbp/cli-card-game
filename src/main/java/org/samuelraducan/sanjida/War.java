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
        this.computer = new Player();
        this.player = setUpPlayer();
    }

    public void displayPlayerCardAscii(Card card) {
        String cardAscii = CardAscii.generateCardAscii(card);
        System.out.println(cardAscii);
    }

    public void displayComputerCardAscii(Card card) {
        String cardAscii = CardAscii.generateCardAscii(card);
        System.out.println(cardAscii);
    }

    private Player setUpPlayer() {
//        gameConsole.promptPlayerName();   --> try refactor using this
        System.out.println("Please enter your name");
        String player1Name = scanner.nextLine();
        System.out.println("Player 1: " + player1Name);
        return new Player(player1Name);
    }

    public void declareWinner(LinkedList<Card> playerDeck, LinkedList<Card> computerDeck) {
        // this isnt working
        if (playerDeck.isEmpty() || player.getScore() >= 100) {
            System.out.println("Computer has won");
        } else if (computerDeck.isEmpty() || computer.getScore() >= 100) {
            System.out.println(player.getName() + " has won!!");
        }
    }

    public void startGame() {
        while (true) {
            System.out.println("Please press 1 to play, or 2 to see the rules");
            String usersInput = scanner.nextLine();
            if (usersInput.equals("1")) {
                break;
            } else if (usersInput.equals("2")) {
                printRules();
                System.out.println();
            } else {
                System.out.println("Invalid input. Please press 1 or 2");
                System.out.println();
            }
        }
    }

    // i want to create options for the user

    @Override
    public void play() {
        gameConsole.welcomeMessage("War");
        startGame();
        deckOfCards.shuffleDeck();

        LinkedList<Card> playerDeck = new LinkedList<>();
        LinkedList<Card> computerDeck = new LinkedList<>();
        playerDeck.addAll(deckOfCards.getDeckOfCards().subList(0, 26));
        computerDeck.addAll(deckOfCards.getDeckOfCards().subList(26, deckOfCards.getDeckOfCards().size()));
        UserCommands userCommands = new UserCommands(deckOfCards, player, computer, playerDeck, computerDeck, scanner);


        while (!playerDeck.isEmpty() && !computerDeck.isEmpty()) {
            userCommands.printOptions(); // Display user options after each round
        }

    // Game ends when one of the decks is empty
        // fix this logic
       declareWinner(playerDeck, computerDeck);

    }

    @Override
    public boolean playAgain() {
        deckOfCards.resetDeck(); // error
            // add override logic here
        return false;
    }
}
