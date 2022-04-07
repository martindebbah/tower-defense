package com.towerdefense.model;

import javax.swing.JLabel;

import com.towerdefense.model.enemy.AerialEnemy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Mo;
import com.towerdefense.model.enemy.TankEnemy;

public class Wave implements ActionListener {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;
    private JLabel moneyPlayer;

    private int timeWave;
    private int countDown;
    private int delay = 0;

    private boolean finChrono = false;
    private boolean WinGame = false;
    private boolean LoseGame = false;

    private int currentWave = 1;

    private final int nbWaves = 10;

    public Wave(Game game, int time) {
        chrono = new JLabel();
        cptWave = new JLabel();
        moneyPlayer = new JLabel();
        this.game = game;
        this.timeWave = time;
        this.countDown = time;
    }

    public JLabel getMoneyPlayer() {
        return moneyPlayer;
    }

    public JLabel getChrono() {
        return chrono;
    }

    public JLabel getCptWave() {
        return cptWave;
    }

    public Player getPlayer() {
        return game.getPlayer();
    }

    public boolean getWin() {
        return WinGame;
    }

    public boolean getLose() {
        return LoseGame;
    }

    public void incrementWave() {
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

    public void setWinGame(boolean fin) {
        WinGame = fin;
    }

    public void setLoseGame(boolean fin) {
        LoseGame = fin;
    }

    public boolean getFinChrono() {
        return finChrono;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (delay != 0) {
            if (delay == 20)
                delay = 0;
            else
                delay++;
            return;
        }
        delay++;

        moneyPlayer.setText(game.getPlayer().getMoney() + " $");
        cptWave.setText("Wave " + currentWave + " /");
        chrono.setText(convertSecondToMinute(countDown));
        wave(currentWave, countDown);
        countDown--; // une seconde passe
        if (countDown < 0) {
            chrono.setText("Next Wave");
            countDown = timeWave;
            finChrono = true;
            return;
        }
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

    public void wave(int currentWave, int countdownStarter) {
        switch (currentWave) {
            case 1:
                if (countdownStarter % 5 == 0) {
                    createEnemy(0, 0);
                }
                break;
            case 2:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 0);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 0);
                }
                break;
            case 3:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 100);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(1, 50);
                }
                break;
            case 4:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 100);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 100);
                }
                if (countdownStarter % 10 == 0) {
                    createEnemy(2, 0);
                }
                break;
            case 5:
                if (countdownStarter % 3 == 0) {
                    createEnemy(0, 200);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 150);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(2, 100);
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
                    createEnemy(2, 250);
                }
                break;
            case 7:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 300);
                }
                if (countdownStarter % 4 == 0) {
                    createEnemy(1, 200);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(2, 400);
                }
                break;
            case 8:
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 300);
                }
                if (countdownStarter % 4 == 0) {
                    createEnemy(1, 200);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(2, 1000);
                }
                break;
            case 9:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 500);
                }
                if (countdownStarter % 6 == 0) {
                    createEnemy(1, 400);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(2, 1000);
                }
                break;
            case 10:
                if (countdownStarter % 4 == 0) {
                    createEnemy(0, 800);
                }
                if (countdownStarter % 8 == 0) {
                    createEnemy(1, 500);
                }
                if (countdownStarter % 10 == 0) {
                    createEnemy(2, 1500);
                }
                if (countdownStarter % 40 == 0) {
                    createEnemy(10, 0);
                }
                break;
        }
    }

}
