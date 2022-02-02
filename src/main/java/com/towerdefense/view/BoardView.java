package com.towerdefense.view;

import javax.swing.JPanel;

import com.towerdefense.model.Board;
import com.towerdefense.model.Ennemy;
import com.towerdefense.model.Tower;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class BoardView extends JPanel implements {

    private ArrayList<Ennemy> ennemies;
    private Board board;
    private int size = 32;

    public BoardView() {
        setPreferredSize(new java.awt.Dimension(640, 640));
        this.ennemies = new ArrayList<Ennemy>();
        this.board = new Board();
    }

    public void addEnnemy(Ennemy e) {
        ennemies.add(e);
    }

    public void addTower(Tower t, int x, int y) { // à ajouter dans board ??
        board.addTower(t, x, y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
        Combien de cases dans le tableau ?
        Est-ce qu'on dessine les cases quand le tableau est vide ?
        */
        
        for(int x = 0; x < 20; x++) {
        	for(int y = 0; y < 20; y++) {
                if (board.getTower(x, y) != null) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * size, y * size, size, size);
                }
        		g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
        	}
        }

        for (Ennemy e : ennemies) {
            g.setColor(Color.RED);
            int[] coord = e.getCoord();
            g.fillOval(coord[0], coord[1], size, size);
        }
    }

    
}
