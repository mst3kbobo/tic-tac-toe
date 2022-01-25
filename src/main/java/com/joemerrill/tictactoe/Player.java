package com.joemerrill.tictactoe;

/**
 * Player class to contain the name and symbol (e.g., X,O) of the player.
 */
public class Player {

    // Instance Fields/Properties/Members
    //
    private final String name;
    private final PlayerSymbol playerSymbol;

    /**
     * Constructor for a Player object
     * @param name the name of the player
     * @param playerSymbol the symbol the player uses when playing the game (e.g., X, O)
     */
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
     * PlayerSymbol (e.g., X or O)
     */
    public enum PlayerSymbol {
        X,
        O
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + "'" +
                ", playerSymbol=" + playerSymbol +
                "}";
    }
}
