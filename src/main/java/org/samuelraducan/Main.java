package org.samuelraducan;

import org.samuelraducan.samuel.Rules;
import org.samuelraducan.samuel.SnapGame;

public class Main {
    public static void main(String[] args) {
        SnapGame snapGame = new SnapGame("Snappy", Rules.getRules());
        snapGame.play();
    }
}