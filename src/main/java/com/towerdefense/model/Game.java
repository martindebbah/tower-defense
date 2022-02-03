package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

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
        for (Tower[] tab : board.getTowers()) { // Toutes les tours attaquent
            for (Tower t : tab) {
                if (t != null) {
                    t.focus(board);
                    if (t.canAttack() && t.isNewTarget()) {
                        t.attack(board);
                    }
                }
            }
        }

        for (Enemy e : board.getEnemies()) { // Test : l'ennemi avance de gauche à droite
            e.moveRight();
            if (!e.isAlive())
                board.addKillEnemy(e);
        }

        for (Projectile p : board.getProjectiles()) { // Les projectiles se déplacent
            p.move();
            if (p.hit())
                board.addKillProjectile(p);
        }

        board.kill();
    }
    
}
