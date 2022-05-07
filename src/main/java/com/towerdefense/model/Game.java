package com.towerdefense.model;

import com.towerdefense.level.Level;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.Tower;

public class Game {

    private Board board;
    private Player player;
    private Level level;

    public Game(int size, int nbCases, Player player, Level level) {
        this.board = new Board(size, nbCases, this);
        this.player = player;
        this.level = level;
    }

    public Level getLevel(){
        return level;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public void towerAction(){
        for (Tile[] tab : board.getBoard()) // Toutes les tours attaquent
            for (Tile t : tab)
                if (t.containsTower()) {
                    t.getTower().focus(board);
                    t.getTower().attack(board);
                    //System.out.println(t.getTower().getDamage());
                }
    }

    public void enemyAction(){
        for (Enemy e : board.getEnemies()) {    // Tous les ennemis se déplacent
            if(board.outOfBoard(e.getX() / board.getSize(), e.getY() / board.getSize())){// si l'ennemi arrive au point d arrivé on appelle enemy.crossedboard
                e.crossedBoard();
                board.addKillEnemy(e);
            } else {
                if (!e.isAlive()){
                    board.addKillEnemy(e);
                    player.setMoney(player.getMoney()+e.getGold());
                    player.increaseScore(e.getScore());
                }
            }
            e.move();
        }
    }

    public void projectileAction() {
        for (Tile[] tab : board.getBoard()) // Tous les projectiles se déplacent
            for (Tile t : tab)
                if (t.containsTower()) {
                    Tower tower = t.getTower();
                    for (Projectile p : tower.getProjectiles()) {
                        p.move();
                        if (p.hit())
                            tower.addKillProjectile(p);
                    }
                }
    }
    
}
