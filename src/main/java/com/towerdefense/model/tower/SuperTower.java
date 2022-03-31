package com.towerdefense.model.tower;

import java.awt.Color;
import com.towerdefense.model.enemy.Enemy;

public class SuperTower extends Tower {
	 public SuperTower(int damage) {
		super(damage);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public Tower newTower() {
	        return new SuperTower(50);
	    }

	    @Override
	    public String toString() {
	        return "Super Tower";
	    }

	    @Override
	    public int getAttackSpeed() {
	        return 20;
	    }

	    @Override
	    public int getPrice() {
	        return 650;
	    } 

	    @Override
	    public int getDamage() {
	        return 50;
	    }

	    @Override
	    public int getRange() {
	        return 10;
	    }

	    @Override
	    public Color getColor() {
	        return new Color(184, 43,14);
	    }

	    @Override
	    public Color getPreviewColor() {
	        return new Color(184, 43, 14);
	    }

	    
	    public boolean canFocus(Enemy e) {
	        return true; // s'attaque à tous les types d'ennemis
	    }


}
