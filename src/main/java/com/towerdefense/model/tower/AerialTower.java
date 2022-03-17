package com.towerdefense.model.tower;

import java.awt.Color;

import com.towerdefense.model.enemy.Enemy;

public class AerialTower extends Tower {

    @Override
    public Tower newTower() {
        return new AerialTower();
    }

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
        return 10;
    }

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() {
        return new Color(245, 241, 4);
    }

    @Override
    public Color getPreviewColor() {
        return new Color(234, 232, 104);
    }

    @Override
    public boolean canFocus(Enemy e) {
        return e.isAerial();
    }

}
