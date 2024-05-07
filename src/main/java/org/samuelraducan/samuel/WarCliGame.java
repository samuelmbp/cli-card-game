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
        this.player = new Player();
        this.computer = new Player();
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.console = new GameConsole();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
       initializeGame();

        while (!deck.getDeckOfCards().isEmpty()) {
            System.out.println("Press Enter to reveal your card...");
            scanner.nextLine();


            Card playerCard = deck.dealCard();
            Card computerCard = deck.dealCard();

            processRound(playerCard, computerCard);
//            promptNextRound();

            player.removeCard(playerCard);
            computer.removeCard(computerCard);
        }

        endGame();
        scanner.close();
    }

    @Override
    public boolean playAgain() {
        while (true) {
            System.out.println();
            System.out.print("Would you like to play again? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (!input.isEmpty()) {
                if (input.equals("yes")) {
                    resetGame();
                    play();
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

    private void initializeGame() {
        String playerName = promptPlayerName();
        player.setName(playerName);
        console.welcomeMessage(playerName);
        printTitle();
        System.out.println(WarRules.getRules());
    }

    private String promptPlayerName() {
        System.out.println("Hello Warrior! Please enter your name to get started: ");
        return scanner.nextLine();
    }

    private void processRound(Card playerCard, Card computerCard) {
        if(playerCard.getValue() == 14) {
            player.increaseScore(15);
            System.out.println("Nice one. You got an extra 15 points because of your ACE.");
        }

        if (computerCard.getValue() == 14) {
            computer.increaseScore(15);
            System.out.println("Nice one. You got an extra 15 points because of your ACE.");
        }

        String playerCardAscii = playerCard.generateAsciiArt();
        String computerCardAscii = computerCard.generateAsciiArt();

        console.displayGameState(player, computer, playerCardAscii, computerCardAscii);
        System.out.println();
        determineWinner(playerCard, computerCard);
        System.out.println();
        displayScores();
        promptNextRound();
    }

    private void displayScores() {
        System.out.printf("%s's score: %d\n", player.getName(), player.getScore());
        System.out.printf("Computer's score: %d\n", computer.getScore());
    }

    private void promptNextRound() {
        if (!deck.getDeckOfCards().isEmpty()) {
            System.out.println();
            System.out.println("Press Enter to continue to the next round...");
            scanner.nextLine();
        }
    }

    private void endGame() {
        console.displayGameState(player, computer);

        if (player.getScore() > computer.getScore()) {
            System.out.println();
            System.out.printf("Congratulations, %s! You win with a score of %d.", player.getName(), player.getScore());
        } else if (player.getScore() < computer.getScore()) {
            System.out.println();
            System.out.printf("Computer wins with a score of %d.", computer.getScore());
        } else {
            System.out.println();
            // TODO: When two cards are the same, implement the logic for a WAR instead of print it's a tie.
            // Think what the war will do?...
            System.out.println("It's a tie!");
        }

        playAgain();
    }

    private void determineWinner(Card playerCard, Card computerCard) {
        if (playerCard.getValue() > computerCard.getValue()) {
            System.out.printf("%s won this round!", player.getName());
            player.increaseScore(10);
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("Computer won this round!");
            computer.increaseScore(10);
        } else {
            System.out.println("It's a tie!");
        }
    }

    private void resetGame() {
        deck.resetDeck();
        deck.shuffleDeck();
        player.clearCards();
        computer.clearCards();

        System.out.println();
        System.out.println("Starting a new game...");
        System.out.println("Press Enter...");
        scanner.nextLine();
    }
}
