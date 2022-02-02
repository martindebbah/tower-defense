package com.towerdefense.view;

import javax.swing.JFrame;

public class Window extends JFrame {

    private BoardView board;

    public Window() {
        setSize(640, 640);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        board = new BoardView();
        add(board);
        setVisible(true);
    }
    
}
