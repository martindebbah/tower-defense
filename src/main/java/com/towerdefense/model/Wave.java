package com.towerdefense.model;

//import java.util.concurrent.*;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Mo;

//import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave implements ActionListener {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;

    private int timeWave;
    private int countDown;
    private Timer timer = new Timer(1000, this);

    private boolean finChrono = false;
    private boolean finishGame = false;

    private int currentWave = 1;

    private final int nbWaves = 10;
    //private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Wave(Game game, int time){
        chrono = new JLabel();
        cptWave = new JLabel();
        this.game = game;
        this.timeWave = time;
        this.countDown = time;
    }

    public JLabel getChrono(){
        return chrono;
    }

    public JLabel getCptWave(){
        return cptWave;
    }

    public Player getPlayer(){
        return game.getPlayer();
    }

    public void incrementWave(){
        currentWave++;
    }

    public int getNbWaves(){
        return nbWaves;
    }

    public int getCurrentWave(){
        return currentWave;
    }

    public void setFinChrono(boolean finChrono){
        this.finChrono = finChrono;
    }

    public void setFinishGame(boolean fin){
        finishGame = fin;
    }

    public boolean getFinChrono(){
        return finChrono;
    }

    public void start(){
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cptWave.setText("Wave "+currentWave+" /");
        chrono.setText(convertSecondToMinute(countDown));
        wave(currentWave, countDown);
        countDown--; // une seconde passe
        if (countDown < 0) {
            chrono.setText("Next Wave");
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            countDown = timeWave;
            finChrono = true;
            return;
        }
        if(currentWave > nbWaves || finishGame){
            timer.stop();
        }
    }

    public void pause() {
        timer.stop();
    }

    public String convertSecondToMinute(int second){
        return second/60+":"+second%60+" ";
    }
    
    public void play(){
        game.towerAction();
        game.enemyAction();
        game.projectileAction();
        game.getBoard().refresh();
    }

    public void createEnemy(int enemy){ // Créer l'ennemi en fonction de son type (notée par un int)
        switch(enemy){
            default :
                Enemy e = new BasicEnemy(game);
                e.setPath();
                game.getBoard().addEnemy(e);
                break;
            case 10 :
                Enemy e10 = new Mo(game);
                e10.setPath();
                game.getBoard().addEnemy(e10);
                break;
        }
    }

    public void wave(int currentWave, int countdownStarter){
        switch(currentWave){
            case 1 :
                if(countdownStarter%20 == 0){
                    createEnemy(0);
                }
                break;
            case 2 :
                if(countdownStarter%20 == 0){
                    createEnemy(0);
                }
                break;
            case 3 :
                if(countdownStarter%15 == 0){
                    createEnemy(0);
                }
                break;
            case 4 :
                if(countdownStarter%15 == 0){
                    createEnemy(0);
                }
                break;
            case 5 :
                if(countdownStarter%10 == 0){
                    createEnemy(0);
                }
                break;
            case 6 :
                if(countdownStarter%10 == 0){
                    createEnemy(0);
                }
                break;
            case 7 :
                if(countdownStarter%5 == 0){
                    createEnemy(0);
                }
                break;
            case 8 :
                if(countdownStarter%4 == 0){
                    createEnemy(0);
                }
                break;
            case 9 :
                if(countdownStarter%3 == 0){
                    createEnemy(0);
                }
                break;
            case 10 :
                if(countdownStarter%2 == 0){
                    createEnemy(0);
                }
                if(countdownStarter%40 == 0){
                    createEnemy(10);
                }
                break;
        }
    }

}
