package com.towerdefense.model.enemy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Game;
import com.towerdefense.model.Tile;

public class AerialEnemy extends Enemy {

    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;
    private int current_img = 1;

    public AerialEnemy(Game game, int y) {
        super(game, 0, y, 100, 100);
        try {
            this.image1 = ImageIO.read(new File("src/main/resources/Images/flight/flight1.png"));
            this.image2 = ImageIO.read(new File("src/main/resources/Images/flight/flight2.png"));
            this.image3 = ImageIO.read(new File("src/main/resources/Images/flight/flight3.png"));
            this.image4 = ImageIO.read(new File("src/main/resources/Images/flight/flight4.png"));
            this.image5 = ImageIO.read(new File("src/main/resources/Images/flight/flight5.png"));
            this.image6 = ImageIO.read(new File("src/main/resources/Images/flight/flight6.png"));
            this.image7 = ImageIO.read(new File("src/main/resources/Images/flight/flight7.png"));
            this.image8 = ImageIO.read(new File("src/main/resources/Images/flight/flight8.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public int getGold() {
        return 50;
    }

    public int getScore() {
        return 30;
    }

    @Override
    public int getMovementSpeed() {
        return 2;
    }

    @Override
    public String toString() {
        return "Ennemi aérien";
    }

    @Override
    public boolean isAerial(){
        return true;
    }

    @Override
    public void setPath() { // Nouvelle façon de calculer le chemin des ennemis aériens
        List<Tile> reversed = new ArrayList<Tile>();
        int n = game.getBoard().getNbCases();

        for (int i = n - 1; i > getX() / game.getBoard().getSize(); i--)
            reversed.add(game.getBoard().getBoard()[i][n / 2]);

        path = new Stack<Tile>();
        for (Tile t : reversed)
            path.push(t);
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
