package org.samuelraducan.sanjida;

import org.samuelraducan.Deck;
import org.samuelraducan.Game;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.Scanner;

public class War extends Game {
    private GameConsole gameConsole;
    private Deck deckOfCards;
    private Player player;
    private Player computer;
    private Scanner scanner;

    public War(String title, String rules) {
        super(title, rules);
        this.scanner = new Scanner(System.in);
        this.gameConsole = new GameConsole();
    }

    public void startGame() {
        gameConsole.welcomeMessage("War");
        System.out.println("Please press 1 to play, and 2 to see the rules");
       String usersInput = scanner.nextLine();
        if (usersInput.equals("1")) {
            play();
        } else if (usersInput.equals("2")) {
            printRules();
            System.out.println();
            startGame();
        } else {
            System.out.println("Invalid input. Please press 1 or 2");
            System.out.println();
            startGame();
        }
    }

    @Override
    public void play() {

        // add override logic here
    }

    @Override
    public boolean playAgain() {
            // add override logic here
        return false;
    }
}
