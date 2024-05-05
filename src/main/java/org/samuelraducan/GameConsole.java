package org.samuelraducan;

import java.util.List;
import java.util.Scanner;

public class GameConsole {
    private Scanner scanner;

    public GameConsole() {
        this.scanner = new Scanner(System.in);
    }

    public String promptPlayerName() {
        System.out.println("Please enter your name");
        return scanner.nextLine();
    }

    public void welcomeMessage (String name) {
        System.out.println("Welcome to The CLI Card Game " + name + "!");
    }

    public void displayGameState (Player player, Player computer) {
        System.out.println("Player: " + player.getName());
        player.getCardCount();
        System.out.println("Player's Score: " + player.getScore());

        System.out.println("-----------------------------------");

        System.out.println("Computer");
        computer.getCardCount();
        System.out.println("Computer's Score: " + computer.getScore());
    }

    public void displayGameState(Player player, Player computer, Card playerCard, Card computerCard) {
        System.out.println("Player: " + player.getName());
        System.out.println("Card: " + playerCard);
        System.out.println("Score: " + player.getScore());

        System.out.println("-----------------------------------");

        System.out.println("Computer");
        System.out.println("Card: " + computerCard);
        System.out.println("Score: " + computer.getScore());
    }
}
