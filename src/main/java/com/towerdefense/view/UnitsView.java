package com.towerdefense.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class UnitsView extends JPanel {

    public UnitsView() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
    }
    
}
