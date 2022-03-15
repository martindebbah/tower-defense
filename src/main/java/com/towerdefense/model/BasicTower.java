package com.towerdefense.model;

import java.awt.Color;

public class BasicTower extends Tower {

    @Override
    public String toString() {
        return "Tour basique";
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
        return 0;
    }

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public boolean canFocus(Enemy e) {
        return !e.isAerial();
    }
    
}
