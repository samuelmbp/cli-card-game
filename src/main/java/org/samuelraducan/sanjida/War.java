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

    private Player setUpPlayer() {
//        gameConsole.promptPlayerName();   --> try refactor using this
        System.out.println("Please enter your name");
        String player1Name = scanner.nextLine();
        System.out.println("Player 1: " + player1Name);
        return new Player(player1Name);
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

        UserCommands userCommands = new UserCommands(deckOfCards, player, computer, scanner);
        userCommands.printOptions();


        LinkedList<Card>deck1 = new LinkedList<>();
        LinkedList<Card>deck2 = new LinkedList<>();
        deck1.addAll(deckOfCards.getDeckOfCards().subList(0, 26));
        deck2.addAll(deckOfCards.getDeckOfCards().subList(26, deckOfCards.getDeckOfCards().size()));


        // linking player and comp card to
        Card playersCard = deck1.pop();
        Card computersCard = deck2.pop();
        System.out.println( player.getName() + "'s card: " + playersCard.toString());
        System.out.println("Computer's card: " + computersCard.toString());

        if(playersCard.getValue() > computersCard.getValue()) {
           this.player.increaseScore();  // whoever wins takes both set of cards
        } else {
            this.computer.increaseScore();
        }
        gameConsole.displayGameState(this.player, computer);
//        System.out.println(deck1.stream().distinct().count());
    }


    @Override
    public boolean playAgain() {
            // add override logic here
        return false;
    }
}
