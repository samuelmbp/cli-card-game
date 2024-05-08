package org.samuelraducan;

import org.samuelraducan.samuel.AsciiArt;
import org.samuelraducan.samuel.WarCliGame;
import org.samuelraducan.samuel.WarRules;
import org.samuelraducan.sanjida.GoodKingBadQueen;
import org.samuelraducan.sanjida.Rules;

import java.util.Scanner;

public class GameLoader implements ChooseGame {
    private Scanner scanner;
    private WarCliGame warCliGame;
    private GoodKingBadQueen goodKingBadQueen;
    private Rules rules = new Rules();

    public GameLoader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void printGames() {
        System.out.println("Choose a game to play: ");
        System.out.println("1. WarCard (Samuel)");
        System.out.println("2. Good King, Bad Queen (Sanjida)");
    }

    @Override
    public Game chooseGame() {

       int option = scanner.nextInt();
       // TODO: Add error handling when input is not a number (string, symbol, letters etc..)
       if (option == 1) {
           if (warCliGame == null) {
               warCliGame = new WarCliGame(AsciiArt.clashOfCardsAscii(), WarRules.getRules());
           }
           warCliGame.play();
       } else if (option == 2) {
           if (goodKingBadQueen == null) {
               goodKingBadQueen = new GoodKingBadQueen("War", rules.getRules());
           }
           goodKingBadQueen.play();
       }

       System.out.println("Null runs ");
       return null;
    }
}
