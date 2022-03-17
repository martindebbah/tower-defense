package com.towerdefense.model.enemy;

import com.towerdefense.model.Game;

public class AerialEnemy extends Enemy {

    public AerialEnemy(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
    }

    @Override
    public int getGold() {
        return 80;
    }

    @Override
    public int getMaxHealth() {
        return 80;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi de base"; // Peut-être nom à changer
    }

    @Override
    public boolean isAerial(){
        return true;
    }
    
}
