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
        return 1;
    }

    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() {
        return new Color(19, 84, 173);
    }

    @Override
    public Color getPreviewColor() {
        return new Color(47, 125, 231);
    }

    @Override
    public boolean canFocus(Enemy e) {
        return !e.isAerial();
    }
    
}
