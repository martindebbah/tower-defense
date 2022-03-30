package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class RapidTower extends Tower {

    @Override
    public Tower newTower() { return new RapidTower(); }

    @Override
    public String toString() {
        return "Tour rapide";
    }

    @Override
    public int getAttackSpeed() {
        return 10;
    } // pour l'instant 3x plus

    @Override
    public int getPrice() {
        return 10;
    } // à voir

    @Override
    public int getDamage() {
        return 10;
    } // réduire ou pas ?

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() { return new Color(51, 153, 153); }
    //Pas très important encore une fois

    @Override
    public boolean canFocus(Enemy e) {
        return !e.isAerial();
    }
}
