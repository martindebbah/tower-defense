package com.towerdefense.model;

import java.util.concurrent.*;

import javax.swing.JLabel;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave {
    private int enemyPerWaves;
    private Player player;
    private JLabel chrono;
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Wave(Player player){
        chrono = new JLabel();
        this.player = player;
    }

    public JLabel getChrono(){
        return chrono;
    }

    public Player getPlayer(){
        return player;
    }

    public void chrono(){
        final Runnable runnable = new Runnable() {
            int countdownStarter = 20;

            public void run() {

                chrono.setText(countdownStarter+" ");
                // Ce qui se passe pendant que le minuteur tourne
                countdownStarter--;

                if (countdownStarter < 0) {
                    chrono.setText("Timer Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
    
}
