package com.towerdefense.model;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Stack;

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

    public void validNode(int x, int y, int fx, int fy, Board board, ArrayList<Tile> closed, ArrayList<Tile> open, Tile current){ // vérifie si une case n'est pas hors plateau, ne contient pas de tour et n'est pas dans la liste fermé
        if(!board.outOfBoard(x, y) && !board.getBoard()[x][y].containsTower() && !closed.contains(board.getBoard()[x][y])){ // * vérifie si les noeuds voisins sont valide
            if(open.contains(board.getBoard()[x][y])){ // si le noeud est deja dans la liste ouverte on vérifie sa qualité et on l a met à jour si elle est meilleure
                for(Tile t : open){
                    if(x == t.getX() && y == t.getY() && board.getBoard()[x][y].getQuality() < t.getQuality()){
                        t.setParent(current);
                        t.setQuality(board.getBoard()[x][y].getQuality());
                    }
                }
            } else {
                board.getBoard()[x][y].setParent(current); // ajout du noeud voisin dans la liste ouverte
                board.getBoard()[x][y].setQuality(dist(x, y, fx, fy));
                open.add(board.getBoard()[x][y]);
            }
        }
    }

    public Tile shorterPath(int fx, int fy, Board board){ // application de l'algo A*
        ArrayList<Tile> open = new ArrayList<>(); // liste ouverte
        ArrayList<Tile> closed = new ArrayList<>(); // liste fermée
        Tile current = board.getBoard()[this.x][this.y]; // noeud actuel

        current.setQuality(dist(current.getX(), current.getY(), fx, fy));
        closed.add(current);

        while(current != board.getBoard()[fx][fy]){ // tant que le noeud actuel n'est pas le noeud de sortie
            validNode(current.getX(), current.getY()-1, fx, fy, board, closed, open, current);
            validNode(current.getX()+1, current.getY()-1, fx, fy, board, closed, open, current);
            validNode(current.getX()-1, current.getY()-1, fx, fy, board, closed, open, current);
            validNode(current.getX(), current.getY()+1, fx, fy, board, closed, open, current);
            validNode(current.getX()+1, current.getY()+1, fx, fy, board, closed, open, current);
            validNode(current.getX()-1, current.getY()+1, fx, fy, board, closed, open, current);
            validNode(current.getX()+1, current.getY(), fx, fy, board, closed, open, current);
            validNode(current.getX()-1, current.getY(), fx, fy, board, closed, open, current);

            Tile best = open.get(0);
            for(int i = 1 ; i < open.size(); i++){ // check le noeud qui possède la meilleure qualité
                if(open.get(i).getQuality() < best.getQuality()){
                    best = open.get(i);
                }
            }

            open.remove(best); // on le retire de la liste ouverte
            closed.add(best);  // on l'ajoute à la liste fermée

            current = best;
        }

        return current;
    }

    public void movingWithAstar(Tile path){ // (non fonctionnel) problem : repaint
        Stack<Tile> reversePath = new Stack<>();
        while(path.getParent() != null){ // ajoute les noeuds et leurs parent pour retrouver le chemin (le noeud en argument est la sortie)
            reversePath.add(path);
            path = path.getParent();
        }

        while(!reversePath.isEmpty()){
            Tile p = reversePath.pop();
            if(p.getX() == this.x && p.getY()-1 == this.y){
                moveUp();
            } else {
                if(p.getX()+1 == this.x && p.getY()-1 == this.y){
                    moveUpRight();
                } else {
                    if(p.getX()-1 == this.x && p.getY()-1 == this.y){
                        moveUpLeft();
                    } else {
                        if(p.getX() == this.x && p.getY()+1 == this.y){
                            moveDown();
                        } else {
                            if(p.getX()+1 == this.x && p.getY()+1 == this.y){
                                moveDownRight();
                            } else {
                                if(p.getX()+1 == this.x && p.getY()+1 == this.y){
                                    moveDownRight();
                                } else {
                                    if(p.getX()-1 == this.x && p.getY()+1 == this.y){
                                        moveDownLeft();
                                    } else {
                                        if(p.getX()+1 == this.x && p.getY() == this.y){
                                            moveRight();
                                        } else {
                                            if(p.getX()-1 == this.x && p.getY() == this.y){
                                                moveLeft();
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
    
}
