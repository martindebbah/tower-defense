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
    private Wave wave;

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
        this.wave = new Wave(this.game,60);
        WaveView w = new WaveView(wave);
        createShop();
        createBoard();
        add(w, BorderLayout.NORTH);

        // test

        while(player.isAlive() && wave.getCurrentWave() <= wave.getNbWaves()){
            if(wave.getFinChrono()){
                wave.incrementWave();
                System.out.println(wave.getCurrentWave());
                wave.setFinChrono(false);
            }
            play();
        }

        wave.setFinishGame(true);
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
        wave.play();
        revalidate();
        repaint();
    }
    
}
