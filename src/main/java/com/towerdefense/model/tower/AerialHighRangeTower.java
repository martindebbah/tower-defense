package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class AerialHighRangeTower extends Tower {

    @Override
    public Tower newTower() { return new AerialHighRangeTower(); }

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
    } // Pour l'instant un rayon deux fois plus large

    @Override
    public Color getColor() { return new Color(204, 0, 102); } // j'ai pas spécialement d'idée donc pourpre à nouveau

    @Override
    public boolean canFocus(Enemy e) {
        return e.isAerial();
    }
}
