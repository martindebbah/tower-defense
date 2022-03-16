package com.towerdefense.model;

import java.awt.Color;

public class AerialTower extends Tower {

    @Override
    public String toString() {
        return "Tour anti-aérienne";
    }

    @Override
    public int getAttackSpeed() {
        return 1;
    }

    @Override
    public int getPrice() {
        return 10;
    } // plus cher ou pas ?

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
        return Color.YELLOW;
    }

    @Override
    public boolean canFocus(Enemy e) {
        return e.isAerial();
    }

}
