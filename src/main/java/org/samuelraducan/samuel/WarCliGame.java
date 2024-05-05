package org.samuelraducan.samuel;

import org.samuelraducan.*;
import java.util.Scanner;

public class WarCliGame extends Game {
    private final Player player;
    private final Player computer;
    private final Deck deck;
    private final GameConsole console;
    Scanner scanner;

    public WarCliGame(String title, String rules) {
        super(title, rules);
        this.player = new Player("Samuel");
        this.computer = new Player();
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.console = new GameConsole();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        String playerName = promptPlayerName();
        printTitle();

        System.out.println(WarRules.getRules());
        console.welcomeMessage(playerName);

        while (!deck.getDeckOfCards().isEmpty()) {
            System.out.println("Press Enter to reveal your card...");
            scanner.nextLine();

            Card playerCard = deck.dealCard();
            Card computerCard = deck.dealCard();

            console.displayGameState(player, computer, playerCard, computerCard);


            if (playerCard.getValue() > computerCard.getValue()) {
                System.out.printf("%s won this round!", player.getName());
                player.increaseScore();
            } else if (playerCard.getValue() < computerCard.getValue()) {
                computer.increaseScore();
                System.out.println("Computer won this round!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println();
            if (!deck.getDeckOfCards().isEmpty()) {
                System.out.println("Press Enter to continue to the next round...");
                scanner.nextLine();
            }

            player.removeCard(playerCard);
            computer.removeCard(computerCard);
        }

        console.displayGameState(player, computer);

        if (player.getScore() > computer.getScore()) {
            System.out.printf("Congratulations, %s! You win with a score of %d.", player.getName(), player.getScore());
        } else if (player.getScore() < computer.getScore()) {
            System.out.printf("Computer wins with a score of %d.", computer.getScore());
        } else {
            System.out.println("It's a tie!");
        }

        playAgain();
        scanner.close();
    }

    @Override
    public boolean playAgain() {
        while (true) {
            System.out.print("Would you like to play again? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (!input.isEmpty()) {
                if (input.equals("yes")) {
                    resetGame();
                    return true;
                } else if (input.equals("no")) {
                    System.out.println("Thank you for playing! Goodbye!");
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    private void resetGame() {
        deck.resetDeck();
        deck.shuffleDeck();
        player.clearCards();
        computer.clearCards();

        System.out.println("Starting a new game...");
    }

    private String promptPlayerName() {
        System.out.println("Please enter your name:");
        return scanner.nextLine();
    }
}
