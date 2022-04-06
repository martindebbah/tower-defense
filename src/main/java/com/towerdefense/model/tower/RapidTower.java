package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class RapidTower extends Tower {

    public RapidTower(int damage) {
        super(damage);
    }

    @Override
    public Tower newTower() {
        return new RapidTower(10);
    }

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
        return 250;
    } // à voir

    @Override
    public int getRange() {
        return 8;
    }

    @Override
    public Color getColor() {
        return new Color(51, 153, 153);
    }
    //Pas très important encore une fois

    @Override
    public boolean canFocusAerial(Enemy e) {
        return !e.isAerial();
    }

    @Override
    public void upgrade(){
        level++;
        switch(level){
            case 1:
                initialDamage += 20;
                break;
            case 2:
                initialDamage += 40;
                break;
            case 3:
                initialDamage += 100;
                break;
        }
    }
}
