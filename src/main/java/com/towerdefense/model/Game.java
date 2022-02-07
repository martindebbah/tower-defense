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
            e.moveRight(); //enemyMoving(e); (cette fonction bug)
            if (!e.isAlive()){
                board.addKillEnemy(e);
            }    
        }

        for (Projectile p : board.getProjectiles()) { // Les projectiles se déplacent
            p.move();
            if (p.hit())
                board.addKillProjectile(p);
        }

        board.kill();
    }

    public void enemyMoving(Enemy e){
        if(e.getPath().isEmpty()){
            return;
        }
        Tile p = e.getPath().pop();
            if(p.getX() == e.getCoord()[0] && p.getY()-1 == e.getCoord()[1]){
                e.moveUp();
            } else {
                if(p.getX()+1 == e.getCoord()[0] && p.getY()-1 == e.getCoord()[1]){
                    e.moveUpRight();
                } else {
                    if(p.getX()-1 == e.getCoord()[0] && p.getY()-1 == e.getCoord()[1]){
                        e.moveUpLeft();
                    } else {
                        if(p.getX() == e.getCoord()[0] && p.getY()+1 == e.getCoord()[1]){
                            e.moveDown();
                        } else {
                            if(p.getX()+1 == e.getCoord()[0] && p.getY()+1 == e.getCoord()[1]){
                                e.moveDownRight();
                            } else {
                                if(p.getX()+1 == e.getCoord()[0] && p.getY()+1 == e.getCoord()[1]){
                                    e.moveDownRight();
                                } else {
                                    if(p.getX()-1 == e.getCoord()[0] && p.getY()+1 == e.getCoord()[1]){
                                        e.moveDownLeft();
                                    } else {
                                        if(p.getX()+1 == e.getCoord()[0] && p.getY() == e.getCoord()[1]){
                                            e.moveRight();
                                        } else {
                                            if(p.getX()-1 == e.getCoord()[0] && p.getY() == e.getCoord()[1]){
                                                e.moveLeft();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
    
}
