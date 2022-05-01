package com.towerdefense.model;

import com.towerdefense.model.tower.Tower;

public class Tile {
    private Tower t;
    private int x,y;
    private Tile parent;
    private double knownDistance; // La distance qu'on a parcouru pour atteindre cette case
    private double distance; // La distance "à vol d'oiseau" jusqu'à la sortie
    private double totalDistance; // La somme des deux distances précédentes

    public Tile(int x, int y, int size){
        this.x = x*size;
        this.y = y*size;
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

    public double getDistance(){
        return distance;
    }

    public void setDistance(double d){
        this.distance = d;
    }

    public double getKnownDistance() {
        return knownDistance;
    }

    public void setKnownDistance(double d) {
        knownDistance = d;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double d) {
        totalDistance = d;
    }

}
