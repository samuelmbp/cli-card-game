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
        String playerName;
        System.out.println("********************************************");
        System.out.println("*                                          *");
        System.out.println("*        Welcome to the War Game!          *");
        System.out.println("*                                          *");
        System.out.println("********************************************");
        System.out.println();
        do {
//            System.out.println("Hello Warrior! Please enter your name to get started: ");
            playerName = promptPlayerName();
            if (playerName.isEmpty()) {
                System.out.println("Name cannot be empty! Please enter a valid name.");
            }
        } while(playerName.isEmpty());

        player.setName(playerName);
        System.out.println();
        System.out.println("Great! You're ready to begin, " + playerName + ".");
        System.out.println();
        console.welcomeMessage(playerName);
        printTitle();
        System.out.println(WarRules.getRules());
    }

    private String promptPlayerName() {
        System.out.println("Please enter your name to get started: ");
        return scanner.nextLine().trim();
    }

    private void processRound(Card playerCard, Card computerCard) {
        if(playerCard.getValue() == 14) {
            player.increaseScore(15);
            System.out.println("Nice one! " + player.getName() + " gets an extra 15 points because of their ACE.");
        }

        if (computerCard.getValue() == 14) {
            computer.increaseScore(15);
            System.out.println("Nice one! The computer gets an extra 15 points because of its ACE.");
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
            System.out.println("=".repeat(30));
            System.out.printf("%s won this round!", player.getName());
            System.out.println();
            System.out.println("=".repeat(30));
            player.increaseScore(10);
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("=".repeat(30));
            System.out.println("Computer won this round!");
            System.out.println("=".repeat(30));
            computer.increaseScore(10);
        } else {
            initiateWar(playerCard, computerCard);
        }
    }

    private void initiateWar(Card playerCard, Card computerCard) {
        System.out.println("It's a tie! Clash of Cards begins...");
        System.out.println();
        List<Card> playerWarCards = new ArrayList<>();
        List<Card> computerWarCards = new ArrayList<>();

        if (deck.getDeckOfCards().size() >= 7) {
            for (int i = 0; i < 3; i++) {
                playerWarCards.add(deck.dealCard());
                computerWarCards.add(deck.dealCard());
            }


            Card playerFourthCard = deck.dealCard();
            Card computerFourthCard = deck.dealCard();

            System.out.println(player.getName() + "'s WAR cards:");
            displayCards(playerWarCards);

            System.out.println("Computer's WAR cards:");
            displayCards(computerWarCards);

            System.out.println("-".repeat(40));
            System.out.println(player.getName() + "'s fourth card:");
            System.out.println(playerFourthCard.generateAsciiArt());
            System.out.println();
            System.out.println("Computer's fourth card:");
            System.out.println(computerFourthCard.generateAsciiArt());
            System.out.println("_".repeat(40));


            determineWarWinner(playerFourthCard, computerFourthCard);
        } else {
            System.out.println("Not enough cards to continue the war. Game ends in a tie.");
            endGame();
        }
    }

    private void displayCards(List<Card> cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println();
    }

    private void determineWarWinner(Card playerFourthCard, Card computerFourthCard) {
        int playerFourthValue = playerFourthCard.getValue();
        int computerFourthValue = computerFourthCard.getValue();

        if (playerFourthValue > computerFourthValue) {
            System.out.println(player.getName() + " dominates in the WAR with the fourth card and earns an additional 30 points!");
            player.increaseScore(30);
        } else if (playerFourthValue < computerFourthValue) {
            System.out.println("Computer dominates in the WAR with the fourth card and earns an additional 30 points!");
            computer.increaseScore(30);
        } else {
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
