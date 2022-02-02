package com.towerdefense.model;

public class Board {

    private Tower[][] cases;

    public Board() {
        createBoard(20, 20);
    }

    public void createBoard(int n, int m) {
        cases = new Tower[n][m];
    }

    public void addTower(Tower t, int x, int y) {
        cases[x][y] = t;
    }

    public Tower getTower(int x, int y) {
        return cases[x][y];
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
