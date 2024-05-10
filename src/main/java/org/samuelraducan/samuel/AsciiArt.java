package org.samuelraducan.samuel;

import org.samuelraducan.Card;

public class AsciiArt {
    public static String generateCardArt(Card card) {
        StringBuilder asciiCard = new StringBuilder();

        // ASCII art for the top border of the card
        asciiCard.append("+----------+\n");

        // ASCII art for the card body
        asciiCard.append(String.format("| %-2s       |\n", card.getSymbol())); // Symbol
        asciiCard.append("|          |\n");
        asciiCard.append("|          |\n");
        asciiCard.append(String.format("|    %-2s    |\n", card.getSuit())); // Suit
        asciiCard.append("|          |\n");
        asciiCard.append("|          |\n");
        asciiCard.append(String.format("|       %-2s |\n", card.getSymbol())); // Symbol
        asciiCard.append("+----------+\n");

        return asciiCard.toString();
    }

    public static String clashOfCardsAscii() {
        StringBuilder ascii = new StringBuilder();
        ascii.append("-------------------------------------------------------\n");
        ascii.append("|       |       |       |       |       |       |       |\n");
        ascii.append("|   _   |   _   |   _   |   _   |   _   |   _   |   _   |\n");
        ascii.append("|  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |\n");
        ascii.append("| ( C ) | ( L ) | ( A ) | ( S ) | ( H ) | ( O ) | ( F ) |\n");
        ascii.append("|  \\_/  |  \\_/  |  \\_/  |  \\_/  |  \\_/  |  \\_/  |  \\_/  |\n");
        ascii.append("|       |       |       |       |       |       |       |\n");
        ascii.append("|   _   |   _   |   _   |   _   |   _   |   _   |   _   |\n");
        ascii.append("|  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |  / \\  |\n");
        ascii.append("| ( C ) | ( A ) | ( R ) | ( D ) | ( S ) |       |       |\n");
        ascii.append("|  \\_/  |  \\_/  |  \\_/  |  \\_/  |  \\_/  |       |       |\n");
        ascii.append("-------------------------------------------------------");

        return ascii.toString();
    }
}
