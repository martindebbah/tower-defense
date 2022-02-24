package com.towerdefense.model;

import java.util.concurrent.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave {
    private int enemyPerWaves;
    private JLabel chrono;
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Wave(){
        chrono = new JLabel();
    }

    public JLabel getChrono(){
        return chrono;
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
