package com.towerdefense.model;

import java.util.List;

public class Tower {

    private int range;
    private int damage;
    private int attackSpeed;
    private int price;
    private Ennemy target;
    private int[] coord;
    private boolean newTarget;

    public Tower(int range, int damage, int attackSpeed) {
        this.range = range;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public void setCoord(int x, int y) {
        coord = new int[2];
        coord[0] = x;
        coord[1] = y;
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

    public void attack() {
        new Thread() {
            public void run() {
                while (canAttack()) {
                    target.getHit(damage);
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
            if (!isInRange(target.getCoord())) // Si l'unité sort de la range
                target = null;
            return; // On ne change pas de cible
        }
        List<Ennemy> ennemies = board.getEnnemies();
        for (Ennemy e : ennemies) {
            if (isInRange(e.getCoord())) {
                target = e;
                newTarget = true;
                return;
            }else {
                target = null;
            }
        }
    }

    public boolean isInRange(int[] coordE) {
        return Math.max(coordE[0] / 32, coord[0]) - Math.min(coordE[0] / 32, coord[0]) <= range 
            && Math.max(coordE[1] / 32, coord[1]) - Math.min(coordE[1] / 32, coord[1]) <= range;
    }
    
}
