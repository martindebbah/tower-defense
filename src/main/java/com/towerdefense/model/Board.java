package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tower[][] cases;
    private List<Enemy> enemies;
    private int size;
    private int nbCases;

    public Board(int size, int nbCases) {
        this.enemies = new ArrayList<Enemy>();
        this.size = size;
        this.nbCases = nbCases;
        createBoard(nbCases, nbCases);
    }

    public void createBoard(int n, int m) {
        cases = new Tower[n][m];
    }

    public int getSize() {
        return size;
    }

    public int getNbCases() {
        return nbCases;
    }

    public void addTower(Tower t, int x, int y) {
        cases[x][y] = t;
        t.setCoord(x, y);
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    public Tower getTower(int x, int y) {
        return cases[x][y];
    }

    public Tower[][] getTowers() {
        return cases;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
