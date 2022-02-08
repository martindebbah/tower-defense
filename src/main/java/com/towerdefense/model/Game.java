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
            // enemyMoving(e); //(cette fonction bug)
            e.moveDownRight();
            System.out.println(e.getCoord()[0]+" "+e.getCoord()[1]);
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
        //System.out.println(p.getX()+" "+p.getY());
            if(p.getX() == e.getCoord()[0] && p.getY() == e.getCoord()[1]-32){
                for(int i = 0; i < 32 ; i++){
                    e.moveUp();
                }
                System.out.println("a");
            } else {
                if(p.getX() == e.getCoord()[0]+32 && p.getY() == e.getCoord()[1]-32){
                    for(int i = 0; i < 32; i++){
                        e.moveUpRight();
                    }
                    System.out.println("b");
                } else {
                    if(p.getX() == e.getCoord()[0]-32 && p.getY() == e.getCoord()[1]-32){
                        for(int i = 0; i < 32; i++){
                            e.moveUpLeft();
                        }
                        System.out.println("c");
                    } else {
                        if(p.getX() == e.getCoord()[0] && p.getY() == e.getCoord()[1]+32){
                            for(int i = 0; i < 32; i++){
                                e.moveDown();
                            }
                            System.out.println("d");
                        } else {
                            if(p.getX() == e.getCoord()[0]+32 && p.getY() == e.getCoord()[1]+32){
                                for(int i = 0; i < 32; i++){
                                    e.moveDownRight();
                                }
                                System.out.println("e");
                            } else {
                                    if(p.getX() == e.getCoord()[0]-32 && p.getY() == e.getCoord()[1]+32){
                                        for(int i = 0; i < 32; i++){
                                            e.moveDownLeft();
                                        }
                                        System.out.println("f");
                                    } else {
                                        if(p.getX() == e.getCoord()[0]+32 && p.getY() == e.getCoord()[1]){
                                            for(int i = 0; i < 32; i++){
                                                e.moveRight();
                                            }
                                            System.out.println("g");
                                        } else {
                                            if(p.getX() == e.getCoord()[0]-32 && p.getY() == e.getCoord()[1]){
                                                for(int i = 0; i < 32; i++){
                                                    e.moveLeft();
                                                }
                                                System.out.println("h");
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
