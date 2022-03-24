package com.towerdefense.model.enemy;

import com.towerdefense.model.Game;

public class TankEnemy extends Enemy{

    public TankEnemy(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
    }

    @Override
    public int getGold() {
        return 100;
    }

    @Override
    public int getMaxHealth(){
        return 500;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Ennemi tank"; // Peut-être nom à changer ("Tank")
    }

    @Override
    public boolean isAerial(){
        return false;
    }
    
}
