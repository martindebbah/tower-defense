package com.towerdefense.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.towerdefense.model.BasicEnemy;
import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Game;
import com.towerdefense.model.Player;
import com.towerdefense.model.Tower;
import com.towerdefense.model.Wave;

import java.awt.BorderLayout;

public class Window extends JFrame {

    private BoardView board;
    private Shop shop;
    private Game game;

    public Window() {

        //Définition de la fenêtre
        setSize(1000, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        Player player = new Player("Martin");
        this.game = new Game(32, 20, player);
        createShop();
        createBoard();
        add(new WaveView(new Wave(player)), BorderLayout.NORTH);

        // test
        int r = 0;

        while(player.isAlive()){
            if(r == 0){
                Enemy e1 = new BasicEnemy(game);
                e1.setPath();
                board.addEnemy(e1);
            }
            play();
            r++;
        }

    }

    private void createBoard() { // Créer une vue pour le plateau
        board = new BoardView(game, shop);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panel.add(board);
        add(panel, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    private void createShop() {
        shop = new Shop();
        add(shop, BorderLayout.EAST);
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
