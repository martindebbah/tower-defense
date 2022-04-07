package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;

public class AerialEnemy extends Enemy {

    private BufferedImage image;

    public AerialEnemy(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2, 100, 100);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile1003.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 25;
    }

    @Override
    public int getMovementSpeed() {
        return 2;
    }

    @Override
    public String toString() {
        return "Ennemi aérien"; // Peut-être nom à changer ("Unité aérienne")
    }

    @Override
    public boolean isAerial(){
        return true;
    }

    @Override
    public void move(){
        this.moveRight();
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
    
}
