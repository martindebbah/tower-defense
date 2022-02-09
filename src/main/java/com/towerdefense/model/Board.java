package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tile[][] cases;
    private List<Enemy> enemies;
    private List<Enemy> killEnemies;
    private List<Projectile> projectiles;
    private List<Projectile> killProjectiles;
    private int size;
    private int nbCases;

    public Board(int size, int nbCases, Game game) {
        this.enemies = new ArrayList<Enemy>();
        this.killEnemies = new ArrayList<Enemy>();
        this.projectiles = new ArrayList<Projectile>();
        this.killProjectiles = new ArrayList<Projectile>();
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
        cases[x][y].setTower(t);
        t.setCoord(x, y);
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
    }

    public void killEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public Tile[][] getBoard() {
        return cases;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void addKillProjectile(Projectile projectile) {
        killProjectiles.add(projectile);
    }

    public void addKillEnemy(Enemy enemy) {
        killEnemies.add(enemy);
    }

    public void kill() {
        enemies.removeAll(killEnemies);
        projectiles.removeAll(killProjectiles);
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
