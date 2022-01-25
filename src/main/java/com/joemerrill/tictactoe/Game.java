package com.joemerrill.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sets up a new Tic Tac Toe game with Two Players
 */
public class Game {

    private final Player player1 = new Player("Player1", Player.PlayerSymbol.X);
    private final Player player2 = new Player("Player2", Player.PlayerSymbol.O);
    private final Board board;

    private boolean haveWinner = false;
    private Player currentPlayer;

    /**
     * Sets up a new Tic Tac Toe game with the specified game board size. (e.g., 3 will create a 3x3 game board).
     * Two players are created and Player1 begins (current player).
     */
    public Game() {
        this.board = new Board(3);
        this.currentPlayer = this.player1;
    }

    /**
     * Starts a new game
     */
    public void startGame() {

        printMessage("> tic-tac-toe");
        printMessage("Welcome! Here is your board:");
        board.printBoard();

        // Continue Game Player as long as we don't have a winner and there are positions left.
        while (!haveWinner && board.getSpacesRemaining() > 0) {
            playerTurn();
            board.printBoard();
        }

        if (haveWinner) {
            printMessage("Congratulations " + currentPlayer.getName() + "! You have won.");
        } else if (board.getSpacesRemaining() == 0) {
            printMessage("It's a draw. No more spaces remain.");
        }
    }

    // Private Game Play Methods
    //

    /**
     * Checks the game board if there is a winner. If so, set instance member "haveWinner" to true.
     * @param playerMove The current player's most recent move.
     */
    private void checkForWin(int[] playerMove) {
        // TODO: 12/2/21 - possibly use rivers algo to determine if player move won.
        //  Make sure to stay in bounds of the board and see if the size of the board is filled.

        // Retrieve the row and column values of the player move. Also retrieve the board's diagonals.
        // For each loop to check if any ROW (row, column, diagonal) contains the same symbol.
        for (String[] row : board.getRowsIntersectingMove(playerMove)) {
            if (Utils.areArrayElementsSame(row)) {
                haveWinner = true;
                return;
            }
        }

        /* Older code that checked for win:
        String[] row = board.getRow(playerMove[0]);
        if (Utils.areArrayElementsSame(row)) {
            haveWinner = true;
            return;
        }

        String[] column = board.getColumn(playerMove[1]);
        if (Utils.areArrayElementsSame(column)) {
            haveWinner = true;
            return;
        }

        String[][] diagonals = board.getDiagonals();
        System.out.println(Arrays.toString(diagonals[0]));
        System.out.println(Arrays.toString(diagonals[1]));
        */

    }

    private void playerTurn() {

        printMessage(currentPlayer.getName() + " (" +
                currentPlayer.getPlayerSymbol().toString() +
                ") where would you like to move?");

        int[] move = retrieveMoveFromCurrentPlayer();

        // Attempt to store player move on game board
        boolean wasMoveSuccessful = board.storePlayerMoveAtPosition(move, currentPlayer.getPlayerSymbol());

        // If Move was successful, check if the player won. Otherwise, have the player try again.
        if (wasMoveSuccessful) {
            // Check if player's most recent move won the game, if so return from method.
            checkForWin(move);
            if (haveWinner) {
                return;
            }

            // Toggle Current Player and continue play
            currentPlayer = (currentPlayer == player1) ? player2 : player1;

        } else {
            printMessage("Unable to play at the desired position " +
                    Arrays.toString(move) +
                    ". Please try again.");
        }
    }

    /**
     * Ask the player for their move.
     * @return player move
     */
    private int[] retrieveMoveFromCurrentPlayer() {

        Scanner scanner = new Scanner(System.in);

        int[] input = new int[2];

        for (int i = 0; i < 2; i++) {
            input[i] = scanner.nextInt();
        }

        return input;
    }

    /**
     * Print message to console.
     * @param message String message to print to the console.
     */
    private void printMessage(String message) {
        System.out.println(message);
    }

}
