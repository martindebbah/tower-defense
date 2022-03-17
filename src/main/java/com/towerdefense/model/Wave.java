package com.towerdefense.model;

import java.util.concurrent.*;

import javax.swing.JLabel;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Mo;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;

    private int timeWave;

    private boolean finChrono = false;
    private boolean finishGame = false;

    private int currentWave = 1;

    private final int nbWaves = 10;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Wave(Game game, int time){
        chrono = new JLabel();
        cptWave = new JLabel();
        this.game = game;
        this.timeWave = time;
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

    public void chrono(){
        final Runnable runnable = new Runnable() {
            int countdownStarter = timeWave;

            public void run() {
                cptWave.setText("Wave "+currentWave+" /");
                chrono.setText(convertSecondToMinute(countdownStarter));
                wave(currentWave, countdownStarter);
                countdownStarter--; // une seconde passe

                if (countdownStarter < 0) {
                    chrono.setText("Next Wave");
                    /*try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    countdownStarter = timeWave;
                    finChrono = true;
                    return;
                }

                if(currentWave > nbWaves || finishGame){
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
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
