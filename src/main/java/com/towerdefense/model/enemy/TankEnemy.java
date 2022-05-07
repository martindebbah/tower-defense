package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;

public class TankEnemy extends Enemy {

    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;
    private int current_img = 1;

    public TankEnemy(Game game, int y) {
        super(game, 0, y, 800, 800);
        try {
            this.image1 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_idle_anim_f0.png"));
            this.image2 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_idle_anim_f1.png"));
            this.image3 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_idle_anim_f2.png"));
            this.image4 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_idle_anim_f3.png"));
            this.image5 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_run_anim_f0.png"));
            this.image6 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_run_anim_f1.png"));
            this.image7 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_run_anim_f2.png"));
            this.image8 = ImageIO.read(new File("src/main/resources/Images/tankEnemy/ogre_run_anim_f3.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 250;
    }

    @Override
    public int getScore() {
        return 30;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi tank";
    }

    @Override
    public BufferedImage getImage() {
        switch(current_img){
            case 1:
                current_img++;
                return image1;
            case 2:
                current_img++;
                return image2;
            case 3:
                current_img++;
                return image3;
            case 4:
                current_img++;
                return image4;
            case 5:
                current_img++;
                return image5;
            case 6:
                current_img++;
                return image6;
            case 7:
                current_img++;
                return image7;
            case 8:
                current_img = 1;
                return image8;
        }
        return null;
    }

}
