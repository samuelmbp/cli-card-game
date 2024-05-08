package org.samuelraducan.sanjida;

import org.samuelraducan.Card;
import org.samuelraducan.Deck;
import org.samuelraducan.GameConsole;
import org.samuelraducan.Player;

import java.util.LinkedList;
import java.util.Scanner;

public class UserCommands {
    private Deck deck;
    private GameConsole gameConsole;
    private Player player;
    private Player computer;
    private Scanner scanner;
    private GoodKingBadQueen goodKingBadQueen;
    private LinkedList<Card> playerDeck;
    private LinkedList<Card> computerDeck;

    private static final String[] USER_COMMANDS = {
            "Deal next set of cards",
            "Shuffle the deck of cards",
            "See game score",
            "Check number of cards",
            "Quit game"
    };
        // ADD PLAY AGAIN OPTION

    public UserCommands(Deck deck, Player player, Player computer, LinkedList<Card> playerDeck, LinkedList<Card> computerDeck, Scanner scanner) {
        this.deck = deck;
        this.player = player;
        this.computer = computer;
        this.playerDeck = playerDeck;
        this.computerDeck = computerDeck;
        this.scanner = scanner;
        this.gameConsole = new GameConsole();
    }

    public void printOptions() {

        while (true) {
            System.out.println();
            System.out.println("Select an option:");
            for (int i = 0; i < USER_COMMANDS.length; i++) {
                System.out.println((i + 1) + ". " + USER_COMMANDS[i]);
            }

            int userSelection = scanner.nextInt();
            handleUserSelection(userSelection);
        }
    }

    public boolean handleUserSelection(int userSelection) {
        System.out.println("Performing the user's option: " + userSelection);
        System.out.println();

        switch (userSelection) {
            case 1:
                dealNextSetOfCards();
                break;
            case 2:
                deck.shuffleDeck();
                System.out.println("Cards have been shuffled");
                break;
            case 3:
                gameConsole.displayGameState(player, computer);
                break;
            case 4:
//                war.playAgain(); // give play again method
                System.out.println(player.getName() + "'s number of cards: " + playerDeck.size());
                System.out.println("Computer's number of cards: " + computerDeck.size());
                break;
            case 5:
                System.out.println("Quitting the game..."); ///error
                return false;
            default:
                System.out.println("Invalid option. Please select a number between 1 and 5.");
        }

        return true;
    }

   // refactor this
    private void dealNextSetOfCards() {
        if (!playerDeck.isEmpty() && !computerDeck.isEmpty()) {
            Card playersCard = playerDeck.pop();
            Card computersCard = computerDeck.pop();


            System.out.println(player.getName() + "'s card:");
            displayCardAscii(playersCard);
            System.out.println("Computer's card:");
            displayCardAscii(computersCard);

            //  create two methods for the forloop and it will have param taker and giver adn can just assign depending on who it is

            if ((computersCard.getSymbol().equals("K") && playersCard.getSymbol().equals("K")) ||
                    (playersCard.getSymbol().equals("Q") && computersCard.getSymbol().equals("Q"))) {
                System.out.println("Tie");
            } else if (playersCard.getSymbol().equals("K")) {
                for (int i = 0; i < 4; i++) {
                    playerDeck.addLast(computerDeck.removeFirst());
                }
                playerDeck.addLast(playersCard);
                playerDeck.addLast(computersCard);
                this.player.increaseScore();
                System.out.println(player.getName() + " captured a King! They take 5 cards from the computer.");
            } else if (computersCard.getSymbol().equals("K")) {
                for (int i = 0; i < 4; i++) {
                    computerDeck.addLast(playerDeck.removeFirst());
                }
                computerDeck.addLast(playersCard);
                computerDeck.addLast(computersCard);
                this.computer.increaseScore();
                System.out.println("Computer captured a King! They take 5 cards from the player.");
            } else if (playersCard.getSymbol().equals("Q")) {
                for (int i = 0; i < 4; i++) {
                    computerDeck.add(playerDeck.removeFirst());
                }
                computerDeck.addLast(playersCard);
                computerDeck.addLast(computersCard);
                System.out.println("Oh no! " + player.getName() + " captured a Queen. They must give 5 cards to the player");
            } else if (computersCard.getSymbol().equals("Q")) {
                for (int i = 0; i < 4; i++) {
                    playerDeck.addLast(computerDeck.removeFirst());
                }
                playerDeck.addLast(playersCard);
                playerDeck.addLast(computersCard);
                System.out.println("Oh no! The Computer captured a Queen. They must give 5 cards to the player");
            } else {
                if (playersCard.getValue() > computersCard.getValue()) {
                    playerDeck.addLast(playersCard);
                    playerDeck.addLast(computersCard);
                    this.player.increaseScore();
                    System.out.println(player.getName() + " wins this round!");
                } else if (playersCard.getValue() < computersCard.getValue()) {
                    computerDeck.addLast(playersCard);
                    computerDeck.addLast(computersCard);
                    this.computer.increaseScore();
                    System.out.println("Computer wins this round!");
                } else {
                    // WAR logic goes here
                    System.out.println("Tie");
                }
            }
            gameConsole.displayGameState(player, computer);
        } else {
            System.out.println("The game is already over. Please select another option.");
        }

    }

    private void displayCardAscii(Card card) {
        String cardAscii = CardAscii.generateCardAscii(card);
        System.out.println(cardAscii);
    }
}


