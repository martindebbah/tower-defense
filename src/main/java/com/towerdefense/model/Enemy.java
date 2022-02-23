package com.towerdefense.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Enemy {

    private Game game;
    private int health;
    private int maxHealth;
    private int x;
    private int y;
    private Stack<Tile> path;
    private int direction;

    public Enemy(int health, Game game, int x, int y) { // x et y donnent l'endroit où apparaît l'unité
        this.health = health;
        this.maxHealth = health;
        this.game = game;
        this.x = x;
        this.y = y;
        this.direction = 0;
    }

    public Game getGame() {
        return game;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public int[] getCoord() { // Renvoie un tableau contenant les coordonnées de l'unité {x, y}
        int[] coord = new int[2];
        coord[0] = x;
        coord[1] = y;
        return coord;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getGold() {// Fonction définie dans chaque classe qui hérite de Enemy
        return 0;
    }

    public int getMovementSpeed() { // Dans les classes
        return 0;
    }

    public String toString() { // Fonction définie dans chaque classe qui hérite de Enemy
        return "";
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

    public Stack<Tile> getPath(){
        return path;
    }

    public void setPath(){
        int fx = (game.getBoard().getNbCases() - 1) * game.getBoard().getSize();
        int fy = game.getBoard().getNbCases() / 2 * game.getBoard().getSize();
        this.path = goodPath(shorterPath(fx, fy, game.getBoard()));
    }

    public void kill() {
        if (getHP() == 0)
            game.getBoard().killEnemy(this);
    }

    public void move(int h, int v) {
        x += h * getMovementSpeed();
        y += v * getMovementSpeed();
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
        if(board.outOfBoard(x, y) || board.getBoard()[x][y].containsTower() || closed.contains(board.getBoard()[x][y]) || wall(current, x, y, board))
            return;
            
        if(!board.getBoard()[x][y].containsTower() && !closed.contains(board.getBoard()[x][y])){ // * vérifie si les noeuds voisins sont valide
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

    public boolean wall(Tile current, int x, int y, Board board) { // fonction non fonctionnelle !!
        if (current.getX() / board.getSize() == x + 1 && current.getY() / board.getSize() == y + 1)
            return board.getBoard()[x][y+1].containsTower() && board.getBoard()[x+1][y].containsTower();
        if (current.getX() / board.getSize() == x - 1 && current.getY() / board.getSize() == y + 1)
            return board.getBoard()[x][y+1].containsTower() && board.getBoard()[x-1][y].containsTower();
        if (current.getX() / board.getSize() == x + 1 && current.getY() / board.getSize() == y - 1)
            return board.getBoard()[x][y-1].containsTower() && board.getBoard()[x+1][y].containsTower();
        if (current.getX() / board.getSize() == x - 1 && current.getY() / board.getSize() == y - 1)
            return board.getBoard()[x][y-1].containsTower() && board.getBoard()[x-1][y].containsTower();
        return false;
    }

    public Tile shorterPath(int fx, int fy, Board board){ // application de l'algo A*
        ArrayList<Tile> open = new ArrayList<>(); // liste ouverte
        ArrayList<Tile> closed = new ArrayList<>(); // liste fermée
        Tile current = board.getBoard()[this.x/board.getSize() + (this.x%board.getSize() == 0 ? 0 : 1)][this.y/board.getSize() + (this.y%board.getSize() == 0 ? 0 : 1)];
        System.out.println(current.getX() + " : " + current.getY());

        /*
        Pourquoi ajouter +1 dans les coordonnées de current ??
        */
        
        current.setQuality(dist(current.getX()/board.getSize() + (current.getX()%board.getSize() == 0 ? 0 : 1), current.getY()/board.getSize() + (current.getY()%board.getSize() == 0 ? 0 : 1), fx/board.getSize() + (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize() + (fy%board.getSize() == 0 ? 0 : 1)));
        closed.add(current);

        while(current != board.getBoard()[fx/board.getSize() + (fx%board.getSize() == 0 ? 0 : 1)][fy/board.getSize() + (fy%board.getSize() == 0 ? 0 : 1)]){ // tant que le noeud actuel n'est pas le noeud de sortie
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1), current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)-1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)+1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)-1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)-1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)-1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1), current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)+1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)+1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)+1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)-1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1)+1, fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)+1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1), fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);
            validNode(current.getX()/board.getSize()+ (current.getX()%board.getSize() == 0 ? 0 : 1)-1, current.getY()/board.getSize()+ (current.getY()%board.getSize() == 0 ? 0 : 1), fx/board.getSize()+ (fx%board.getSize() == 0 ? 0 : 1), fy/board.getSize()+ (fy%board.getSize() == 0 ? 0 : 1), board, closed, open, current);

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

        System.out.println(current.getX() + " : " + current.getY());

        return current;
    }

    public Stack<Tile> goodPath(Tile path){
        Stack<Tile> reversePath = new Stack<Tile>();
        while(path != null){ // ajoute les noeuds et leurs parents pour retrouver le chemin (le noeud en argument est la sortie)
            addToPath(path, reversePath);
            System.out.println("Path : p.x : " + path.getX() + " p.y : " + path.getY());
            //reversePath.push(path);
            path = path.getParent();
        }
        return reversePath;
    } // appel récursif pour gagner de l'espace ?

    private void addToPath(final Tile t, Stack<Tile> path) {
        new Thread() {  // new Thread to avoid java heap space
            @Override
            public void run() {
                path.push(t);
            }
        }.start();
    }

    public void move(){ // Cette fonction a un problème
        if (!path.isEmpty()) {  // Elle calcule mal les déplacements que doit faire l'unité. (Sans les path.pop() c'est déjà mieux)
            Tile p = path.peek();   // Mais encore des erreurs (des fois l'ennemi passe par dessus une tour)
            // System.out.println("e.x : " + x + " e.y : " + y);
            // System.out.println("p.x : " + p.getX() + " p.y : " + p.getY());
            if (p.getX() == x && p.getY() == y)
                path.pop();
            if(p.getX() == x && p.getY() < y){
                direction = 1;
                //path.pop();
            } else {
                if(p.getX() > x && p.getY() < y){
                    direction = 2;
                    //path.pop();
                } else {
                    if(p.getX() < x && p.getY() < y){
                        direction = 3;
                        path.pop();
                    } else {
                        if(p.getX() == x && p.getY() > y){
                            direction = 4;
                            //path.pop();
                        } else {
                            if(p.getX() > x && p.getY() > y){
                                direction = 5;
                                //path.pop();
                            } else {
                                if(p.getX() < x && p.getY() > y){
                                    direction = 6;
                                    //path.pop();
                                } else {
                                    if(p.getX() > x && p.getY() == y){
                                        direction = 7;
                                        //path.pop();
                                    } else {
                                        if(p.getX() < x && p.getY() == y){
                                            direction = 8;
                                            //path.pop();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //printPath();
        direction();
    }

    public void printPath() {
        Iterator<Tile> i = path.iterator();
        while (i.hasNext()) {
            Tile p = i.next();
            System.out.println("p.x : " + p.getX() + " p.y : " + p.getY());
        }
    }

    public void direction() {
        switch(direction) {
            case 1: moveUp();
                break;
            case 2: moveUpRight();
                break;
            case 3: moveUpLeft();
                break;
            case 4: moveDown();
                break;
            case 5: moveDownRight();
                break;
            case 6: moveDownLeft();
                break;
            case 7: moveRight();
                break;
            case 8: moveLeft();
                break;
            // default : System.out.println("Path vide");
        }
    }
    
}
