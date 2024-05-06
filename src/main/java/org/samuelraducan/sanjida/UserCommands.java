package org.samuelraducan.sanjida;

import org.samuelraducan.Card;
import org.samuelraducan.Deck;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.LinkedList;
import java.util.Scanner;

public class UserCommands {
    private Deck deck;
    private GameConsole gameConsole;
    private Player player;
    private Player computer;
    private Scanner scanner;
    private War war;
    private LinkedList<Card> playerDeck;
    private LinkedList<Card> computerDeck;

    private static final String[] USER_COMMANDS = {
            "Deal next set of cards",
            "Shuffle the deck of cards",
            "See game score",
            "Check number of cards",
            "Quit game"
    };
        // ADD PLAY AGAIN OPTION

    public UserCommands(Deck deck, Player player, Player computer, LinkedList<Card> playerDeck, LinkedList<Card> computerDeck, Scanner scanner) {
        this.deck = deck;
        this.player = player;
        this.computer = computer;
        this.playerDeck = playerDeck;
        this.computerDeck = computerDeck;
        this.scanner = scanner;
        this.gameConsole = new GameConsole();
    }

    public void printOptions() {

        while (true) {
            System.out.println();
            System.out.println("Select an option:");
            for (int i = 0; i < USER_COMMANDS.length; i++) {
                System.out.println((i + 1) + ". " + USER_COMMANDS[i]);
            }

            int userSelection = scanner.nextInt();
            handleUserSelection(userSelection);
        }
    }

    public boolean handleUserSelection(int userSelection) {
        System.out.println("Performing the user's option: " + userSelection);
        System.out.println();

        switch (userSelection) {
            case 1:
                dealNextSetOfCards();
                break;
            case 2:
                deck.shuffleDeck();
                System.out.println("Cards have been shuffled");
                break;
            case 3:
                gameConsole.displayGameState(player, computer);
                break;
            case 4:
//                war.playAgain(); // give play again method
                System.out.println(player.getName() + "'s number of cards: " + playerDeck.size());
                System.out.println("Computer's number of cards: " + computerDeck.size());
                break;
            case 5:
                System.out.println("Quitting the game..."); ///error
                return false;
            default:
                System.out.println("Invalid option. Please select a number between 1 and 5.");
        }

        return true;
    }

    private void dealNextSetOfCards() {
        if (!playerDeck.isEmpty() && !computerDeck.isEmpty()) {
            Card playersCard = playerDeck.pop();
            Card computersCard = computerDeck.pop();

//            System.out.println(player.getName() + "'s card: " + playersCard.toString());
//            System.out.println("Computer's card: " + computersCard.toString());

            System.out.println(player.getName() + "'s card:");
            displayCardAscii(playersCard);
            System.out.println("Computer's card:");
            displayCardAscii(computersCard);


            if (playersCard.getValue() > computersCard.getValue()) {
                playerDeck.addLast(playersCard);
                playerDeck.addLast(computersCard);
                this.player.increaseScore();
                System.out.println(player.getName() + " wins this round!");
            } else if (playersCard.getValue() < computersCard.getValue()) {
                computerDeck.addLast(playersCard);
                computerDeck.addLast(computersCard);
                this.computer.increaseScore();
                System.out.println("Computer wins this round!");
            } else {
                // WAR logic goes here
                System.out.println("WAR");
            }
            gameConsole.displayGameState(player, computer);
        } else {
            System.out.println("The game is already over. Please select another option.");
        }
    }

    private void displayCardAscii(Card card) {
        String cardAscii = CardAscii.generateCardAscii(card);
        System.out.println(cardAscii);
    }
}


