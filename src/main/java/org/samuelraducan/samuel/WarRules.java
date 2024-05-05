package org.samuelraducan.samuel;

public class WarRules {
    public static String displayRules() {
        StringBuilder rules = new StringBuilder();
        rules.append("War Card Game Rules:\n");
        rules.append("1. Each player draws one card from the deck in each round.\n");
        rules.append("2. The player with the higher card value wins the round and earns a point.\n");
        rules.append("3. If both players draw cards with the same value, it's a tie, and no points are awarded.\n");
        rules.append("4. The game continues until the deck is empty.\n");
        rules.append("5. The player with the highest score at the end of the game wins.\n");

        return rules.toString();
    }
}