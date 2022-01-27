package com.towerdefense.view;

import javax.swing.JFrame;

public class Window extends JFrame {

    private BoardView board;

    public Window() {
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
