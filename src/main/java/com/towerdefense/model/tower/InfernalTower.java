package com.towerdefense.model.tower;

import java.awt.Color;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.towerdefense.model.Board;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.enemy.Enemy;

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
        return new InfernalTower(5);
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
        return 500;
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
        if (coolDown <= getAttackSpeed()) {  // tire toutes les 20 * 50 millisecondes
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
                target = e;
                newTarget = true;
                return;
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
                initialDamage += 5;
                damage += 5;
                break;
            case 2:
                initialDamage += 15;
                damage += 10;
                break;
            case 3:
                initialDamage += 30;
                damage += 15;
                break;
        }
    }
}