package com.towerdefense.model;

import java.awt.Color;

public class Projectile {

    private Tower source;
    private Enemy target;
    private Color color;
    private int size;
    private int x;
    private int y;
    private boolean hit;

    public Projectile(Tower source, Enemy target, Color color, int size) {
        this.source = source;
        this.target = target;
        this.color = color;
        this.size = size;
        this.x = source.getCoord()[0] * size;
        this.y = source.getCoord()[1] * size;
        this.hit = false;
    }

    public Projectile(Tower source, Enemy target) {
        this(source, target, Color.BLUE, 32); // 32 à changer !!
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void kill() {
        hit = true;
    }

    public boolean hit() {
        return hit;
    }

    public void move() {
        if (Math.abs(x - target.getCoord()[0]) < size && Math.abs(y - (size*target.getCoord()[1]-size/2)) < size) {
            target.getHit(source.getDamage());
            kill();
            return;
        }
        if (Math.abs(x - target.getCoord()[0]) < size) {
            x = target.getCoord()[0];
        }else if (x - target.getCoord()[0] < 0) {
            x += size;
        }else {
            x -= size;
        }
        if (Math.abs(y - (size*target.getCoord()[1]-size/2)) < size) {
            y = (size*target.getCoord()[1]-size/2);
        }else if (y - (size*target.getCoord()[1]-size/2) < 0) {
            y += size;
        }else {
            y -= size;
        }
    }
    
}
