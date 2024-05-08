package org.samuelraducan.samuel;

import org.samuelraducan.*;

import java.util.ArrayList;
import java.util.List;
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

    private void determineWinner(Card playerCard, Card computerCard) {
        if (playerCard.getValue() > computerCard.getValue()) {
            System.out.printf("%s won this round!", player.getName());
            player.increaseScore(10);
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("Computer won this round!");
            computer.increaseScore(10);
        } else {
            initiateWar(playerCard, computerCard);
        }
    }

    private void initiateWar(Card playerCard, Card computerCard) {
        System.out.println("It's a tie! WAR begins...");
        List<Card> playerWarCards = new ArrayList<>();
        List<Card> computerWarCards = new ArrayList<>();


        /**
         * TODO: Generate ascii for the 3 cards player and computer...
         *  String playerCardAscii = playerCard.generateAsciiArt();
         *  String computerCardAscii = computerCard.generateAsciiArt();
         */
        // TODO: Shall I deal only 2 cards during the war?
        if (deck.getDeckOfCards().size() >= 5) {
            for (int i = 0; i < 3; i++) {
                playerWarCards.add(deck.dealCard());
                computerWarCards.add(deck.dealCard());
            }

            Card playerFourthCard = deck.dealCard();
            Card computerFourthCard = deck.dealCard();

            System.out.println("Player's WAR cards: " + playerWarCards);
            System.out.println("Computer's WAR cards: " + computerWarCards);
            System.out.println("Player's fourth card: " + playerFourthCard);
            System.out.println("Computer's fourth card: " + computerFourthCard);

            determineWarWinner(playerFourthCard, computerFourthCard);
        } else {
            System.out.println("Not enough cards to continue the war. Game ends in a tie.");
            endGame();
        }
    }

    private void determineWarWinner(
                                    Card playerFourthCard, Card computerFourthCard) {
        int playerFourthValue = playerFourthCard.getValue();
        int computerFourthValue = computerFourthCard.getValue();

        if (playerFourthValue > computerFourthValue) {
            System.out.println("Player wins the WAR with the fourth card!");
            player.increaseScore(30);  // Player wins 30 extra points
        } else if (playerFourthValue < computerFourthValue) {
            System.out.println("Computer wins the WAR with the fourth card!");
            computer.increaseScore(30);  // Computer wins 30 extra points
        } else {
            // Handle tie if the fourth cards have equal value
            System.out.println("Fourth card tie! No extra points awarded.");
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
            System.out.println("It's a tie!");
        }

        playAgain();
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
