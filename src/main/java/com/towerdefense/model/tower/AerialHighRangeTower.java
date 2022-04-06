package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class AerialHighRangeTower extends Tower {

    public AerialHighRangeTower(int damage) {
        super(damage);
        // TODO Auto-generated constructor stub
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
    } // Pour l'instant un rayon deux fois plus large

    @Override
    public Color getColor() {
        return new Color(204, 0, 102);
    } // j'ai pas spécialement d'idée donc pourpre à nouveau

    @Override
    public boolean canFocusAerial(Enemy e) {
        return e.isAerial();
    }
}
