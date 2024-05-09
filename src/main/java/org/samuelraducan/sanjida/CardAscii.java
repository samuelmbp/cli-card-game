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

    public void goodKingBadQueenDisplay() {
        String asciiArt =
                "**************************************************** \n" +
                "*   ____                 _   _  ___                *  \n" +
                "*  / ___| ___   ___   __| | | |/ (_)_ __   __ _    *  \n" +
                "* | |  _ / _ \\ / _ \\ / _` | | ' /| | '_ \\ / _` |   *  \n" +
                "* | |_| | (_) | (_) | (_| | | . \\| | | | | (_| |   *  \n" +
                "*  \\____|\\___/ \\___/ \\__,_| |_|\\_\\_|_| |_|\\__, |   *  \n" +
                "*  ____            _    ___               |___/    *  \n" +
                "* | __ )  __ _  __| |  / _ \\ _   _  ___  ___ _ __  *  \n" +
                "* |  _ \\ / _` |/ _` | | | | | | | |/ _ \\/ _ \\| '_ \\ *  \n" +
                "* | |_) | (_| | (_| | | |_| | |_| |  __/  __/ | | |*  \n" +
                "* |____/ \\__,_|\\__,_|  \\__\\_ \\__,_|\\___|\\___|_| |_|*  \n" +
                "*                                                  *  \n" +
                "****************************************************  \n";

        System.out.println();
        System.out.println(asciiArt);

    }
}

