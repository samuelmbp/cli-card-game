package org.samuelraducan;

import org.samuelraducan.samuel.SnapGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SnapGame snapGame = new SnapGame("Snap Game", "Rules TBC...");
        snapGame.play();
    }
}