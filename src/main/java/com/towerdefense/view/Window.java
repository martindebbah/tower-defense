package com.towerdefense.view;

import javax.swing.JFrame;

import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Tower;

import java.awt.BorderLayout;

public class Window extends JFrame {

    private BoardView board;

    public Window() {

        //Définition de la fenêtre
        setSize(700, 700);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        createBoard();

        // test
        Enemy e = new Enemy(100, 3, -32, 4*32);
        board.addEnnemy(e);
        Tower t = new BasicTower();
        board.addTower(t, 5, 0);

        while (true) {
            play();
            e.moveRight();
        }

    }

    private void createBoard() { // Créer une vue pour le plateau (peut-être ajouter un modèle)
        board = new BoardView();
        add(board, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    public void play() {
        try {
            Thread.sleep(50);
        }catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        revalidate();
        repaint();
    }
    
}
