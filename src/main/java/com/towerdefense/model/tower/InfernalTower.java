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
    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;
    private BufferedImage image10;
    private BufferedImage image20;
    private BufferedImage image30;
    private BufferedImage image40;
    private BufferedImage image50;
    private BufferedImage image60;
    private BufferedImage image70;
    private BufferedImage image80;
    private BufferedImage image100;
    private BufferedImage image200;
    private BufferedImage image300;
    private BufferedImage image400;
    private BufferedImage image500;
    private BufferedImage image600;
    private BufferedImage image700;
    private BufferedImage image800;
    private int currentImg = 1;

    public InfernalTower(int damage) {
        super(damage);
        this.damage = damage;
        try {
            this.image1 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_left.png"));
            this.image2 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_leftup.png"));
            this.image3 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_leftdown.png"));
            this.image4 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_right.png"));
            this.image5 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_rightup.png"));
            this.image6 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_rightdown.png"));
            this.image7 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_up.png"));
            this.image8 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/1_down.png"));
            this.image10 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_left.png"));
            this.image20 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_leftup.png"));
            this.image30 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_leftdown.png"));
            this.image40 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_right.png"));
            this.image50 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_rightup.png"));
            this.image60 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_rightdown.png"));
            this.image70 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_up.png"));
            this.image80 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/2_down.png"));
            this.image100 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_left.png"));
            this.image200 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_leftup.png"));
            this.image300 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_leftdown.png"));
            this.image400 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_right.png"));
            this.image500 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_rightup.png"));
            this.image600 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_rightdown.png"));
            this.image700 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_up.png"));
            this.image800 = ImageIO.read(new File("src/main/resources/Images/InfernalTower/3_down.png"));
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
        switch(currentImg){
            case 1:
            return image1;
            case 2:
            return image2;
            case 3:
            return image3;
            case 4:
            return image4;
            case 5:
            return image5;
            case 6:
            return image6;
            case 7:
            return image7;
            case 8:
            return image8;
            case 10:
            return image10;
            case 20:
            return image20;
            case 30:
            return image30;
            case 40:
            return image40;
            case 50:
            return image50;
            case 60:
            return image60;
            case 70:
            return image70;
            case 80:
            return image80;
            case 100:
            return image100;
            case 200:
            return image200;
            case 300:
            return image300;
            case 400:
            return image400;
            case 500:
            return image500;
            case 600:
            return image600;
            case 700:
            return image700;
            case 800:
            return image800;
        }
        return null;
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

    @Override
    public void rotateTower(){
        if(target == null){
            if(super.level == 2){
                currentImg = 10;
            } else if(super.level == 3){
                currentImg = 100;
            } else {
                currentImg = 1;
            }
            return;
        }
        int size = target.getGame().getBoard().getSize();
        if(target.getX()/size < super.coord[0] && target.getY()/size == super.coord[1]){
            if(super.level == 2){
                currentImg = 10;
            } else if(super.level == 3){
                currentImg = 100;
            } else {
                currentImg = 1;
            }
        } else if(target.getX()/size < super.coord[0] && target.getY()/size < super.coord[1]){
            if(super.level == 2){
                currentImg = 20;
            } else if(super.level == 3){
                currentImg = 200;
            } else {
                currentImg = 2;
            }
        } else if(target.getX()/size < super.coord[0] && target.getY()/size > super.coord[1]){
            if(super.level == 2){
                currentImg = 30;
            } else if(super.level == 3){
                currentImg = 300;
            } else {
                currentImg = 3;
            }
        } else if(target.getX()/size > super.coord[0] && target.getY()/size == super.coord[1]){
            if(super.level == 2){
                currentImg = 40;
            } else if(super.level == 3){
                currentImg = 400;
            } else {
                currentImg = 4;
            }
        } else if(target.getX()/size > super.coord[0] && target.getY()/size < super.coord[1]){
            if(super.level == 2){
                currentImg = 50;
            } else if(super.level == 3){
                currentImg = 500;
            } else {
                currentImg = 5;
            }
        } else if(target.getX()/size > super.coord[0] && target.getY()/size > super.coord[1]){
            if(super.level == 2){
                currentImg = 60;
            } else if(super.level == 3){
                currentImg = 600;
            } else {
                currentImg = 6;
            }
        } else if(target.getX()/size == super.coord[0] && target.getY()/size < super.coord[1]){
            if(super.level == 2){
                currentImg = 70;
            } else if(super.level == 3){
                currentImg = 700;
            } else {
                currentImg = 7;
            }
        } else if(target.getX()/size == super.coord[0] && target.getY()/size > super.coord[1]){
            if(super.level == 2){
                currentImg = 80;
            } else if(super.level == 3){
                currentImg = 800;
            } else {
                currentImg = 8;
            }
        }
    }
}
