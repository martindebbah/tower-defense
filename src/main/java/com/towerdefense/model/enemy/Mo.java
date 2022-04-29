package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;

public class Mo extends Enemy {

    private BufferedImage image;

    public Mo(Game game, int y) {
        super(game, 0, y, 10000, 10000);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2024.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 1500;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Boss de donjon"; // Peut-être nom à changer
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

}
