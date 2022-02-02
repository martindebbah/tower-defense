package com.towerdefense.model;

public class Ennemy extends Units {

    private Game game;
    private int health;
    private int movementSpeed;
    private int x;
    private int y;

    public Ennemy(int health, int movementSpeed, int x, int y) { // x et y donnent l'endroit où apparaît l'unité
        this.health = health;
        this.movementSpeed = movementSpeed;
        this.x = x;
        this.y = y;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public int[] getCoord() { // Renvoie un tableau contenant les coordonnées de l'unité {x, y}
        int[] coord = new int[2];
        coord[0] = x;
        coord[1] = y;
        return coord;
    }

    public boolean isAlive() { // Vraiment la bonne méthode ?
        return health > 0;     // Comment faire disparaître l'unité ?
    }

    public void getHit(int damage) { // Appelé par la tour qui inflige les dommages à l'unité
        health -= damage;
    }

    public void crossedBoard() { // L'unité a traversé le plateau (fait perdre un pdv au joueur)
        game.getPlayer().getHit();
    }

    public void move(int h, int v) {
        x += h;
        y += v;
    }
    
}
