package com.towerdefense.view;

import javax.swing.JFrame;

import com.towerdefense.model.BasicEnemy;
import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Game;
import com.towerdefense.model.Tower;
import com.towerdefense.model.Tile;

import java.awt.BorderLayout;
import java.util.Stack;

public class Window extends JFrame {

    private BoardView board;
    private Game game;

    public Window() {

        //Définition de la fenêtre
        setSize(700, 700);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        this.game = new Game(32, 20);
        createBoard();

        // test
        Enemy e = new BasicEnemy(game);
        e.setPath();
        board.addEnemy(e);
        Tower t = new BasicTower();
        Tower t2 = new BasicTower();
        board.addTower(t, 5, 5);
        board.addTower(t2, 6, 6);

        while(true){
            play();
        }

    }

    private void createBoard() { // Créer une vue pour le plateau
        board = new BoardView(game);
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
        game.play();
        revalidate();
        repaint();
    }
    
}
