package com.towerdefense.model;

public class Board {

    private Units[][] cases;

    public Board() {
        createBoard(13, 11);
    }

    public void createBoard(int n, int m) {
        cases = new Units[n][m];
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
