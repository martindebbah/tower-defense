package com.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.towerdefense.level.Level;
import com.towerdefense.model.Game;
import com.towerdefense.model.Player;
import com.towerdefense.model.Wave;
import com.towerdefense.model.enemy.Enemy;

public class GameView extends JPanel implements ActionListener {

    private BoardView board;
    private Shop shop;
    private Game game;
    private Wave wave;
    private Player player;
    private Window window;
    private Timer timer1 = new Timer(50, this);
    private Timer timer2 = new Timer(25, this);
    private Timer timer5 = new Timer(10, this);
    private int speed = 1;

    public GameView(Window window, Level level) {
        this.window = window;
        setSize(1000, 1000);
        setLayout(new BorderLayout());

        // Création du plateau de jeu
        this.player = new Player();
        player.setMode(level);
        this.game = new Game(40, 20, player, level);
        createShop();
        createBoard();
        this.shop.setBoard(board.getBoard());
        this.wave = new Wave(this.game,level);
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
        shop = new Shop(player, window, this);
        add(shop, BorderLayout.EAST);
    }

    public void start() {
        switch (speed) {
            case 1: timer1.start();
                break;
            case 2: timer2.start();
                break;
            case 5: timer5.start();
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
            case 5: timer5.stop();
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
            case 2: speed = 5;
                break;
            case 5: speed = 1;
                break;
        }
        start();
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wave.actionPerformed(e);
        if (player.isAlive()){ // condition d'arrêter wave supérieure au max de wave + aucun enemy sur le board
            if(wave.getCurrentWave() < wave.getNbWaves()){
                if (wave.getFinChrono()){ // check si le chrono est fini pour passer à la wave suivante
                    wave.incrementWave(); // passe à la wave suivante
                    wave.initializeWave();
                    wave.setFinChrono(false);
                }
                wave.play();
                window.refresh();
            } else {
                if(wave.getNbEnemies() <= 0 && board.getBoard().getEnemies().isEmpty()){
                    endGame(0);
                    return;
                }
                wave.play();
                window.refresh();
            }
        }else{
            endGame(1);
        }
    }

    public void endGame(int status) {
        killBoard();
        window.endGame(status, game.getPlayer());
    }

    public void killBoard(){
        pause();
        for(Enemy e : board.getBoard().getEnemies()){
            board.getBoard().addKillEnemy(e);
        }
        board.getBoard().kill();
        for(int i = 0; i < board.getBoard().getBoard().length; i++){
            for(int j = 0; j < board.getBoard().getBoard().length; j++){
                if(board.getBoard().getBoard()[i][j].containsTower()){
                    board.getBoard().removeTower(i, j);
                }
            }
        }
        window.refresh();
    }

    public void muteEnemies(){
        for(Enemy e : board.getBoard().getEnemies()){
            e.stop();
        }
    }

    public void demuteEnemies(){
        for(Enemy e : board.getBoard().getEnemies()){
            e.sound();
        }
    }

    public BoardView getBoardView(){
        return board;
    }

}