package com.towerdefense.model.tower;

import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.enemy.Enemy;

public class BasicTower extends Tower {

    private BufferedImage image;

    public BasicTower(int damage) {
        super(damage);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2000.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Tower newTower() {
        return new BasicTower(20);
    }

    @Override
    public String toString() {
        return "Tour basique";
    }

    @Override
    public int getAttackSpeed() {
        return 20;
    }

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public int getRange() {
        return 5;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
        // return Color.BLUE;
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
