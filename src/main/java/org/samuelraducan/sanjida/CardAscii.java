package org.samuelraducan.sanjida;

import org.samuelraducan.Card;

public class CardAscii {
    public static String generateCardAscii(Card card) {
        StringBuilder cardAscii = new StringBuilder();


        cardAscii.append("┌─────────┐\n");
        cardAscii.append(String.format("│ %-2s      │\n", card.getSymbol()));
        cardAscii.append("│         │\n");
        cardAscii.append(String.format("│   %-2s    │\n", card.getSuit()));
        cardAscii.append("│         │\n");
        cardAscii.append(String.format("│      %-2s │\n", card.getSymbol()));
        cardAscii.append("└─────────┘\n");

        return cardAscii.toString();
    }
}

