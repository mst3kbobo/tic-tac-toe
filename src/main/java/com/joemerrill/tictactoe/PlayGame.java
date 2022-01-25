package com.joemerrill.tictactoe;

public class PlayGame {

    public static void main(String[] args) {

        Game game = new Game();
        game.startGame();

        // TODO: 12/7/21
        //  There is a bug where player one starts in a corner and the diags are checked.
        //  The opposite diag will contain all `-` and a winner will be declared.
        //  This will need to be fixed by ignoring the filler character `-` of a board when checking for a win.
    }
}
