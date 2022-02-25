package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tile[][] cases;
    private List<Enemy> enemies;
    private List<Enemy> killEnemies;
    private int size;
    private int nbCases;
    private List<Tower> towersToAdd;
    private boolean setPath = true;

    public Board(int size, int nbCases, Game game) {
        this.enemies = new ArrayList<Enemy>();
        this.killEnemies = new ArrayList<Enemy>();
        this.towersToAdd = new ArrayList<Tower>();
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
        setPath = true;

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
        enemies.removeAll(killEnemies); // Ne pas oublier de faire les dégâts au joueur
        killEnemies.clear();

        for (Tile tab[] : cases)
            for (Tile t : tab)
                if (t.containsTower())
                    t.getTower().killProjectiles();
    }

    public void setPath() {
        if (setPath)
            for (Enemy e : enemies)
                e.setPath();
        setPath = false;
    }

    public void refresh() {
        addTowers();
        kill();
        setPath();
    }

    public List<Tile> neighbors(Tile current) { // Renvoie les tuiles voisines accessibles de current
        List<Tile> neighbors = new ArrayList<Tile>();

        int x = current.getX() / size;
        int y = current.getY() / size;

        add(current, x - 1, y - 1, neighbors);
        add(current, x, y - 1, neighbors);
        add(current, x + 1, y - 1, neighbors);
        add(current, x - 1, y, neighbors);
        add(current, x + 1, y, neighbors);
        add(current, x - 1, y + 1, neighbors);
        add(current, x, y + 1, neighbors);
        add(current, x + 1, y + 1, neighbors);

        return neighbors;
    }

    public void add(Tile current, int x, int y, List<Tile> list) {
        if (outOfBoard(x, y) || wall(current, x, y) || cases[x][y].containsTower())
            return;
        list.add(cases[x][y]);
    }

    public boolean wall(Tile current, int x, int y) {
        /*
            Cette fonction renvoie true si il y a des tours en diagonale
            Par exemple, on cherche à atteindre la case située en haut à droite à partir de la case current :
            Si il y a une tour en haut et une tour à droite o empêche l'ennemi de passer entre les deux.
        */
        if (current.getX() / size == x + 1 && current.getY() / size == y + 1)
            return cases[x][y+1].containsTower() && cases[x+1][y].containsTower();
        if (current.getX() / size == x - 1 && current.getY() / size == y + 1)
            return cases[x][y+1].containsTower() && cases[x-1][y].containsTower();
        if (current.getX() / size == x + 1 && current.getY() / size == y - 1)
            return cases[x][y-1].containsTower() && cases[x+1][y].containsTower();
        if (current.getX() / size == x - 1 && current.getY() / size == y - 1)
            return cases[x][y-1].containsTower() && cases[x-1][y].containsTower();
        return false;
    }

    // plateau 26x22 cases (tour = 2x2)
    // 13 tours par ligne
    // 11 tours par colonne
}
