package com.towerdefense.model;

public class Tile {
    private Tower t;
    private int x,y;
    private Tile parent;
    private double quality;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        this.t = null;
        this.parent = null;
    }

    public boolean containsTower(){
        return this.t != null;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public Tower getTower(){
        return t;
    }

    public void setTower(Tower t){
        this.t = t;
    }

    public Tile getParent(){
        return this.parent;
    }

    public void setParent(Tile p){
        this.parent = p;
    }

    public double getQuality(){
        return quality;
    }

    public void setQuality(double q){
        this.quality = q;
    }
}
