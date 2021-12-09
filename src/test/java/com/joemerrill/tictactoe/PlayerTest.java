package com.joemerrill.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final String TAG = "PlayerTest";
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);
        testPlayer = new Player("Player1", Player.PlayerSymbol.X);

        assertNotNull(testPlayer);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);
        testPlayer = null;

        assertNull(testPlayer);
    }

    @Test
    void getPlayerNameTest() {
        System.out.println("Running: getPlayerNameTest");
        assertEquals("Player1", testPlayer.getName());
    }

    @Test
    void getPlayerSymbolTest() {
        System.out.println("Running: getPlayerSymbolTest");
        assertEquals(Player.PlayerSymbol.X, testPlayer.getPlayerSymbol());
    }
}