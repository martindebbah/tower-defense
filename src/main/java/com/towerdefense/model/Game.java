package com.towerdefense.model;

public class Game {

    private Board board;
    private Player player;

    public Game() {
        this.board = new Board();
    }

    public Player getPlayer() {
        return player;
    }
    
}
