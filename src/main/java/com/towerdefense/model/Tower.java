package com.towerdefense.model;

public class Tower extends Units {

    private int range;
    private int damage;
    private int attackSpeed;
    private int price;
    private Ennemy target;

    public Tower(int range, int damage, int attackSpeed) {
        this.range = range;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void attack() {
        // Savoir si l'ennemi est en range
        // Attention a l'attack-speed
        if (target == null) return; // n'attaque personne
        target.getHit(damage);
    }
    
}
