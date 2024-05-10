package org.samuelraducan;

import org.samuelraducan.samuel.ClashOfCards;
import org.samuelraducan.samuel.GameRules;
import org.samuelraducan.sanjida.GoodKingBadQueen;
import org.samuelraducan.sanjida.Rules;

import java.util.Scanner;

public class GameLoader implements ChooseGame {
    private Scanner scanner;
    private ClashOfCards clashOfCards;
    private GoodKingBadQueen goodKingBadQueen;
    private Rules rules = new Rules();

    public GameLoader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void printGames() {
        System.out.println("Choose a game to play: ");
        System.out.println("1. Clash of Cards (Samuel)");
        System.out.println("2. Good King, Bad Queen (Sanjida)");
    }

    @Override
    public Game chooseGame() {

       int option = scanner.nextInt();
       // TODO: Add error handling when input is not a number (string, symbol, letters etc..)
       if (option == 1) {
           if (clashOfCards == null) {
               clashOfCards = new ClashOfCards("Clash of Cards", GameRules.getRules());
           }
           clashOfCards.play();
       } else if (option == 2) {
           if (goodKingBadQueen == null) {
               goodKingBadQueen = new GoodKingBadQueen("War", rules.getRules());
           }
           goodKingBadQueen.play();
       }

       return null;
    }
}
