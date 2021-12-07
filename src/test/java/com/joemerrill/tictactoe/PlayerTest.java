package com.joemerrill.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void playerTest() {
        Player player1 = new Player("Player1", Player.PlayerSymbol.X);
        Player player2 = new Player("Player2", Player.PlayerSymbol.O);

        assertEquals(player1.getName(), "Player1");
        assertEquals(player1.getPlayerSymbol(), Player.PlayerSymbol.X);

        assertEquals(player2.getName(), "Player2");
        assertEquals(player2.getPlayerSymbol(), Player.PlayerSymbol.O);
    }
}