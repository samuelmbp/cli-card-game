package org.samuelraducan.samuel;

import org.samuelraducan.Deck;
import org.samuelraducan.Game;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.Scanner;

public class SnapGame extends Game {

    private final Player player;
    private final Player computer;
    private final Deck deck;
    private final GameConsole console;
    private final Scanner scanner;


    public SnapGame(String title, String rules) {
        super(title, rules);
        this.scanner = new Scanner(System.in);
        this.player = initializePlayer();
        this.computer = new Player();
        this.deck = new Deck();
        this.console = new GameConsole();
    }

    @Override
    public void play() {
        this.printTitle();
        this.printRules();

        deck.shuffleDeck();
        dealInitialCards();

        console.displayGameState(player, computer);
    }


    private void dealInitialCards() {
        for (int i = 0; i < 26; i++) {
            player.drawCard(deck.dealCard());
            computer.drawCard(deck.dealCard());
        }
    }

    private Player initializePlayer() {
        System.out.println("Welcome to Snap!");
        System.out.println("Please enter your name to start: ");
        String playerName = scanner.nextLine();
        return new Player(playerName);
    }


    @Override
    public boolean playAgain() {
        return false;
    }
}

