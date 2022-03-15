package com.towerdefense.model;

import java.util.concurrent.*;

import javax.swing.JLabel;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave {
    private Game game;
    private JLabel chrono;
    private int timeWave;
    private boolean finChrono = false;
    private int currentWave = 1;
    private final int nbWaves = 20;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Wave(Game game, int time){
        chrono = new JLabel();
        this.game = game;
        this.timeWave = time;
    }

    public JLabel getChrono(){
        return chrono;
    }

    public Player getPlayer(){
        return game.getPlayer();
    }

    public int getCurrentWave(){
        return currentWave;
    }

    public void incrementWave(){
        currentWave++;
    }

    public int getNbWaves(){
        return nbWaves;
    }

    public boolean getFinChrono(){
        return finChrono;
    }

    public void chrono(){
        final Runnable runnable = new Runnable() {
            int countdownStarter = timeWave;

            public void run() {

                chrono.setText(convertSecondToMinute(countdownStarter));
                // Ce qui se passe pendant que le minuteur tourne
                if(countdownStarter%2 == 0){ // toutes les 2 secondes un ennemi est crée 
                    createEnemy(0);
                }
                countdownStarter--; // une seconde passe

                if (countdownStarter < 0) {
                    chrono.setText("Next Wave");
                    //scheduler.shutdown();
                    countdownStarter = timeWave;
                    finChrono = true;
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
        }
    }

}
