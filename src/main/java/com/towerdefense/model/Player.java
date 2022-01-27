package com.towerdefense.model;

public class Player {

    private int health;
    private int money;

    public Player() {
        this.health = 25;
        this.money = 100; // Combien ?
    }

    public void getHit() {
        health -= 1;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean canAfford(Tower tower) {
        return money >= tower.getPrice();
    }
    
}
