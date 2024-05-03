package org.samuelraducan;

public class Main {
    public static void main(String[] args) {
        System.out.println("CLI Card Game");

        Player computer = new Player();

        GameConsole gameConsole = new GameConsole();
        String playerName = gameConsole.promptPlayerName();
        Player player = new Player(playerName);

        Card card1 = new Card("diamond", "♦️", 2);
        Card card2 = new Card("diamond", "♦️", 3);
        Card card3 = new Card("diamond", "♦️", 4);
        Card card4 = new Card("diamond", "♦️", 5);

        player.drawCard(card1);
        player.drawCard(card2);
        player.drawCard(card3);
        player.drawCard(card4);

        Card card5 = new Card("diamond", "♠️", 6);
        Card card6 = new Card("diamond", "♠️", 7);
        Card card7 = new Card("diamond", "♠️", 8);
        Card card8 = new Card("diamond", "♠️", 9);
        computer.drawCard(card5);
        computer.drawCard(card6);
        computer.drawCard(card7);
        computer.drawCard(card8);

        gameConsole.displayGameState(player, computer);
    }
}