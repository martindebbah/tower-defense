package com.towerdefense.model.tower;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;

public class HighRangeTower extends Tower {

    public HighRangeTower(int damage) {
        super(damage);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Tower newTower() {
        return new HighRangeTower(5);
    }

    @Override
    public String toString() {
        return "Tour à longue portée";
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
    }
    // Pas très important, pour l'instant j'ai mis un pourpre

}
