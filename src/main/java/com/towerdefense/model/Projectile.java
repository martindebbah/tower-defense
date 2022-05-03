package com.towerdefense.model;

import java.awt.Color;

import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.BasicTower;
import com.towerdefense.model.tower.Tower;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile { // changer la couleur en fonction de la tour qui tire

    private Tower source;
    private Enemy target;
    private Color color;
    private int size;
    private double x;
    private double y;
    private int targetX;
    private int targetY;
    private boolean hit;
    private BufferedImage image;
    private BufferedImage boom1;
    private BufferedImage boom2;
    private BufferedImage boom3;
    private BufferedImage boom4;
    private BufferedImage boom5;
    private BufferedImage boom6;
    private int currentAnime = 0;

    public Projectile(Tower source, Enemy target, Color color, int size) {
        this.source = source;
        this.target = target;
        this.color = color;
        this.size = size;
        this.x = source.getCoord()[0] * size + size / 2;
        this.y = source.getCoord()[1] * size + size / 2;
        this.hit = false;
        try {
            if(source instanceof BasicTower){
                this.image = ImageIO.read(new File("src/main/resources/Images/projectile/projectile.png"));
                this.boom1 = ImageIO.read(new File("src/main/resources/Images/projectile/boom1.png"));
                this.boom2 = ImageIO.read(new File("src/main/resources/Images/projectile/boom2.png"));
                this.boom3 = ImageIO.read(new File("src/main/resources/Images/projectile/boom3.png"));
                this.boom4 = ImageIO.read(new File("src/main/resources/Images/projectile/boom4.png"));
                this.boom5 = ImageIO.read(new File("src/main/resources/Images/projectile/boom5.png"));
                this.boom6 = ImageIO.read(new File("src/main/resources/Images/projectile/boom6.png"));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public Projectile(Tower source, Enemy target) {
        this(source, target, Color.BLUE, target.getGame().getBoard().getSize());
    }

    public Projectile(Tower source, Enemy target, Color color) {
        this(source, target, color, target.getGame().getBoard().getSize());
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void kill() {
        hit = true;
        currentAnime++;
    }

    public void explosion(){
        currentAnime++;
    }

    public boolean hit() {
        return hit;
    }

    public void setTargetPos() {
        targetX = target.getX() + size / 2;
        targetY = target.getY() + size / 2;
    }

    public double getAngle() {
        double deltaY = targetY - y;
		double deltaX = targetX - x;
		if (deltaX > 0)
			return Math.atan(deltaY / deltaX);
        if (deltaX == 0)
            return Math.atan(deltaY / 0.00001);
		return Math.atan(deltaY / deltaX) + Math.PI;
    }

    public void move() {
        setTargetPos();

        double hypotenuse = Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
        if (hypotenuse < size / 2) {
            target.getHit(source.getDamage());
            kill();
            return;
        }

        double angle = getAngle();
        x += Math.cos(angle) * size / 2;
        y += Math.sin(angle) * size / 2;
    }

    public BufferedImage getImage(){
        switch(currentAnime){
            case 0:
                return image;
            case 1:
                currentAnime++;
                return boom1;
            case 2:
                currentAnime++;
                return boom2;
            case 3:
                currentAnime++;
                return boom3;
            case 4:
                currentAnime++;
                return boom4;
            case 5:
                currentAnime++;
                return boom5;
            case 6:
                currentAnime++;
                return boom6;
        }
        return null;
    }
    
}
