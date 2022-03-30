package com.towerdefense.model.enemy;

import com.towerdefense.model.Game;

public class BasicEnemy extends Enemy {

    public BasicEnemy(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2, 150, 150);
    }

    @Override
    public int getGold() {
        return 15;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi de base"; // Peut-être nom à changer
    }
    
}
