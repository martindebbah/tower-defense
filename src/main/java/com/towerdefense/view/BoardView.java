package com.towerdefense.view;

import javax.swing.JPanel;

import com.towerdefense.model.Units;
import java.awt.Color;
import java.awt.Graphics;


public class BoardView extends JPanel {

    private Units[][] cases;

    public BoardView() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(int x = 0; x < 20; x++) {
        	for(int y = 0; y < 20; y++) {
        		g.setColor(Color.BLACK);
                g.drawRect(y*32, x*32, 32, 32);
        	}
        }
        
        repaint();
    }

    
}
