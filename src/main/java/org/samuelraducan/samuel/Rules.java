package org.samuelraducan.samuel;

public class Rules {

    public static String getRules() {
        StringBuilder rules = new StringBuilder();
        rules.append("===== Snap Game Rules =====\n");
        rules.append("1. Players take turns drawing cards from the deck.\n");
        rules.append("2. When two cards of the same value are drawn in succession, the first player to call \"Snap!\" wins the pile.\n");
        rules.append("3. The game continues until one player runs out of cards.\n");
        rules.append("4. The player with the most cards at the end wins the game.\n");
        rules.append("==========================\n");
        return rules.toString();
    }
}
