package com.towerdefense.model;

public class BasicEnemy extends Enemy {

    public BasicEnemy(int size) { // Changer la façon dont l'attribut size (la taille d'une case) est entrée en paramêtre
        super(100, 1, 50, 0, 10 * size - size / 2);
    }
    
}
