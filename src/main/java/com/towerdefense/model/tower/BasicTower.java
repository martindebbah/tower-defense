package com.towerdefense.model.tower;

import java.awt.Color;

import com.towerdefense.model.enemy.Enemy;

public class BasicTower extends Tower {

    @Override
    public Tower newTower() {
        return new BasicTower();
    }

    @Override
    public String toString() {
        return "Tour basique";
    }

    @Override
    public int getAttackSpeed() {
        return 20;
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
        // return Color.BLUE;
    }

}
