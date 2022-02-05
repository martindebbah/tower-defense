package com.towerdefense.model;

import javax.xml.transform.stax.StAXResult;

import static java.lang.Math.*;

import java.util.ArrayList;

public class Enemy {

    private Game game;
    private int health;
    private int maxHealth;
    private int movementSpeed;
    private int gold;
    private int x;
    private int y;

    public Enemy(int health, int movementSpeed, int gold, int x, int y) { // x et y donnent l'endroit où apparaît l'unité
        this.health = health;
        this.maxHealth = health;
        this.movementSpeed = movementSpeed;
        this.x = x;
        this.y = y;
    }

    public Game getGame() {
        return game;
    }

    public int[] getCoord() { // Renvoie un tableau contenant les coordonnées de l'unité {x, y}
        int[] coord = new int[2];
        coord[0] = x;
        coord[1] = y;
        return coord;
    }

    public boolean isAlive() { // Vraiment la bonne méthode ?
        return health > 0;     // Comment faire disparaître l'unité ?
    }

    public int getGold() {
        return gold;
    }

    public void getHit(int damage) { // Appelé par la tour qui inflige les dommages à l'unité
        health -= damage;
    }

    public void crossedBoard() { // L'unité a traversé le plateau (fait perdre un pdv au joueur)
        game.getPlayer().getHit();
    }

    public int getHP() {
        return health * 100 / maxHealth;
    }

    public void kill() {
        if (getHP() == 0)
            game.getBoard().killEnemy(this);
    }

    public void move(int h, int v) {
        x += h * movementSpeed;
        y += v * movementSpeed;
    }

    public void moveUp() {
        move(0, -1);
    }
    public void moveUpRight() {
        move(1, -1);
    }
    public void moveUpLeft() {
        move(-1, -1);
    }
    public void moveDown() {
        move(0, 1);
    }
    public void moveDownRight() {
        move(1, 1);
    }
    public void moveDownLeft() {
        move(-1, 1);
    }
    public void moveRight() {
        move(1, 0);
    }
    public void moveLeft() {
        move(-1, 0);
    }

    public double dist(int x1, int y1, int x2, int y2){ // renvoie la distance entre l'ennemi et un point d'arrivé
        return (double)Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }

    public boolean validNode(int x, int y, Board board, ArrayList<Tile> closed){
        Tile[][] copyBoard = board.getBoard();
        if(!board.outOfBoard(x, y) && !copyBoard[x][y].containsTower() && !closed.contains(copyBoard[x][y])){
            return true;
        }
        return false;
    }

    public void shorterPath(int x, int y, Board board){ // application de l'algo A*
        ArrayList<Tile> open = new ArrayList<>();
        ArrayList<Tile> closed = new ArrayList<>();
        Tile[][] copyBoard = board.getBoard();
        Tile current = copyBoard[this.x][this.y];

        closed.add(copyBoard[this.x][this.y]);

        while(current != copyBoard[x][y]){
            if(validNode(current.getX(),current.getY()-1,board,closed)){
                if(open.contains(copyBoard[current.getX()][current.getY()-1])){

                } else {
                    copyBoard[current.getX()][current.getY()-1].setParent(current);
                    open.add(copyBoard[current.getX()][current.getY()-1]);
                }
            }
            if(validNode(current.getX()+1,current.getY()-1,board,closed)){
                if(open.contains(copyBoard[current.getX()+1][current.getY()-1])){

                } else {
                    copyBoard[current.getX()+1][current.getY()-1].setParent(current);
                    open.add(copyBoard[current.getX()+1][current.getY()-1]);
                }
            }
            if(validNode(current.getX()-1,current.getY()-1,board,closed)){
                if(open.contains(copyBoard[current.getX()-1][current.getY()-1])){

                } else {
                    copyBoard[current.getX()-1][current.getY()-1].setParent(current);
                    open.add(copyBoard[current.getX()-1][current.getY()-1]);
                }
            }
            if(validNode(current.getX(),current.getY()+1,board,closed)){
                if(open.contains(copyBoard[current.getX()][current.getY()+1])){

                } else {
                    copyBoard[current.getX()][current.getY()+1].setParent(current);
                    open.add(copyBoard[current.getX()][current.getY()+1]);
                }
            }
            if(validNode(current.getX()+1,current.getY()+1,board,closed)){
                if(open.contains(copyBoard[current.getX()+1][current.getY()+1])){

                } else {
                    copyBoard[current.getX()+1][current.getY()+1].setParent(current);
                    open.add(copyBoard[current.getX()+1][current.getY()+1]);
                }
            }
            if(validNode(current.getX()-1,current.getY()+1,board,closed)){
                if(open.contains(copyBoard[current.getX()-1][current.getY()+1])){

                } else {
                    copyBoard[current.getX()-1][current.getY()+1].setParent(current);
                    open.add(copyBoard[current.getX()-1][current.getY()+1]);
                }
            }
            if(validNode(current.getX()+1,current.getY(),board,closed)){
                if(open.contains(copyBoard[current.getX()+1][current.getY()])){

                } else {
                    copyBoard[current.getX()+1][current.getY()].setParent(current);
                    open.add(copyBoard[current.getX()+1][current.getY()]);
                }
            }
            if(validNode(current.getX()-1,current.getY(),board,closed)){
                if(open.contains(copyBoard[current.getX()-1][current.getY()])){

                } else {
                    copyBoard[current.getX()-1][current.getY()].setParent(current);
                    open.add(copyBoard[current.getX()-1][current.getY()]);
                }
            }
        }
    }
    
}
