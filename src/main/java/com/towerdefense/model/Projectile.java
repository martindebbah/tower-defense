package com.towerdefense.model;

import java.awt.Color;

import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.Tower;

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

    public Projectile(Tower source, Enemy target, Color color, int size) {
        this.source = source;
        this.target = target;
        this.color = color;
        this.size = size;
        this.x = source.getCoord()[0] * size + size / 2;
        this.y = source.getCoord()[1] * size + size / 2;
        this.hit = false;
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
        if (deltaX == 0) // Pour éviter une division par 0
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
    
}
