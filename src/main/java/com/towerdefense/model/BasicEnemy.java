package com.towerdefense.model;

public class BasicEnemy extends Enemy {

    public BasicEnemy(Game game) { // Changer la façon dont l'attribut size (la taille d'une case) est entrée en paramêtre
        super(100, 1, 50, game, 0, game.getBoard().getSize()*10);
    }
    
}
