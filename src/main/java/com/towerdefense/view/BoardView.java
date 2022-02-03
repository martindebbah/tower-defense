package com.towerdefense.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.towerdefense.model.Board;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Tower;
import java.awt.Color;
import java.awt.Graphics;


public class BoardView extends JPanel {

    private Board board;
    private int size = 32;

    public BoardView() {
        setPreferredSize(new java.awt.Dimension(size * 20, size * 20));
        setBorder(new EmptyBorder(100, 100, 100, 100)); // Comment faire ?
        this.board = new Board();
    }

    public void addEnnemy(Enemy e) {
        board.addEnnemy(e);
    }

    public void addTower(Tower t, int x, int y) {
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
                    Tower t = board.getTower(x, y);
                    g.setColor(Color.BLUE);
                    g.fillRect(x * size, y * size, size, size);
                    t.focus(board);
                    if (t.canAttack() && t.isNewTarget()) {
                        t.attack();
                    }
                }
        		g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
        	}
        }

        for (Enemy e : board.getEnnemies()) {
            g.setColor(Color.RED);
            int[] coord = e.getCoord();
            g.fillOval(coord[0], coord[1], size, size);
            g.setColor(Color.GREEN);
            g.drawRect(coord[0], coord[1] - 10, size, 5);
            g.fillRect(coord[0], coord[1] - 10, e.getHP() * size / 100, 5);
        }
    }

    
}
