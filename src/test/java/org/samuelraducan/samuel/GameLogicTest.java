package org.samuelraducan.samuel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.samuelraducan.Card;
import org.samuelraducan.Deck;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameLogicTest {

    @Test
    public void dealPlayerCard_DeckNotEmpty_ReturnsExpectedCard() {
        Card expectedCard = new Card("♠", "A", 14);

        Deck deckMock = Mockito.mock(Deck.class);
        when(deckMock.dealCard()).thenReturn(expectedCard);

        GameLogic gameLogic = new GameLogic(null, null, deckMock);
        Card actualCard = gameLogic.dealPlayerCard();

        assertEquals(expectedCard, actualCard);
    }

    @Test
    public void dealComputerCard_DeckNotEmpty_ReturnsExpectedCard() {
        Card expectedCard = new Card("♠", "10", 10);

        Deck deckMock = Mockito.mock(Deck.class);
        when(deckMock.dealCard()).thenReturn(expectedCard);

        GameLogic gameLogic = new GameLogic(null, null, deckMock);
        Card actualCard = gameLogic.dealComputerCard();

        assertEquals(expectedCard, actualCard);
    }
}