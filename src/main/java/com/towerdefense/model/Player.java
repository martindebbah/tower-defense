package com.towerdefense.model;

public class Player {

    private int health;
    private int money;
    private String name;

    public Player(String name) {
        this.health = 1000;
        this.money = 100; // Combien ?
        this.name = name;
    }

    public int getHP(){
        return health;
    }

    public void getHit(Enemy enemy) {
        health -= enemy.getHP()*enemy.getMaxHealth()/100;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean canAfford(Tower tower) {
        return money >= tower.getPrice();
    }
    
}
