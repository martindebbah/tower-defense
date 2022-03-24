package com.towerdefense.model;

//import java.util.concurrent.*;

import javax.swing.JLabel;

import com.towerdefense.model.enemy.AerialEnemy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Mo;
import com.towerdefense.model.enemy.TankEnemy;

//import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave implements ActionListener {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;
    private JLabel moneyPlayer;

    private int timeWave;
    private int countDown;
    private Timer timer = new Timer(1000, this);

    private boolean finChrono = false;
    private boolean WinGame = false;
    private boolean LoseGame = false;

    private int currentWave = 1;

    private final int nbWaves = 10;
    // private final ScheduledExecutorService scheduler =
    // Executors.newScheduledThreadPool(1);

    public Wave(Game game, int time) {
        chrono = new JLabel();
        cptWave = new JLabel();
        moneyPlayer = new JLabel();
        this.game = game;
        this.timeWave = time;
        this.countDown = time;
    }

<<<<<<< HEAD
    public JLabel getChrono() {
=======
    public JLabel getMoneyPlayer(){
        return moneyPlayer;
    }

    public JLabel getChrono(){
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
        return chrono;
    }

    public JLabel getCptWave() {
        return cptWave;
    }

    public Player getPlayer() {
        return game.getPlayer();
    }

<<<<<<< HEAD
    public void incrementWave() {
=======
    public boolean getWin(){
        return WinGame;
    }

    public boolean getLose(){
        return LoseGame;
    }

    public void incrementWave(){
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
        currentWave++;
    }

    public int getNbWaves() {
        return nbWaves;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public void setFinChrono(boolean finChrono) {
        this.finChrono = finChrono;
    }

<<<<<<< HEAD
    public void setFinishGame(boolean fin) {
        finishGame = fin;
=======
    public void setWinGame(boolean fin){
        WinGame = fin;
    }

    public void setLoseGame(boolean fin){
        LoseGame = fin;
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
    }

    public boolean getFinChrono() {
        return finChrono;
    }

    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        cptWave.setText("Wave " + currentWave + " /");
=======
        moneyPlayer.setText(game.getPlayer().getMoney()+" $");
        cptWave.setText("Wave "+currentWave+" /");
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
        chrono.setText(convertSecondToMinute(countDown));
        wave(currentWave, countDown);
        countDown--; // une seconde passe
        if (countDown < 0) {
            chrono.setText("Next Wave");
            /*
             * try {
             * Thread.sleep(500);
             * } catch (InterruptedException e) {
             * e.printStackTrace();
             * }
             */
            countDown = timeWave;
            finChrono = true;
            return;
        }
<<<<<<< HEAD
        if (currentWave > nbWaves || finishGame) {
=======
        if(currentWave > nbWaves || WinGame || LoseGame){
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
            timer.stop();
        }
    }

    public void pause() {
        timer.stop();
    }

    public String convertSecondToMinute(int second) {
        return second / 60 + ":" + second % 60 + " ";
    }

    public void play() {
        game.towerAction();
        game.enemyAction();
        game.projectileAction();
        game.getBoard().refresh();
    }

    public void createEnemy(int enemy, int healthSupp) { // Créer l'ennemi en fonction de son type (notée par un int)
        switch (enemy) {
            default:
                Enemy e = new BasicEnemy(game);
                e.setHealth(healthSupp);
                e.setPath();
                game.getBoard().addEnemy(e);
                break;
            case 1:
                Enemy e2 = new AerialEnemy(game);
                e2.setHealth(healthSupp);
                e2.setPath();
                game.getBoard().addEnemy(e2);
                break;
            case 2:
                Enemy e3 = new TankEnemy(game);
                e3.setHealth(healthSupp);
                e3.setPath();
                game.getBoard().addEnemy(e3);
                break;
            case 10:
                Enemy e10 = new Mo(game);
                e10.setPath();
                game.getBoard().addEnemy(e10);
                break;
        }
    }

<<<<<<< HEAD
    public void wave(int currentWave, int countdownStarter) {
        switch (currentWave) {
            case 1:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 0);
                    createEnemy(1, 0);
                }
                break;
            case 2:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 20);
                }
                break;
            case 3:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 40);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(1, 0);
=======
    public void wave(int currentWave, int countdownStarter){
        switch(currentWave){
            case 1 :
                if(countdownStarter%10 == 0){
                    createEnemy(0,0);
                }
                break;
            case 2 :
                if(countdownStarter%10 == 0){
                    createEnemy(0,20);
                }
                break;
            case 3 :
                if(countdownStarter%10 == 0){
                    createEnemy(0,40);
                }
                if(countdownStarter%10 == 0){
                    createEnemy(1,0);
>>>>>>> fe12436406590e6d3c7da733765272b8c7f306f3
                }
                break;
            case 4:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 40);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 0);
                }
                if (countdownStarter % 10 == 0) {
                    createEnemy(2, 0);
                }
                break;
            case 5:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 40);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 0);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(2, 0);
                }
                break;
            case 6:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 80);
                }
                if (countdownStarter % 4 == 0) {
                    createEnemy(1, 0);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(2, 80);
                }
                break;
            case 7:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 80);
                }
                if (countdownStarter % 4 == 0) {
                    createEnemy(1, 0);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(2, 80);
                }
                break;
            case 8:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 100);
                }
                if (countdownStarter % 4 == 0) {
                    createEnemy(1, 0);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(2, 100);
                }
                break;
            case 9:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 400);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 400);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(2, 400);
                }
                break;
            case 10:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 800);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(1, 800);
                }
                if (countdownStarter % 10 == 0) {
                    createEnemy(2, 800);
                }
                if (countdownStarter % 40 == 0) {
                    createEnemy(10, 0);
                }
                break;
        }
    }

}
