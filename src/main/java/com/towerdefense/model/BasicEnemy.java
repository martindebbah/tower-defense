package com.towerdefense.model;

public class BasicEnemy extends Enemy { // Peut-être en faire une classe interne

    public BasicEnemy(Game game) { // Changer la façon dont l'attribut size (la taille d'une case) est entrée en paramêtre
        super(100, game, 0, game.getBoard().getSize()*10);
    }

    @Override
    public int getGold() {
        return 50;
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
