package org.samuelraducan;

import org.samuelraducan.samuel.WarCliGame;
import org.samuelraducan.samuel.WarRules;

public class Main {
    public static void main(String[] args) {
        WarCliGame warCliGame = new WarCliGame("War Card Game", WarRules.displayRules());
        warCliGame.printRules();
        warCliGame.printTitle();
    }
}