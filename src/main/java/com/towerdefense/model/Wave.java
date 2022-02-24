package com.towerdefense.model;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wave {
    private int enemyPerWaves;
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void chrono(){
        final Runnable runnable = new Runnable() {
            int countdownStarter = 20;

            public void run() {

                System.out.println(countdownStarter);
                // Ce qui se passe pendant que le minuteur tourne
                countdownStarter--;

                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
    
}
