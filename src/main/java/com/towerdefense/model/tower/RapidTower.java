package com.towerdefense.model.tower;

import com.towerdefense.model.enemy.Enemy;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RapidTower extends Tower {

    private BufferedImage image;

    public RapidTower(int damage) {
        super(damage);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2006.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Tower newTower() {
        return new RapidTower(5);
    }

    @Override
    public String toString() {
        return "Tour rapide";
    }

    @Override
    public int getAttackSpeed() {
        return 10;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1: return 150;
            case 2: return 250;
            default: return 100;
        }
    }

    @Override
    public int getRange() {
        return 8;
    }

    @Override
    public Color getColor() {
        return new Color(51, 153, 153);
    }
    
    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean canFocusAerial(Enemy e) {
        return !e.isAerial();
    }

    @Override
    public void upgrade(){
        level++;
        switch(level){
            case 1:
                initialDamage += 15;
                break;
            case 2:
                initialDamage += 30;
                break;
            case 3:
                initialDamage += 60;
                break;
        }
    }
}
