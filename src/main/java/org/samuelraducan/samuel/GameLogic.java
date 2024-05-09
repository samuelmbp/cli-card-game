package org.samuelraducan.samuel;

import org.samuelraducan.Card;
import org.samuelraducan.Deck;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private final Player player;
    private final Player computer;
    private final Deck deck;
    private final GameConsole console;
    private final InputOutputHandler inputOutputHandler;
    private final Scanner scanner;

    public GameLogic(GameConsole console, InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        this.player = new Player();
        this.computer = new Player();
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.console = console;
        this.scanner = new Scanner(System.in);
    }


    public void initializeGame(InputOutputHandler inputOutputHandler) {
        inputOutputHandler.clashOfCardsGamePic();

        String playerName = inputOutputHandler.promptPlayerName();

        while (playerName.isEmpty()) {
            inputOutputHandler.displayMessage("Name cannot be empty! Please enter a valid name.");
            playerName = inputOutputHandler.promptPlayerName();
        }

        player.setName(playerName);
        inputOutputHandler.displayWelcomeMessage(playerName);
    }

    public void processRound(Card playerCard, Card computerCard) {
        if (playerCard.getValue() == 14) {
            player.increaseScore(15);
            inputOutputHandler.displayMessage("Nice one! " + player.getName() + " gets an extra 15 points because of their ACE.");
        }

        if (computerCard.getValue() == 14) {
            computer.increaseScore(15);
            inputOutputHandler.displayMessage("Nice one! The computer gets an extra 15 points because of its ACE.");
        }

        String playerCardAscii = playerCard.generateAsciiArt();
        String computerCardAscii = computerCard.generateAsciiArt();

        console.displayGameState(player, computer, playerCardAscii, computerCardAscii);
        determineWinner(playerCard, computerCard);
        System.out.println();
        inputOutputHandler.displayScores(player, computer);
        inputOutputHandler.promptNextRound(deck);

        player.removeCard(playerCard);
        computer.removeCard(computerCard);
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
                playerWarCards.add(dealPlayerCard());
                computerWarCards.add(dealComputerCard());
            }


            Card playerFourthCard = dealPlayerCard();
            Card computerFourthCard = dealComputerCard();

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
            System.out.println("Not enough cards to start the war. Continuing with remaining cards.");
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

    public void endGame() {
        console.displayGameState(player, computer);

        if (player.getScore() > computer.getScore()) {
            inputOutputHandler.displayMessage("Congratulations, " + player.getName() + "! You win with a score of " + player.getScore() + ".");
        } else if (player.getScore() < computer.getScore()) {
            inputOutputHandler.displayMessage("Computer wins with a score of " + computer.getScore() + ".");
        } else {
            inputOutputHandler.displayMessage("It's a tie!");
        }
    }

    public boolean promptPlayAgain() {
        while (true) {
            System.out.println();
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

        System.out.println();
        System.out.println("Starting a new game...");
        System.out.println("Press Enter...");
        scanner.nextLine();
    }

    public Card dealPlayerCard() {
        return deck.dealCard();
    }

    public Card dealComputerCard() {
        return deck.dealCard();
    }

    public boolean isDeckEmpty() {
        return deck.getDeckOfCards().isEmpty();
    }
}
