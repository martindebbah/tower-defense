package com.towerdefense.model.enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.towerdefense.model.Board;
import com.towerdefense.model.Game;
import com.towerdefense.model.Tile;
import com.towerdefense.view.menu.SoundManager;

import java.awt.image.BufferedImage;

public class Enemy {

    protected Game game;
    protected int health;
    protected int maxHealth;
    private int x;
    private int y;
    protected Stack<Tile> path;
    private int direction;
    private SoundManager s = new SoundManager();

    public Enemy(Game game, int x, int y, int maxHealth, int health) { // x et y donnent l'endroit où apparaît l'unité
        this.maxHealth = maxHealth;
        this.health = health;
        this.game = game;
        this.x = x;
        this.y = y;
        this.direction = 0;
    }

    public Game getGame() {
        return game;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int m) {
        this.maxHealth += m;
        this.health = maxHealth;
    }

    public int getGold() {// Fonction définie dans chaque classe qui hérite de Enemy
        return 0;
    }

    public int getScore() {
        return 0;
    }

    public int getMovementSpeed() { // Dans les classes
        return 0;
    }

    public String toString() { // Fonction définie dans chaque classe qui hérite de Enemy
        return "";
    }

    public boolean isAerial() {
        return false;
    }

    public void getHit(int damage) { // Appelée par la tour qui inflige les dommages à l'unité
        health -= damage;
    }

    public void crossedBoard() { // L'unité a traversé le plateau (fait perdre des pv au joueur)
        game.getPlayer().getHit(this);
        health = 0;
    }

    public int getHP() {
        return health * 100 / maxHealth;
    }

    public Stack<Tile> getPath() {
        return path;
    }

    public void setPath() {
        int fx = game.getBoard().getNbCases() - 1; // Pas en pixel -> en cases
        int fy = game.getBoard().getNbCases() / 2; // Pas en pixel -> en cases
        path = goodPath(shorterPath(fx, fy, game.getBoard()), new Stack<Tile>());
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

    public double dist(int x1, int y1, int x2, int y2) { // renvoie la distance entre deux cases
        return (double) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double distToEnd() { // Renvoie la distance entre l'ennemi et le point d'arrivée
        if (path == null)
            return 0;
        return path.size();
    }

    public void validNode(int x, int y, int fx, int fy, Board board, ArrayList<Tile> closed, ArrayList<Tile> open,
            Tile current) {
        Tile next = board.getBoard()[x][y];

        if (closed.contains(next)) // Si la case est déjà dans la liste fermée, on ne l'ajoute pas
            return;

        double tempKnown = current.getKnownDistance() + dist(next.getX(), next.getY(), current.getX(), current.getY());
        
        if(open.contains(next)) { 
        	// si le noeud est déjà dans la liste ouverte on vérifie sa qualité et on la met à jour si elle est meilleure
            if (tempKnown < next.getKnownDistance()) {
                next.setKnownDistance(tempKnown);
                next.setParent(current);
            }
        }else { // Si le noeud n'est pas dans la liste ouverte on l'ajoute
            next.setParent(current);
            next.setKnownDistance(tempKnown);
            open.add(next);
        }

        // On met à jour
        next.setDistance(dist(x, y, fx, fy));
        next.setTotalDistance(next.getKnownDistance() + next.getDistance());
    }

    public Tile shorterPath(int fx, int fy, Board board) { // application de l'algo A*
        ArrayList<Tile> open = new ArrayList<>(); // liste ouverte
        ArrayList<Tile> closed = new ArrayList<>(); // liste fermée
        Tile current = getFirstTile(board);

        if (current == board.getBoard()[fx][fy])
            return null;

        current.setDistance(dist(current.getX() / board.getSize() + (current.getX() % board.getSize() == 0 ? 0 : 1),
                current.getY() / board.getSize() + (current.getY() % board.getSize() == 0 ? 0 : 1), fx, fy));
        closed.add(current);
        current.setParent(null);
        current.setKnownDistance(0);
        List<Tile> neighbors;

        while (current != board.getBoard()[fx][fy]) { // tant que le noeud actuel n'est pas le noeud de sortie

            neighbors = board.getNeighborsOf(current, this);

            for (Tile t : neighbors){
                validNode(t.getX() / board.getSize(), t.getY() / board.getSize(), fx, fy, board, closed, open, current);
            }

            Tile best = open.get(0);
            for (int i = 1; i < open.size(); i++) // check le noeud qui possède la meilleure qualité
                if (open.get(i).getTotalDistance() < best.getTotalDistance())
                    best = open.get(i);

            open.remove(best); // on le retire de la liste ouverte
            closed.add(best); // on l'ajoute à la liste fermée

            current = best;
        }

        return current;
    }

    public Tile getFirstTile(Board board) { // Donne la première case que l'ennemi doit visiter
        if (path != null && !path.isEmpty())
            return path.peek();
        return board.getBoard()[x / board.getSize()][y / board.getSize()];
    }

    public Stack<Tile> goodPath(Tile tile, Stack<Tile> path) {
        if (tile == null)
            return path;
        path.push(tile);
        return goodPath(tile.getParent(), path);
    }

    public void move() {
        if (!path.isEmpty()) {
            Tile p = path.peek();
            if (p.getX() == x && p.getY() == y)
                path.pop();
            if (p.getX() == x && p.getY() < y)
                direction = 1;
            else if (p.getX() > x && p.getY() < y)
                direction = 2;
            else if (p.getX() < x && p.getY() < y)
                direction = 3;
            else if (p.getX() == x && p.getY() > y)
                direction = 4;
            else if (p.getX() > x && p.getY() > y)
                direction = 5;
            else if (p.getX() < x && p.getY() > y)
                direction = 6;
            else if (p.getX() > x && p.getY() == y)
                direction = 7;
            else if (p.getX() < x && p.getY() == y)
                direction = 8;
            else if (x / game.getBoard().getSize() == game.getBoard().getNbCases() - 1
                    && y / game.getBoard().getSize() == game.getBoard().getNbCases() / 2)
                direction = 7;
        }
        direction();
    }

    public void direction() {
        switch (direction) {
            case 1:
                moveUp();
                break;
            case 2:
                moveUpRight();
                break;
            case 3:
                moveUpLeft();
                break;
            case 4:
                moveDown();
                break;
            case 5:
                moveDownRight();
                break;
            case 6:
                moveDownLeft();
                break;
            case 7:
                moveRight();
                break;
            case 8:
                moveLeft();
                break;
        }
    }

    public BufferedImage getImage() { // Dans chaque classe
        return null;
    }

    public void stop() {
        s.stop();
    }

    public void sound(){
        s.play(3);
    }

}
