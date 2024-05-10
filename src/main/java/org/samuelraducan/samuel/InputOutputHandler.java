package org.samuelraducan.samuel;

import org.samuelraducan.Deck;
import org.samuelraducan.Player;

import java.util.Scanner;

public class InputOutputHandler {
    private final Scanner scanner;

    public InputOutputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void clashOfCardsGamePic() {
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("*                                                          *");
        System.out.println("*        Welcome to the Clash of Cards Game!               *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************");
        System.out.println();

    }

    public String promptPlayerName() {
        System.out.println("Are you ready to play? Then please enter your name to get started: ");
        return scanner.nextLine().trim();
    }

    public void displayWelcomeMessage(String playerName) {
        System.out.println();
        System.out.println("Great! You're ready to begin, " + playerName + ".");
        System.out.println(GameRules.getRules());
        System.out.println("*************************************************************************");
        System.out.println("*    May the hammer of Thor, Mjölnir ⚡\uD83D\uDD28, be with you! :)               *");
        System.out.println("*************************************************************************");
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayScores(Player player, Player computer) {
        System.out.printf("%s's score: %d\n", player.getName(), player.getScore());
        System.out.printf("Computer's score: %d\n", computer.getScore());
    }

    public void promptNextRound(Deck deck) {
        if (!deck.getDeckOfCards().isEmpty()) {
            System.out.println();
            System.out.println("Press Enter to continue to the next round...");
            scanner.nextLine();
        }
    }
}
