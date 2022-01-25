package com.joemerrill.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void boardTest() {
        Board board = new Board(3);
        assertNotNull(board);
    }

    @Test
    void getSpacesRemainingTest() {
        Board board3by3 = new Board(3);
        assertEquals(9, board3by3.getSpacesRemaining());

        Board board4by4 = new Board(4);
        assertEquals(16, board4by4.getSpacesRemaining());
    }

    @Test
    void getRowTest() {
        Board board = new Board(3);

        board.storePlayerMoveAtPosition(new int[] {1,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,2}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {2,3}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {3,1}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {3,2}, Player.PlayerSymbol.X);

        /*
        X,-,-
        X,O,X
        O,X,-
         */

        assertArrayEquals(new String[]{"X","-","-"}, board.getRow(1));
        assertArrayEquals(new String[]{"X","O","X"}, board.getRow(2));
        assertArrayEquals(new String[]{"O","X","-"}, board.getRow(3));
    }

    @Test
    void getColumnTest() {
        Board board = new Board(3);

        board.storePlayerMoveAtPosition(new int[] {1,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,2}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {2,3}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {3,1}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {3,2}, Player.PlayerSymbol.X);

        /*
        X,-,-
        X,O,X
        O,X,-
         */

        assertArrayEquals(new String[]{"X","X","O"}, board.getColumn(1));
        assertArrayEquals(new String[]{"-","O","X"}, board.getColumn(2));
        assertArrayEquals(new String[]{"-","X","-"}, board.getColumn(3));
    }

    @Test
    void getDiagonalsTest() {
        Board board = new Board(3);

        board.storePlayerMoveAtPosition(new int[] {1,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,1}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {2,2}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {2,3}, Player.PlayerSymbol.X);
        board.storePlayerMoveAtPosition(new int[] {3,1}, Player.PlayerSymbol.O);
        board.storePlayerMoveAtPosition(new int[] {3,2}, Player.PlayerSymbol.X);

        /*
        X,-,-
        X,O,X
        O,X,-
         */

        assertArrayEquals(new String[]{"X","O","-"}, board.getDiagonals()[0]);
        assertArrayEquals(new String[]{"-","O","O"}, board.getDiagonals()[1]);
    }

    @Test
    void storePlayerMoveAtPositionTest() {
        Board board = new Board(3);

        assertEquals(true, board.storePlayerMoveAtPosition(new int[] {2,2}, Player.PlayerSymbol.X),
                "This is an empty position and should be available."); // empty
        assertEquals(true, board.storePlayerMoveAtPosition(new int[] {3,1}, Player.PlayerSymbol.O),
                "This is an empty position and should be available."); // empty

        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {2,2}, Player.PlayerSymbol.X),
                "This is a taken position and should not be available."); // taken
        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {3,1}, Player.PlayerSymbol.O),
                "This is a taken position and should not be available."); // taken

        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {0,0}, Player.PlayerSymbol.X),
                "This position is out of the boards bounds."); // out of bounds
        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {4,4}, Player.PlayerSymbol.X),
                "This position is out of the boards bounds."); // out of bounds
        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {1,-1}, Player.PlayerSymbol.O),
                "This position is out of the boards bounds."); // out of bounds
        assertEquals(false, board.storePlayerMoveAtPosition(new int[] {6,1}, Player.PlayerSymbol.O),
                "This position is out of the boards bounds."); // out of bounds
    }
}