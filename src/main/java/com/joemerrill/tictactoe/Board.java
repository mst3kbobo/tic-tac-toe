package com.joemerrill.tictactoe;

import java.util.Arrays;

/**
 * Board class for playing a Tic Tac Toe game
 * Note that the internal board arrays are 0-based and player moves are 1-based.
 */
public class Board {

    private static final String EMPTY_BOARD_POSITION = "-";

    private final int boardSize;
    private final String[][] gameBoard;
    private int spacesRemaining;

    public Board(int size) {
        this.boardSize = size;
        this.gameBoard = new String[size][size];
        this.spacesRemaining = size * size;
        prepareBoard();
    }

    public int getSpacesRemaining() {
        return spacesRemaining;
    }

    private void decrementSpacesRemaining() {
        spacesRemaining -= 1;
    }

    /**
     * Prepare the game board with a series of dashes (EMPTY_BOARD_POSITION) at each element position.
     */
    private void prepareBoard() {
        for (String[] row : gameBoard) {
            Arrays.fill(row, EMPTY_BOARD_POSITION);
        }
    }

    /**
     * Prints the current configuration of the game board.
     * Example:
     * -, X, -,
     * X, -, O,
     * -, -, O,
     */
    public void printBoard() {
        System.out.println();
        for (String[] row : gameBoard) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i != row.length) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Retrieve all the board's rows (row, column, diagonals) that intersect the player's move.
     * Example on a 3x3 board:
     * : -, X, O
     * : X, O, -
     * : X, -, -
     * : move [1,2]
     * : returns row 1, column 2, top-right to bottom-right diagonal [["-", "X", "O"],["X", "O", "-"],["-", "O", "-"]]
     * @param move Player's move [row, column]
     * @return String array of arrays
     */
    public String[][] getRowsIntersectingMove(int[] move) {

        String[][] diagonals = getDiagonals();

        return new String[][] {
                getRow(move[0]),
                getColumn(move[1]),
                diagonals[0],
                diagonals[1]
        };

    }

    public String[] getRow(int rowNumber) {
        // Subtract 1 since player moves are 1-based and the internal board arrays are 0-based.
        return gameBoard[rowNumber - 1];
    }

    public String[] getColumn(int columnNumber) {
        // Subtract 1 since player moves are 1-based and the internal board arrays are 0-based.
        String[] column = new String[boardSize];
        for (int i = 0; i < boardSize; i++) {
            column[i] = gameBoard[i][columnNumber - 1];
        }
        return column;
    }

    public String[][] getDiagonals() {
        String[] diagonalTopLeftToBottomRight = new String[boardSize];
        String[] diagonalTopRightToBottomLeft = new String[boardSize];
        int index = 0;

        for (String[] row : gameBoard) {
            diagonalTopLeftToBottomRight[index] = row[index];
            diagonalTopRightToBottomLeft[index] = row[row.length - index - 1];
            index += 1;
        }

        return new String[][]{diagonalTopLeftToBottomRight, diagonalTopRightToBottomLeft};
    }

    /**
     * Stores a player move to the board.
     * @param position Position on board to store the player's move.
     * @param symbol Symbol of the player (e.g., X or O)
     * @return T/F depending on whether the move could be played (stored).
     */
    public boolean storePlayerMoveAtPosition(int[] position, Player.PlayerSymbol symbol) {

        // Subtract 1 from each player position since the board is 0 based.
        var boardBasedPosition = new int[] { position[0] - 1, position[1] - 1 };

        // Make sure position is in bounds.
        if (boardBasedPosition[0] < 0 || boardBasedPosition[0] >= boardSize ||
                boardBasedPosition[1] < 0 || boardBasedPosition[1] >= boardSize) {
            return false;
        }

        if (gameBoard[boardBasedPosition[0]][boardBasedPosition[1]].equals(EMPTY_BOARD_POSITION)) {
            gameBoard[boardBasedPosition[0]][boardBasedPosition[1]] = symbol.toString();
            decrementSpacesRemaining();
            return true;
        } else {
            return false;
        }
    }
}
