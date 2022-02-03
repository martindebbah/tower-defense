package com.towerdefense.model;

public class Game {

    private Board board;
    private Player player;

    public Game(int size, int nbCases) {
        this.board = new Board(size, nbCases);
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public void play() {
        for (Tower[] tab : board.getTowers()) {
            for (Tower t : tab) {
                if (t != null) {
                    t.focus(board);
                    if (t.canAttack() && t.isNewTarget()) {
                        t.attack();
                    }
                }
            }
        }
        for (Enemy e : board.getEnemies()) {
            e.moveRight();
        }
    }
    
}
