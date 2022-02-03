package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tower[][] cases;
    private List<Enemy> ennemies;

    public Board() {
        createBoard(20, 20);
        this.ennemies = new ArrayList<Enemy>();
    }

    public void createBoard(int n, int m) {
        cases = new Tower[n][m];
    }

    public void addTower(Tower t, int x, int y) {
        cases[x][y] = t;
        t.setCoord(x, y);
    }

    public void addEnnemy(Enemy e) {
        ennemies.add(e);
    }

    public Tower getTower(int x, int y) {
        return cases[x][y];
    }

    public List<Enemy> getEnnemies() {
        return ennemies;
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
