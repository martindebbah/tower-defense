package com.towerdefense.model;

import com.towerdefense.level.Level;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.Tower;

public class Player {

    private int health;
    private int money;
    private String name;
    private int score;
    private String mode;

    public Player(String name) {
        this.health = 1000;
        this.money = 20000;
        this.name = name;
        this.score = 0;
    }

    public Player() {
        this("");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(Level l) {
        this.mode = l.name().toLowerCase();
    }

    public String getMode() {
        return mode;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int n) {
        score += n;
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
