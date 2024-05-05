package org.samuelraducan;

import org.samuelraducan.sanjida.Rules;
import org.samuelraducan.sanjida.War;

public class Main {
    public static void main(String[] args) {

        Rules rules = new Rules();
        String gameRules = rules.getRules();

        War warGame = new War("War", gameRules);
        warGame.play();
    }
}