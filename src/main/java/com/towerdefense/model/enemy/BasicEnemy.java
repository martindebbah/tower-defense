package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;
import com.towerdefense.view.menu.SoundManager;

public class BasicEnemy extends Enemy {

    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;
    private int current_img = 1;

    public BasicEnemy(Game game, int y) {
        super(game, 0, y, 150, 150);
        try {
            this.image1 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_idle_anim_f0.png"));
            this.image2 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_idle_anim_f1.png"));
            this.image3 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_idle_anim_f2.png"));
            this.image4 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_idle_anim_f3.png"));
            this.image5 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_run_anim_f0.png"));
            this.image6 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_run_anim_f1.png"));
            this.image7 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_run_anim_f2.png"));
            this.image8 = ImageIO.read(new File("src/main/resources/Images/gobelin/chort_run_anim_f3.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public int getCurrentImg(){
        return current_img;
    }

    @Override
    public int getGold() {
        return 30;
    }

    @Override
    public int getScore() {
        return 20;
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
