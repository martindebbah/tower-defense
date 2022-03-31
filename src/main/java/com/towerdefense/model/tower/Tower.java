package com.towerdefense.model.tower;

import java.util.ArrayList;
import java.util.List;

import com.towerdefense.model.Board;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.enemy.Enemy;

import java.awt.Color;

public class Tower {

    protected Enemy target;
    private int[] coord;
    protected boolean newTarget;
    private List<Projectile> projectiles;
    private List<Projectile> killProjectiles;
    protected int coolDown = 0;
    protected int initialDamage;

    public Tower(int damage) {
        this.projectiles = new ArrayList<Projectile>();
        this.killProjectiles = new ArrayList<Projectile>();
        this.initialDamage = damage;
    }

    public void setDamage(int damage){
        this.initialDamage *= damage;
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
        return 0;   // La fonction retourne n tel que la tour attaque toutes les n * 50 millisecondes
    }

    public boolean isNewTarget() {
        return newTarget;
    }

    public Tower getSource() {
        return this;
    }

    public int getDamage() {    // Dans chaque classe
        return initialDamage;
    }

    public void attack(Board board) {
        if (!canAttack())
            return;

        if (coolDown == 0) {
            addProjectile(new Projectile(getSource(), target));
        }
        if (coolDown <= getAttackSpeed()) {  // tire toutes les 20 * 50 millisecondes
            coolDown++;
        }else {
            coolDown = 0;
        }
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

    public boolean canFocusAerial(Enemy e) {
        return !e.isAerial();   // true sie e n'est pas un ennemi aérien
    }   // est overriden dans AerialTower

    public void focus(Board board) {
        if (target != null) {
            newTarget = false;
            if (!isInRange(target.getCoord(), board.getSize()) || !target.isAlive()) // Si l'unité sort de la range ou meurt
                target = null;
                
            return; // On ne change pas de cible
        }
        List<Enemy> enemies = board.getEnemies();
        for (Enemy e : enemies) {
            if (isInRange(e.getCoord(), board.getSize()) && canFocusAerial(e)) {
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

    public Color getPreviewColor() {
        return null;
    }
    
}
