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

    private BufferedImage image;

    public AerialEnemy(Game game, int y) {
        super(game, 0, y, 100, 100);
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile1003.png"));
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
        return "Ennemi aérien"; // Peut-être nom à changer ("Unité aérienne")
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
        return image;
    }
    
}
