package org.samuelraducan;

import org.samuelraducan.samuel.WarCliGame;
import org.samuelraducan.samuel.WarRules;

public class Main {
    public static void main(String[] args) {
        WarCliGame warCliGame = new WarCliGame("WarCard Game", WarRules.getRules());
        warCliGame.play();
    }
}