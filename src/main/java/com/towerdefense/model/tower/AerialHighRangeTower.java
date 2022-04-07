package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class AerialHighRangeTower extends Tower {

    public AerialHighRangeTower(int damage) {
        super(damage);
    }

    @Override
    public Tower newTower() {
        return new AerialHighRangeTower(5);
    }

    @Override
    public String toString() {
        return "Tour aérienne à longue portée";
    }

    @Override
    public int getAttackSpeed() {
        return 20;
    }

    @Override
    public int getPrice() {
        return 10;
    } // à voir

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public int getRange() {
        return 10;
    } // Deux fois plus large que BasicTower

    @Override
    public Color getColor() {
        return new Color(204, 0, 102);
    }

    @Override
    public boolean canFocusAerial(Enemy e) {
        return e.isAerial();
    }
}
