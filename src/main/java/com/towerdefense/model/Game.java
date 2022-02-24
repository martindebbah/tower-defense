package com.towerdefense.model;

import java.util.Iterator;

public class Game {

    private Board board;
    private Player player;

    public Game(int size, int nbCases) {
        this.board = new Board(size, nbCases, this);
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public void play() {
        for (Tile[] tab : board.getBoard()) { // Toutes les tours attaquent
            for (Tile t : tab) {
                if (t.containsTower()) {
                    t.getTower().focus(board);
                    if (t.getTower().canAttack() && t.getTower().isNewTarget()) {
                        t.getTower().attack(board);
                    }
                }
            }
        }

        for (Enemy e : board.getEnemies()) {
            e.move();
            if (!e.isAlive()){
                board.addKillEnemy(e);
            }    
        }

        for (Tile[] tab : board.getBoard())
            for (Tile t : tab) {
                if (t.containsTower()) {
                    Iterator<Projectile> i = t.getTower().getProjectiles().iterator();
                    while (i.hasNext()) {
                        Projectile p = i.next();
                        p.move();
                        if (p.hit())
                            i.remove();
                    }
                }
            }

        board.refresh();
    }
    
}
