package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class AerialRapidTower extends Tower {

    public AerialRapidTower(int damage) {
        super(damage);
    }

    @Override
    public Tower newTower() { return new AerialRapidTower(10); }

    @Override
    public String toString() {
        return "Tour aérienne rapide";
    }

    @Override
    public int getAttackSpeed() {
        return 10;
    } // pour l'instant 3x plus

    @Override
    public int getPrice() {
        return 300;
    } // à voir

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public int getRange() {
        return 8;
    }

    @Override
    public Color getColor() { return new Color(51, 153, 153); } // bref

    @Override
    public boolean canFocus(Enemy e) {
        return e.isAerial();
    }
}
