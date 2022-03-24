package com.towerdefense.model;

import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.Tower;

public class Player {

    private int health;
    private int money;
    private String name;

    public Player(String name) {
        this.health = 1000;
        this.money = 100; // Combien ?
        this.name = name;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int m) {
        this.money = m;
    }

    public int getHP() {
        return health;
    }

    public void getHit(Enemy enemy) {
        health -= enemy.getHP() * enemy.getMaxHealth() / 100;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean canAfford(Tower tower) {
        return money >= tower.getPrice();
    }

    @Override
    public String toString() {
        return name;
    }

}
