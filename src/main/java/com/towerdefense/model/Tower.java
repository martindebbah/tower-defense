package com.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

public class Tower {

    private Enemy target;
    private int[] coord;
    private boolean newTarget;
    private List<Projectile> projectiles;
    private List<Projectile> killProjectiles;

    public Tower() {
        this.projectiles = new ArrayList<Projectile>();
        this.killProjectiles = new ArrayList<Projectile>();
    }

    public Tower newTower() {
        return null;
    }

    public String toString() {  // Fonction définie dans chaque classe héritant de Tower
        return "";
    }

    public void setCoord(int x, int y) {
        coord = new int[2];
        coord[0] = x;
        coord[1] = y;
    }

    public int[] getCoord() {
        return coord;
    }

    public int getRange() {
        return 0;
    }

    public int getPrice() { // Dans chaque classe
        return 0;
    }

    public int getAttackSpeed() {   // Dans chaque classe
        return 0;
    }

    public boolean isNewTarget() {
        return newTarget;
    }

    public Tower getSource() {
        return this;
    }

    public int getDamage() {    // Dans chaque classe
        return 0;
    }

    public void attack(Board board) {
        new Thread() {
            public void run() {
                while (canAttack()) {
                    addProjectile(new Projectile(getSource(), target));
                    try{
                        sleep(getAttackSpeed() * 1000);
                    }catch(InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void addProjectile(Projectile p) {
        projectiles.add(p);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public boolean canAttack() {
        return target != null;
    }

    public boolean canFocus(Enemy e) {
        return false;
    }

    public void focus(Board board) {
        if (target != null) {
            newTarget = false;
            if (!isInRange(target.getCoord(), board.getSize()) || !target.isAlive()) // Si l'unité sort de la range ou meurt
                target = null;
            return; // On ne change pas de cible
        }
        List<Enemy> enemies = board.getEnemies();
        for (Enemy e : enemies) { // Comment choisir le plus proche de la sortie
            if (isInRange(e.getCoord(), board.getSize()) && canFocus(e)) {
                target = e;
                newTarget = true;
                return;
            }else {
                target = null;
            }
        }
    }

    public boolean isInRange(int[] coordE, int size) { // La range est un peu décalée sur le coin haut-gauche de l'unité
        return (coordE[0] / size - coord[0]) * (coordE[0] / size - coord[0]) + (coordE[1] / size - coord[1]) * (coordE[1] / size - coord[1])
                <= getRange() * getRange();
    }

    public void addKillProjectile(Projectile p) {
        killProjectiles.add(p);
    }

    public void killProjectiles() {
        projectiles.removeAll(killProjectiles);
        killProjectiles.clear();
    }

    public Color getColor() {   // Première méthode pour afficher une tour
        return null;
    }
    
}
