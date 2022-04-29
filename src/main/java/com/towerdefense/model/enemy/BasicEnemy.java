package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;
import com.towerdefense.view.menu.SoundManager;

public class BasicEnemy extends Enemy {

    private BufferedImage image;

    public BasicEnemy(Game game, int y) {
        super(game, 0, y, 150, 150);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile001.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 30;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi de base"; // Peut-être nom à changer
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
    
}
