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

        for (Enemy e : board.getEnemies()) { // Test : l'ennemi avance de gauche à droite
            e.moveRight(); //e.movingWithAstar(e.shorterPath(19, 10, board)); (cette fonction bug)
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
