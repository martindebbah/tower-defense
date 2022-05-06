package com.towerdefense.model.tower;

import java.awt.Color;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Board;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.enemy.*;

public class InfernalTower extends Tower {
    
    protected int damage;
    private BufferedImage image;

    public InfernalTower(int damage) {
        super(damage);
        this.damage = damage;
        try {
            this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2005.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void reset(){
        super.initialDamage = damage;
    }

    @Override
    public Tower newTower() {
        return new InfernalTower(2);
    }

    @Override
    public String toString() {
        return "Tour de l'enfer";
    }

    @Override
    public int getAttackSpeed() {
        return 30;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1: return 400;
            case 2: return 500;
            default: return 300;
        }
    }

    @Override
    public int getRange() {
        return 6;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void attack(Board board) {
        if (!canAttack())
            return;

        if (coolDown == 0) {
            addProjectile(new Projectile(getSource(), target));
        }
        if (coolDown <= getAttackSpeed()) {  // tire toutes les 30 * 50 millisecondes
            coolDown++;
        }else {
            coolDown = 0;
            if(super.initialDamage <= 2000){
                super.initialDamage *= 2;
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
                if (e instanceof TankEnemy || e instanceof Boss) {
                    // Focus d'abord les tanks
                    target = e;
                    newTarget = true;
                    return;
                    // Dès qu'on en focus un on arrête la fonction
                }
                if (target == null) { // Si c'est pas un tank, garde la première cible qu'il a vérouillé
                    target = e;
                    newTarget = true;
                }
            }else {
                target = null;
            }
        }
    }

    @Override
    public void upgrade(){
        level++;
        switch(level){
            case 1:
                initialDamage += 8;
                damage += 6;
                break;
            case 2:
                initialDamage += 16;
                damage += 16;
                break;
            case 3:
                initialDamage += 32;
                damage += 32;
                break;
        }
    }
}
