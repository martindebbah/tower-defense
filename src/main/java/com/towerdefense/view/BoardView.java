package com.towerdefense.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.towerdefense.model.Board;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Game;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.Tower;
import java.awt.Color;
import java.awt.Graphics;


public class BoardView extends JPanel {

    private Board board;
    private int size;

    public BoardView(Game game) {
        // setBorder(new EmptyBorder(100, 100, 100, 100)); // Comment faire ?
        this.board = game.getBoard();
        size = board.getSize();
        setPreferredSize(new java.awt.Dimension(size * board.getNbCases(), size * board.getNbCases()));
    }

    public void addEnemy(Enemy e) {
        board.addEnemy(e);
    }

    public void addTower(Tower t, int x, int y) {
        board.addTower(t, x, y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
        Combien de cases dans le tableau ? pour le moment 20x20 (choix dans création de Board)
        Est-ce qu'on dessine les cases quand le tableau est vide ?
        */
        
        for(int x = 0; x < board.getNbCases(); x++) {
        	for(int y = 0; y < board.getNbCases(); y++) {
                if (board.getTower(x, y) != null) {
                    Tower t = board.getTower(x, y);
                    g.setColor(Color.BLUE);
                    g.fillRect(x * size, y * size, size, size);                                 // Jusqu'ici
                }
        		g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
        	}
        }

        for (Enemy e : board.getEnemies()) {
            g.setColor(Color.RED);
            int[] coord = e.getCoord();
            g.fillOval(coord[0], coord[1], size, size);
            g.setColor(Color.GREEN);
            g.drawRect(coord[0], coord[1] - 10, size, 5);
            g.fillRect(coord[0], coord[1] - 10, e.getHP() * size / 100, 5);
        }

        for (Projectile p : board.getProjectiles()) {
            g.setColor(p.getColor());
            g.fillOval(p.getX(), p.getY(), size / 4, size / 4);
        }
    }

    
}
