package com.towerdefense.model;

public class Ennemy extends Units {

    private Game game;
    private int health;
    private int movementSpeed;

    public Ennemy(int health, int movementSpeed) {
        this.health = health;
        this.movementSpeed = movementSpeed;
    }

    public Game getGame() {
        return game;
    }

    public boolean isAlive() { // Vraiment la bonne méthode ?
        return health > 0;     // Comment faire disparaître l'unité ?
    }

    public void getHit(int damage) {
        health -= damage;
    }

    public void crossedBoard() {
        game.getPlayer().getHit();
    }
    
}
