package org.samuelraducan.sanjida;

import org.samuelraducan.*;

import java.util.LinkedList;
import java.util.Scanner;

public class GoodKingBadQueen extends Game {
    private GameConsole gameConsole;
    private Deck deckOfCards;
    private Player player;
    private Player computer;
    private Scanner scanner;

    public GoodKingBadQueen(String title, String rules) {
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

    public void declareWinner(LinkedList<Card> playerDeck,  LinkedList<Card> computerDeck) {
        if (playerDeck.isEmpty() || computer.getScore() == 20) {
            System.out.println("Computer wins!");
        } else if (computerDeck.isEmpty() || player.getScore() == 20) {
            System.out.println("Player wins!");
        }

        if (playAgain()) {
            play();
        } else {
            System.out.println("Thanks for playing!");
        }
    }


    @Override
    public void play() {

        LinkedList<Card> playerDeck = new LinkedList<>();
        LinkedList<Card> computerDeck = new LinkedList<>();
        UserCommands userCommands = new UserCommands(deckOfCards, player, computer, playerDeck, computerDeck, scanner);

        gameConsole.welcomeMessage("War");
        startGame();
        deckOfCards.shuffleDeck();
        playerDeck.addAll(deckOfCards.getDeckOfCards());
//        playerDeck.addAll(deckOfCards.getDeckOfCards().subList(0, 26));
        computerDeck.addAll(deckOfCards.getDeckOfCards());
//        computerDeck.addAll(deckOfCards.getDeckOfCards().subList(26, deckOfCards.getDeckOfCards().size()));


        while (!playerDeck.isEmpty() && !computerDeck.isEmpty()) {
            userCommands.printOptions();
        }

        // fix this logic - not working
       declareWinner(playerDeck, computerDeck);
    }


    // double check play again method
    @Override
    public boolean playAgain() {
        String usersInput;

        while (true) {
            System.out.println();
            System.out.print("Play again? (yes/no): ");
            usersInput = scanner.nextLine();
            if (!usersInput.isEmpty()) {
                if (usersInput.equalsIgnoreCase("yes")) {
                    deckOfCards.resetDeck();
                    deckOfCards.shuffleDeck();
                    play();
                } else if (usersInput.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing!");
                }
            } else {
              return false;
            }
        }
    }

}


// toDo
// fix declareWinner method
// fix playAgain method
// refactor queen and king method
// fix card ascii