package org.samuelraducan.sanjida;

import org.samuelraducan.Deck;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.Scanner;

public class UserCommands {
    private Deck deck;
    private GameConsole gameConsole;
    private Player player;
    private Player computer;
    private Scanner scanner;


    private static final String[] USER_COMMANDS = {
            "Deal next set of cards",
            "Shuffle the deck of cards",
            "See game score",
            "Check number of cards",
            "Quit game"
    };

    public UserCommands(Deck deck, Player player, Player computer, Scanner scanner) {
        this.deck = deck;
        this.player = player;
        this.computer = computer;
        this.scanner = scanner;
        this.gameConsole = new GameConsole();
    }

    public void printOptions() {
        System.out.println("Select an option:");
        for (int i = 0; i < USER_COMMANDS.length; i++) {
            System.out.println((i + 1) + ". " +  USER_COMMANDS[i]);
        }

        int userSelection = scanner.nextInt();
        handleUserSelection(userSelection);
    }
    public boolean handleUserSelection(int userSelection) {
        System.out.println("Performing the user's option " + userSelection);

        while (true) {
            switch (userSelection) {
                case 1:
                    deck.dealCard();
                    break;
                case 2:
                    deck.shuffleDeck();
                    break;
                case 3:
                    gameConsole.displayGameState(player, computer);
                    break;
                case 4:
                    System.out.println("Number of cards remaining: " + deck.getDeckOfCards().size());
                    break;
                case 5:
                    System.out.println("Quitting the game...");
                    return false;
                default:
                    System.out.println("Invalid option. Please select a number between 1 and 5.");
            }

            return true;
        }
    }
}
