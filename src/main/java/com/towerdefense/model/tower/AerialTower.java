package com.towerdefense.model.tower;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.enemy.Enemy;

public class AerialTower extends Tower {

    private BufferedImage image;

    public AerialTower(int damage) {
        super(damage);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2001.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Tower newTower() {
        return new AerialTower(10);
    }

    @Override
    public String toString() {
        return "Tour anti-aérienne";
    }

    @Override
    public int getAttackSpeed() {
        return 20;
    }

    @Override
    public int getPrice() {
        switch (level) {
            default: return 100;
            case 1: return 150;
            case 2: return 250;
        }
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
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean canFocusAerial(Enemy e) {
        return e.isAerial();
    }

    @Override
    public void upgrade(){
        this.level++;
        switch(this.level){
            case 1:
                initialDamage += 20;
                break;
            case 2:
                initialDamage += 40;
                break;
            case 3:
                initialDamage += 80;
        }
    }

}
