package com.towerdefense.model;

public class Game {

    private Board board;
    private Player player;

    public Game(int size, int nbCases) {
        this.board = new Board(size, nbCases, this);
    }

    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public void play() {
        for (Tile[] tab : board.getBoard()) // Toutes les tours attaquent
            for (Tile t : tab)
                if (t.containsTower()) {
                    t.getTower().focus(board);
                    if (t.getTower().canAttack() && t.getTower().isNewTarget())
                        t.getTower().attack(board);
                }

        for (Enemy e : board.getEnemies()) {    // Tous les ennemis se déplacent
            if (!e.isAlive() || board.outOfBoard(e.getX() / board.getSize(), e.getY() / board.getSize()))
                board.addKillEnemy(e);
            e.move();
        }

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

        board.refresh();    // On met le board à jour (kill les ennemis/projectiles et refresh les chemins ennemis)
    }
    
}
