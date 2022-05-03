package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

import com.towerdefense.level.Level;
import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.BasicTower;
import com.towerdefense.model.tower.Tower;

public class Board {

    private Tile[][] cases;
    private List<Enemy> enemies;
    private List<Enemy> killEnemies;
    private int size;
    private int nbCases;
    private List<Tower> towersToAdd;
    private boolean setPath = true;
    private Game game;

    public Board(int size, int nbCases, Game game) {
        this.enemies = new ArrayList<Enemy>();
        this.killEnemies = new ArrayList<Enemy>();
        this.towersToAdd = new ArrayList<Tower>();
        this.size = size;
        this.nbCases = nbCases;
        createBoard(nbCases, nbCases);
        this.game = game;
    }

    public void createBoard(int n, int m) {
        cases = new Tile[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cases[i][j] = new Tile(i, j,size);
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

    public Game getGame(){
        return game;
    }

    public void addKillEnemy(Enemy enemy) {
        enemy.stop();
        killEnemies.add(enemy);
    }

    public void kill() {
        enemies.removeAll(killEnemies);
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

    public List<Tile> getNeighborsOf(Tile current) { // Renvoie les tuiles voisines accessibles de current
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
            Si il y a une tour en haut et une tour à droite on empêche l'ennemi de passer entre les deux.
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

    public boolean containsEnemyOn(int x, int y) {  // Renvoie true si la case contient un ennemi
        for (Enemy e : enemies)
            if (e.getFirstTile(this) == cases[x][y])
                return true;
        return false;
    }

    public boolean canBuildOn(int x, int y) {   // Empêche de fermer la route.
        if (x == 0 && y == nbCases / 2)         // Les ennemis ont forcément au moins une possibilté
            return false;                       // d'arriver au bout du chemin.

        boolean r = true;
        cases[x][y].setTower(new BasicTower(0));
        if(game.getLevel() == Level.DIFFICULT){
            Enemy e = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 4);
            Enemy e2 = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() * 3 / 4);
            try {
                e.setPath();
                e2.setPath();
            }catch(IndexOutOfBoundsException ioe) {
                r = false;
            }
            removeTower(x, y);
            return r;
        }
        Enemy e = new BasicEnemy(game, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
        try {
            e.setPath();
        }catch(IndexOutOfBoundsException ioe) {
            r = false;
        }
        removeTower(x, y);
        return r;
    }

    public void removeTower(int x, int y) {
        cases[x][y].setTower(null);
    }

    public List<Enemy> getKillEnemies(){
        return killEnemies;
    }

}
