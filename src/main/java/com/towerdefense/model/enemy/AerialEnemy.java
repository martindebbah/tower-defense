package com.towerdefense.model.enemy;

import com.towerdefense.model.Game;

public class AerialEnemy extends Enemy {

    public AerialEnemy(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
    }

    @Override
    public int getGold() {
        return 20;
    }

    @Override
    public int getMovementSpeed() {
        return 2;
    }

    @Override
    public int getMaxHealth(){
        return 100;
    }

    @Override
    public String toString() {
        return "Ennemi aérien"; // Peut-être nom à changer ("Unité aérienne")
    }

    @Override
    public boolean isAerial(){
        return true;
    }

    @Override
    public void move(){
        this.moveRight();
    }
    
}
