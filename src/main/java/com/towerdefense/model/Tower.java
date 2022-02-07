package com.towerdefense.model;

import java.util.List;

public class Tower {

    private int range;
    private int damage;
    private int attackSpeed;
    private int price;
    private Enemy target;
    private int[] coord;
    private boolean newTarget;

    public Tower(int range, int damage, int attackSpeed, int price) {
        this.range = range;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public void setCoord(int x, int y) {
        coord = new int[2];
        coord[0] = x;
        coord[1] = y;
    }

    public int[] getCoord() {
        return coord;
    }

    public int getPrice() {
        return price;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public boolean isNewTarget() {
        return newTarget;
    }

    public Tower getSource() {
        return this;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Board board) {
        new Thread() {
            public void run() {
                while (canAttack()) {
                    board.addProjectile(new Projectile(getSource(), target));
                    try{
                        sleep(attackSpeed * 1000);
                    }catch(InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public boolean canAttack() {
        return target != null;
    }

    public void focus(Board board) {
        if (target != null) {
            newTarget = false;
            if (!isInRange(target.getCoord(), board.getSize()) || !target.isAlive()) // Si l'unité sort de la range ou meurt
                target = null;
            return; // On ne change pas de cible
        }
        List<Enemy> enemies = board.getEnemies();
        for (Enemy e : enemies) {
            if (isInRange(e.getCoord(), board.getSize())) {
                target = e;
                newTarget = true;
                return;
            }else {
                target = null;
            }
        }
    }

    public boolean isInRange(int[] coordE, int size) { // La range est un peu décalée sur le coin haut-gauche de l'unité
        return (coordE[0] / size - coord[0]) * (coordE[0] / size - coord[0]) + ((size*coordE[1]-size/2) / size - coord[1]) * ((size*coordE[1]-size/2) / size - coord[1])
                <= range * range;
    }
    
}
