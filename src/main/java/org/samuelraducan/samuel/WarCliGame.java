package org.samuelraducan.samuel;

import org.samuelraducan.Deck;
import org.samuelraducan.Game;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

public class WarCliGame extends Game {
    private final Player player;
    private final Player computer;
    private final Deck deck;
    private final GameConsole console;

    public WarCliGame(String title, String rules) {
        super(title, rules);
        this.player = new Player();
        this.computer = new Player();
        this.deck = new Deck();
        this.console = new GameConsole();
    }

    @Override
    public void play() {
        this.printTitle();
        this.printRules();

        console.welcomeMessage(player.getName());
    }

    @Override
    public boolean playAgain() {
        return false;
    }
}
