package com.towerdefense.model;

import javax.swing.JLabel;

import com.towerdefense.level.Level;
import com.towerdefense.model.enemy.AerialEnemy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Boss;
import com.towerdefense.model.enemy.TankEnemy;

public class Wave implements ActionListener {
    private Game game;
    private JLabel chrono;
    private JLabel cptWave;
    private JLabel moneyPlayer;
    private JLabel enemiesLeft;
    private JLabel score;

    private int timeWave;
    private int countDown;
    private int scoreToAdd;
    private int delay = 0;
    private Level level;
    private int nbEnemies;

    private boolean finChrono = false;
    private boolean WinGame = false;
    private boolean LoseGame = false;
    private boolean mute = false;

    private int currentWave = 1;

    private int nbWaves;

    public Wave(Game game, Level level) {
        chrono = new JLabel();
        cptWave = new JLabel();
        moneyPlayer = new JLabel();
        enemiesLeft = new JLabel();
        score = new JLabel();
        this.game = game;
        this.level = level;
        if(level == Level.DIFFICULT){
            this.nbWaves = 15;
        }
        if(level == Level.EASY){
            this.nbWaves = 10;
        }
        if(level == Level.INFINY){
            this.nbWaves = 100;
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
                this.timeWave = 70;
                this.countDown = this.timeWave;
                break;
            case 2 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 30;
                } else {
                    nbEnemies += 15;
                }
                this.timeWave = 70;
                this.countDown = this.timeWave;
                break;
            case 3 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 40;
                } else {
                    nbEnemies += 20;
                }
                this.timeWave = 70;
                this.countDown = this.timeWave;
                break;
            case 4 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 50;
                } else {
                    nbEnemies += 25;
                }
                this.timeWave = 70;
                this.countDown = this.timeWave;
                break;
            case 5 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 60;
                } else {
                    nbEnemies += 30;
                }
                this.timeWave = 90;
                this.countDown = this.timeWave;
                break;
            case 6 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 70;
                } else {
                    nbEnemies += 35;
                }
                this.timeWave = 90;
                this.countDown = this.timeWave;
                break;
            case 7 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 80;
                } else {
                    nbEnemies += 40;
                }
                this.timeWave = 90;
                this.countDown = this.timeWave;
                break;
            case 8 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 90;
                } else {
                    nbEnemies += 45;
                }
                this.timeWave = 100;
                this.countDown = this.timeWave;
                break;
            case 9 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 100;
                } else {
                    nbEnemies += 50;
                }
                this.timeWave = 120;
                this.countDown = this.timeWave;
                break;
            case 10 :
                if(level == Level.DIFFICULT){
                    nbEnemies += 120;
                } else {
                    nbEnemies += 60;
                }
                this.timeWave = 120;
                this.countDown = this.timeWave;
                break;
            case 11 :
                if(level == Level.INFINY){
                    nbEnemies += 70;    
                } else {
                    if(level == Level.DIFFICULT) nbEnemies += 125;
                }
                this.timeWave = 150;
                this.countDown = this.timeWave;
                break;
            case 12 :
                if(level == Level.INFINY){
                    nbEnemies += 80;    
                } else {
                    if(level == Level.DIFFICULT) nbEnemies += 135;
                }
                this.timeWave = 150;
                this.countDown = this.timeWave;
                break;
            case 13 :
                if(level == Level.INFINY){
                    nbEnemies += 90;    
                } else {
                    if(level == Level.DIFFICULT) nbEnemies += 150;
                }
                this.timeWave = 170;
                this.countDown = this.timeWave;
                break;
            case 14 :
                if(level == Level.INFINY){
                    nbEnemies += 120;    
                } else {
                    if(level == Level.DIFFICULT) nbEnemies += 150;
                }
                this.timeWave = 180;
                this.countDown = this.timeWave;
                break;
            case 15 :
                if(level == Level.INFINY){
                    nbEnemies += 140;    
                } else {
                    if(level == Level.DIFFICULT) nbEnemies += 180;
                }
                this.timeWave = 190;
                this.countDown = this.timeWave;
                break;
            default :
                nbEnemies += (level == Level.INFINY)?currentWave*10:0;
                this.timeWave = 200;
                this.countDown = this.timeWave;
                break;
        }
        scoreToAdd = countDown;
    }

    public JLabel getMoneyPlayer() {
        return moneyPlayer;
    }

    public JLabel getScore() {
        return score;
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

    public void setCountDown(int c){
        countDown = c;
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

    public boolean getMute(){
        return mute;
    }

    public void setMute(boolean b){
        mute = b;
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

        moneyPlayer.setText("Argent : "+game.getPlayer().getMoney() + "$");
        score.setText("Score : " + game.getPlayer().getScore());
        if(currentWave <= nbWaves){
            cptWave.setText("Vague " + currentWave);
        } else {
            cptWave.setText("Vague " + nbWaves);
        }
        chrono.setText(convertSecondToMinute(countDown));
        if(nbEnemies < 0){
            enemiesLeft.setText("Ennemis restants : 0");
        } else {
            enemiesLeft.setText("Ennemis restants : "+nbEnemies);
        }
        wave(currentWave, countDown);
        //waveTest(countDown);
        countDown--; // une seconde passe
        scoreToAdd--;
        if (countDown < 0) {
            chrono.setText("Next Wave");
            countDown = timeWave;
            finChrono = true;
            game.getPlayer().setMoney(game.getPlayer().getMoney()+currentWave*10);
            if (scoreToAdd > 0)
                game.getPlayer().increaseScore(scoreToAdd); // Le joueur gagne le nombre de secondes restantes en points
            return;
        }
    }

    public String convertSecondToMinute(int second) {
        String sec = "" + second % 60;
        return second / 60 + ":" + (sec.length() == 1 ? "0" + sec : sec);
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
                    if(!mute)e.sound();
                    Enemy e1 = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() * 3 / 4);
                    e1.setHealth(healthSupp);
                    e1.setPath();
                    game.getBoard().addEnemy(e1);
                    nbEnemies -= 2;
                    if(!mute)e1.sound();
                } else {
                    Enemy e = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
                    e.setHealth(healthSupp);
                    e.setPath();
                    game.getBoard().addEnemy(e);
                    nbEnemies--;
                    if(!mute)e.sound();
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
                    Enemy e10 = new Boss(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
                    e10.setPath();
                    game.getBoard().addEnemy(e10);
                    nbEnemies--;
                    break;
                }
                Enemy e10 = new Boss(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
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
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 8 == 0) {
                        createEnemy(0, 0);
                    }
                } else {
                    if (countdownStarter % 6 == 0) {
                        createEnemy(0, 0);
                    }
                }
                //System.out.println(game.getBoard());
                break;
            case 2:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 6 == 0) {
                        createEnemy(0, 20);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(1, 0);
                    }
                } else {
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 20);
                    }
                    if (countdownStarter % 7 == 0) {
                        createEnemy(1, 0);
                    }
                }
                break;
            case 3:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 50);
                    }
                    if (countdownStarter % 10 == 0) {
                        createEnemy(1, 20);
                    }
                } else {
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 50);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(1, 20);
                    }
                }
                break;
            case 4:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 5 == 0) {
                        createEnemy(0, 150);
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
                        createEnemy(1, 100);
                    }
                    if (countdownStarter % 10 == 0) {
                        createEnemy(2, 0);
                    }
                }
                break;
            case 5:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 150);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 300);
                    }
                } else {
                    if (countdownStarter % 3 == 0) {
                        createEnemy(0, 300);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 150);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 300);
                    }
                }
                break;
            case 6:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 400);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 250);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 500);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 400);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 250);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 500);
                    }
                }
                break;
            case 7:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1000);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1000);
                    }
                }
                break;
            case 8:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 600);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1500);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 600);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1500);
                    }
                }
                break;
            case 9:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 4 == 0) {
                        createEnemy(0, 2000);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(1, 1000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 2000);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 2000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 1000);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 2000);
                    }
                }
                break;
            case 10:
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 2000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 1500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 2000);
                    }
                    if (countdownStarter % 100 == 0) {
                        createEnemy(10, 0);
                    }
                } else {
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 2000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 1500);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 2000);
                    }
                    if (countdownStarter % 100 == 0) {
                        createEnemy(10, 0);
                    }
                }
                break;
            case 11 :
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 2500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 2000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 2500);
                    }
                }
                break;
            case 12 :
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 2500);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 2000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 2500);
                    }
                }
                break;
            case 13 :
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 5000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 3000);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 5000);
                    }
                }
                break;
            case 14 :
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 8000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 3000);
                    }
                    if (countdownStarter % 8 == 0) {
                        createEnemy(2, 8000);
                    }
                }
                break;
            case 15 :
                if(level == Level.DIFFICULT || level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 10000);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 5000);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 10000);
                    }
                    if (countdownStarter % 120 == 0) {
                        createEnemy(10, 20000);
                    }
                }
                break;
            default :
                if(level == Level.INFINY){
                    if (countdownStarter % 2 == 0) {
                        createEnemy(0, 1000*currentWave);
                    }
                    if (countdownStarter % 4 == 0) {
                        createEnemy(1, 800*currentWave);
                    }
                    if (countdownStarter % 6 == 0) {
                        createEnemy(2, 1500*currentWave);
                    }
                    if (countdownStarter % 120 == 0 && currentWave%10 == 0) {
                        createEnemy(10, 2000*currentWave);
                    }
                }
                break;
        }
    }

    public void waveTest(int countdownStarter){
        switch(currentWave){
            case 1 :
                if (countdownStarter % 2 == 0) {
                    createEnemy(0, 0);
                }
                break;
        }
    }

}
