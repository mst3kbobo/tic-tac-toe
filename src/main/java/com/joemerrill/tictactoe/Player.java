package com.joemerrill.tictactoe;

/**
 * Player class to contain the name and symbol (e.g., X,O) of the player.
 */
public class Player {

    // Instance Fields/Properties/Members
    //
    private String name;
    private PlayerSymbol playerSymbol;

    // Constructors
    //
    public Player(String name, PlayerSymbol playerSymbol) {
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    // Getters
    //
    public String getName() {
        return name;
    }

    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

    /**
     * Player Symbol (e.g., X or O)
     */
    public enum PlayerSymbol {
        X,
        O
    }
}
