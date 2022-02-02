package com.towerdefense.view;

import javax.swing.JFrame;

import com.towerdefense.model.Ennemy;
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
        Ennemy e = new Ennemy(100, 1, 0, 0);
        board.addEnnemy(e);
        Tower t = new Tower(1, 1, 1);
        board.addTower(t, 5, 7);

        while (true) {
            try {
                Thread.sleep(50);
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            e.move(2, 1);
            play();
        }

    }

    private void createBoard() { // Créer une vue pour le plateau (peut-être ajouter un modèle)
        board = new BoardView();
        add(board, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    private void play() {
        board.revalidate();
        board.repaint();
        revalidate();
        repaint();
    }
    
}
