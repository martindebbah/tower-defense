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
    private Timer timer = new Timer(50, this);

    public GameView(Window window) {
        this.window = window;
        setSize(1000, 1000);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        this.player = new Player("Martin");
        this.game = new Game(32, 20, player);
        createShop();
        createBoard();
        this.wave = new Wave(this.game,60);
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
        timer.start();
        board.start();
        window.refresh();
    }

    public void pause() {
        timer.stop();
        board.pause();
        window.refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.isAlive() && wave.getCurrentWave() < wave.getNbWaves()){ // condition d arreter wave superieur au max de wave + aucun enemy sur le board
            if (wave.getFinChrono()){ // check si le chrono est fini pour passer a la wave suivante
                wave.incrementWave();
                wave.setFinChrono(false);
            }
            wave.play();
            window.refresh();
        }else{
            wave.setFinishGame(true);
        }
    }

}