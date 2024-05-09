package org.samuelraducan.samuel;

import org.samuelraducan.*;
import java.util.Scanner;

public class ClashOfCards extends Game {

    private final GameLogic gameLogic;
    private final InputOutputHandler inputOutputHandler;
    private final Scanner scanner;

    public ClashOfCards(String title, String rules) {
        super(title, rules);
        this.gameLogic = new GameLogic(new GameConsole(), new InputOutputHandler(), new Deck());
        this.inputOutputHandler = new InputOutputHandler();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
       gameLogic.initializeGame(inputOutputHandler);

        while (!gameLogic.isDeckEmpty()) {
            System.out.println("Press Enter to reveal your card...");
            scanner.nextLine();

            Card playerCard = gameLogic.dealPlayerCard();
            Card computerCard = gameLogic.dealComputerCard();

            gameLogic.processRound(playerCard, computerCard);
        }

        gameLogic.endGame();
        playAgain();
        scanner.close();
    }

    @Override
    public boolean playAgain() {
        boolean promptPlayAgain = gameLogic.promptPlayAgain();
        if (promptPlayAgain) {
            play();
        }
        return promptPlayAgain;
    }
}
