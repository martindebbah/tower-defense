package com.towerdefense.model;

public class BasicTower extends Tower {

    @Override
    public String toString() {
        return "Tour de base";
    }

    @Override
    public int getAttackSpeed() {
        return 1;
    }

    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public int getDamage() {
        return 5;
    }

    public int getRange() {
        return 5;
    }
    
}
