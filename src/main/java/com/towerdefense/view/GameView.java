package com.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.towerdefense.model.Game;
import com.towerdefense.model.Player;
import com.towerdefense.model.Wave;

public class GameView extends JPanel implements ActionListener {

    private BoardView board;
    private Shop shop;
    private Game game;
    private Wave wave;
    private Player player;
    private Window window;
    private Timer timer1 = new Timer(50, this); // x2 = 25, x4 = 12/13 ?
    private Timer timer2 = new Timer(25, this);
    private int speed = 1;

    public GameView(Window window, Player p) {
        this.window = window;
        setSize(1000, 1000);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        this.player = p;
        this.game = new Game(32, 20, player);
        createShop();
        createBoard();
        this.wave = new Wave(this.game,20);
        WaveView w = new WaveView(wave, this);
        add(w, BorderLayout.NORTH);
    }

    private void createBoard() { // Créer une vue pour le plateau
        board = new BoardView(game, shop);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panel.add(board);
        add(panel, BorderLayout.WEST);
    }

    private void createShop() {
        shop = new Shop();
        add(shop, BorderLayout.EAST);
    }

    public void start() {
        switch (speed) {
            case 1: timer1.start();
                break;
            case 2: timer2.start();
                break;
        }
        board.start();
        window.refresh();
    }

    public void pause() {
        switch (speed) {
            case 1: timer1.stop();
                break;
            case 2: timer2.stop();
                break;
        }
        board.pause();
        window.refresh();
    }

    public void changeSpeed() {
        pause();
        switch (speed) {
            case 1: speed = 2;
                break;
            case 2: speed = 1;
                break;
        }
        start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.isAlive()){ // condition d arreter wave superieur au max de wave + aucun enemy sur le board
            if(wave.getCurrentWave() < wave.getNbWaves()){
                if (wave.getFinChrono()){ // check si le chrono est fini pour passer a la wave suivante
                    wave.incrementWave(); // passe à la wave suivante
                    wave.setFinChrono(false);
                }
                wave.play();
                window.refresh();
            } else {
                if(board.getBoard().getEnemies().isEmpty()){
                    endGame(0);
                }
            }
        }else{
            endGame(1);
        }
    }

    public void endGame(int status) {
        pause();
        window.endGame(status);
    }

}