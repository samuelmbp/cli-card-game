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

    public void welcomeMessage () {
        System.out.println("Welcome " + promptPlayerName());
    }

    public void displayGameState (List<Player> players) {
        for (Player player: players) {
            System.out.println("Player: " + player.getName());
            System.out.println("Player cards: " + player.getScore());
        }
    }
}
