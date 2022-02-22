package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tile[][] cases;
    private List<Enemy> enemies;
    private List<Enemy> killEnemies;
    private List<Enemy> toSet;
    private int size;
    private int nbCases;
    private List<Tower> towersToAdd;

    public Board(int size, int nbCases, Game game) {
        this.enemies = new ArrayList<Enemy>();
        this.killEnemies = new ArrayList<Enemy>();
        this.towersToAdd = new ArrayList<Tower>();
        this.toSet = new ArrayList<Enemy>();
        this.size = size;
        this.nbCases = nbCases;
        createBoard(nbCases, nbCases);
    }

    public void createBoard(int n, int m) {
        cases = new Tile[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cases[i][j] = new Tile(i, j);
            }
        }
    }

    public boolean outOfBoard(int x, int y){
        if(x < 0 || x >= cases.length || y < 0 || y >= cases.length){
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getNbCases() {
        return nbCases;
    }

    public void addTower(Tower t, int x, int y) {
        new Thread() {  // new Thread to avoid java heap space
            @Override
            public void run() {
                System.out.println(enemies.size());
                for (Enemy e : enemies)
                    e.setPath();
            }
        }.start();

        t.setCoord(x, y);
        towersToAdd.add(t);
        
    }

    public void addTowers() {
        for (Tower t : towersToAdd)
            cases[t.getCoord()[0]][t.getCoord()[1]].setTower(t);
        towersToAdd.clear();
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    public void killEnemy(Enemy e) {
        enemies.remove(e);
    }

    public Tile[][] getBoard() {
        return cases;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addKillEnemy(Enemy enemy) {
        killEnemies.add(enemy);
    }

    public void kill() {
        enemies.removeAll(killEnemies);
        killEnemies.clear();
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
