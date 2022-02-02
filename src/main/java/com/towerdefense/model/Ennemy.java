package com.towerdefense.model;

public class Ennemy {

    private Game game;
    private int health;
    private int maxHealth;
    private int movementSpeed;
    private int x;
    private int y;

    public Ennemy(int health, int movementSpeed, int x, int y) { // x et y donnent l'endroit où apparaît l'unité
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

    public void getHit(int damage) { // Appelé par la tour qui inflige les dommages à l'unité
        health -= damage;
    }

    public void crossedBoard() { // L'unité a traversé le plateau (fait perdre un pdv au joueur)
        game.getPlayer().getHit();
    }

    public int getHP() {
        return health * 100 / maxHealth;
    }

    public void move(int h, int v) {
        x += h * movementSpeed;
        y += v * movementSpeed;
    }

    public void moveUp() {
        move(0, -1);
    }
    public void moveDown() {
        move(0, 1);
    }
    public void moveRight() {
        move(1, 0);
    }
    public void moveLeft() {
        move(-1, 0);
    }
    
}
