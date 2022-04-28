package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;

public class TankEnemy extends Enemy{

    private BufferedImage image;

    public TankEnemy(Game game, int y) {
        super(game, 0, y, 800, 800);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile1004.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 250;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi tank"; // Peut-être nom à changer ("Tank")
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
    
}
