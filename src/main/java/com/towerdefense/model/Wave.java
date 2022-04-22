package com.towerdefense.model;

import javax.swing.JLabel;

import com.towerdefense.level.Level;
import com.towerdefense.model.enemy.AerialEnemy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Mo;
import com.towerdefense.model.enemy.TankEnemy;

public class Wave implements ActionListener {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;
    private JLabel moneyPlayer;
    private JLabel enemiesLeft;

    private int timeWave;
    private int countDown;
    private int delay = 0;
    private Level level;
    private int nbEnemies;

    private boolean finChrono = false;
    private boolean WinGame = false;
    private boolean LoseGame = false;

    private int currentWave = 1;

    private int nbWaves;

    public Wave(Game game, int time, Level level) {
        chrono = new JLabel();
        cptWave = new JLabel();
        moneyPlayer = new JLabel();
        enemiesLeft = new JLabel();
        this.game = game;
        this.timeWave = time;
        this.countDown = time;
        this.level = level;
        if(level == Level.DIFFICULT){
            this.nbWaves = 15;
        } else {
            this.nbWaves = 10;
        }
        initializeWave();
    }

    public int getNbEnemies(){
        return nbEnemies;
    }

    public void initializeWave(){
        switch(currentWave){
            case 1 :
                if(level == Level.DIFFICULT){
                    nbEnemies = 20;
                } else {
                    nbEnemies = 10;
                }
                break;
            case 2 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 30;
                } else {
                    nbEnemies += 15;
                }
                break;
            case 3 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 40;
                } else {
                    nbEnemies += 20;
                }
                break;
            case 4 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 50;
                } else {
                    nbEnemies += 25;
                }
                break;
            case 5 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 60;
                } else {
                    nbEnemies += 30;
                }
                break;
            case 6 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 70;
                } else {
                    nbEnemies += 35;
                }
                break;
            case 7 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 80;
                } else {
                    nbEnemies += 40;
                }
                break;
            case 8 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 90;
                } else {
                    nbEnemies += 45;
                }
                break;
            case 9 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 100;
                } else {
                    nbEnemies += 50;
                }
                break;
            case 10 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 120;
                } else {
                    nbEnemies += 60;
                }
                break;
            case 11 :
                nbEnemies += (level == Level.DIFFICULT)?125:0;
                break;
            case 12 :
                nbEnemies += (level == Level.DIFFICULT)?135:0;
                break;
            case 13 :
                nbEnemies += (level == Level.DIFFICULT)?150:0;
                break;
            case 14 :
                nbEnemies += (level == Level.DIFFICULT)?150:0;
                break;
            case 15 :
                nbEnemies += (level == Level.DIFFICULT)?180:0;
                break;
        }
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

    public JLabel getEnemiesLeft(){
        return enemiesLeft;
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

        moneyPlayer.setText("money : "+game.getPlayer().getMoney() + " $ /");
        if(currentWave <= nbWaves){
            cptWave.setText("Wave " + currentWave + " /");
        } else {
            cptWave.setText("Wave " + nbWaves + " /");
        }
        chrono.setText(convertSecondToMinute(countDown));
        if(nbEnemies < 0){
            enemiesLeft.setText("ennemies restants : 0 /");
        } else {
            enemiesLeft.setText("ennemies restants : "+nbEnemies+" /");
        }
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
                if(level == Level.DIFFICULT){
                    Enemy e = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
                    e.setHealth(healthSupp);
                    e.setPath();
                    game.getBoard().addEnemy(e);
                    Enemy e1 = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() * 3 / 4);
                    e1.setHealth(healthSupp);
                    e1.setPath();
                    game.getBoard().addEnemy(e1);
                    nbEnemies -= 2;
                } else {
                    Enemy e = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
                    e.setHealth(healthSupp);
                    e.setPath();
                    game.getBoard().addEnemy(e);
                    nbEnemies--;
                }
                break;
            case 1:
                if(level == Level.DIFFICULT){
                    Enemy e2 = new AerialEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
                    e2.setHealth(healthSupp);
                    e2.setPath();
                    game.getBoard().addEnemy(e2);
                    Enemy e3 = new AerialEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() * 3 / 4);
                    e3.setHealth(healthSupp);
                    e3.setPath();
                    game.getBoard().addEnemy(e3);
                    nbEnemies -= 2;
                } else {
                    Enemy e2 = new AerialEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
                    e2.setHealth(healthSupp);
                    e2.setPath();
                    game.getBoard().addEnemy(e2);
                    nbEnemies--;
                }
                break;
            case 2:
                if(level == Level.DIFFICULT){
                    Enemy e3 = new TankEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
                    e3.setHealth(healthSupp);
                    e3.setPath();
                    game.getBoard().addEnemy(e3);
                    Enemy e4 = new TankEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() * 3 / 4);
                    e4.setHealth(healthSupp);
                    e4.setPath();
                    game.getBoard().addEnemy(e4);
                    nbEnemies -= 2;
                } else {
                    Enemy e3 = new TankEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
                    e3.setHealth(healthSupp);
                    e3.setPath();
                    game.getBoard().addEnemy(e3);
                    nbEnemies--;
                }
                break;
            case 10:
                if(level == Level.DIFFICULT){
                    Enemy e10 = new Mo(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
                    e10.setPath();
                    game.getBoard().addEnemy(e10);
                    nbEnemies--;
                    break;
                }
                Enemy e10 = new Mo(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
                e10.setPath();
                game.getBoard().addEnemy(e10);
                nbEnemies--;
                break;
        }
    }

    public void wave(int currentWave, int countdownStarter) {
        if(nbEnemies <= 0){
            return;
        }
        switch (currentWave) {
            case 1:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 8 == 0) {
                        createEnemy(0, 0);
                    }
                } else {
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 0);
                    }
                }
                break;
            case 2:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 6 == 0) {
                        createEnemy(0, 0);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(1, 0);
                    }
                } else {
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 0);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 0);
                    }
                }
                break;
            case 3:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 50);
                    }
                    if (countdownStarter % 10 == 0) {
                        createEnemy(1, 50);
                    }
                } else {
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 50);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(1, 50);
                    }
                }
                break;
            case 4:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 100);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(1, 100);
                    }
                    if (countdownStarter % 10 == 0) {
                        createEnemy(2, 0);
                    }
                } else {
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 150);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 150);
                    }
                    if (countdownStarter % 10 == 0) {
                        createEnemy(2, 0);
                    }
                }
                break;
            case 5:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 150);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 100);
                    }
                } else {
                    if (countdownStarter % 3 == 0) {
                        createEnemy(0, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 150);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 100);
                    }
                }
                break;
            case 6:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 250);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 250);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 250);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 100);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 250);
                    }
                }
                break;
            case 7:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 400);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 400);
                    }
                }
                break;
            case 8:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1000);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1000);
                    }
                }
                break;
            case 9:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 400);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 1000);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 400);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1000);
                    }
                }
                break;
            case 10:
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 800);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1500);
                    }
                    if (countdownStarter % 60 == 0) {
                        createEnemy(10, 0);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 800);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1500);
                    }
                    if (countdownStarter % 60 == 0) {
                        createEnemy(10, 0);
                    }
                }
                break;
            case 11 :
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 800);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 2500);
                    }
                } else {
                    currentWave = 10;
                    wave(currentWave, countdownStarter);
                }
                break;
            case 12 :
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 1000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 5000);
                    }
                }
                break;
            case 13 :
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 1200);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 5000);
                    }
                }
                break;
            case 14 :
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 3000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 5000);
                    }
                }
                break;
            case 15 :
                if(level == Level.DIFFICULT){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 2000);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 8000);
                    }
                    if (countdownStarter % 60 == 0) {
                        createEnemy(10, 10000);
                    }
                }
                break;
        }
    }

}
