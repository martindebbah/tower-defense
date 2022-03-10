package com.towerdefense.model;

public class Mo extends Enemy {

    public Mo(Game game) {
        super(game, 0, game.getBoard().getSize() * game.getBoard().getNbCases() / 2);
    }

    @Override
    public int getGold() {
        return 1000;
    }

    @Override
    public int getMaxHealth() {
        return 1000;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public String toString() {
        return "Boss de donjon"; // Peut-être nom à changer
    }
    
}
