package org.samuelraducan.samuel;

public class WarRules {
    public static String getRules() {
            StringBuilder rules = new StringBuilder();
            rules.append("Game Rules:\n");
            rules.append("1. Each player draws one card from the deck in each round.\n");
            rules.append("2. The player with the higher card value wins the round and earns 10 points.\n");
            rules.append("3. In case of a tie, the game proceeds to a 'Clash of Cards' where each player draws three more cards.\n");
            rules.append("4. The player with the higher value on the fourth drawn card wins the 'Clash of Cards' and earns 30 additional points.\n");
            rules.append("5. If there is a second tie immediately after the first tie, no points are awarded.\n");
            rules.append("6. Each player starts with 0 points, and the game continues until the deck is empty.\n");
            rules.append("7. The player with the highest score at the end of the game wins.\n");

            return rules.toString();
        }
}