package org.samuelraducan;

import org.samuelraducan.sanjida.Rules;
import org.samuelraducan.sanjida.GoodKingBadQueen;

public class Main {
    public static void main(String[] args) {

        Rules rules = new Rules();
        String gameRules = rules.getRules();

        GoodKingBadQueen goodKingBadQueenGame = new GoodKingBadQueen("War", gameRules);
        goodKingBadQueenGame.play();
    }
}