package com.towerdefense.model.tower;

import java.awt.Color;
import java.util.List;

import com.towerdefense.model.Board;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.enemy.Enemy;

public class InfernalTower extends Tower {
    
    protected int damage;

    public InfernalTower(int damage) {
        super(damage);
        this.damage = damage;
    }

    public void reset(){
        super.initialDamage = damage;
    }

    @Override
    public Tower newTower() {
        return new InfernalTower(5);
    }

    @Override
    public String toString() {
        return "Tour de l'enfer";
    }

    @Override
    public int getAttackSpeed() {
        return 40;
    }

    @Override
    public int getPrice() {
        return 400;
    }

    @Override
    public int getRange() {
        return 6;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
        // return Color.BLUE;
    }

    @Override
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
            if(super.initialDamage <= 2000){
                super.initialDamage *= 2;
                System.out.println("suuu");
            }
        }
    }

    @Override
    public void focus(Board board) {
        if (target != null) {
            newTarget = false;
            if (!isInRange(target.getCoord(), board.getSize()) || !target.isAlive()){ // Si l'unité sort de la range ou meurt
                target = null;
                reset();
            }
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
}
