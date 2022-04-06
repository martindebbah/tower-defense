package com.towerdefense.model.tower;
import java.awt.Color;
import com.towerdefense.model.enemy.Enemy;

public class DestructiveTower extends Tower {
	
	
	 public DestructiveTower(int damage) {
		super(damage);
	}

	@Override
	    public Tower newTower() {
	        return new DestructiveTower(150);
	    }

	    @Override
	    public String toString() {
	        return "Destructive Tower";
	    }

	    @Override
	    public int getAttackSpeed() {
	        return 30;
	    }

	    @Override
	    public int getPrice() {
	        return 11000;
	    } 

	    @Override
	    public int getDamage() {
	        return 150;
	    }

	    @Override
	    public int getRange() {
	        return 20;
	    }

	    @Override
	    public Color getColor() {
	        return new Color(0,0,0);
	    }

	    @Override
	    public Color getPreviewColor() {
	        return new Color(0,0, 0);
	    }

	  
	    public boolean canFocus(Enemy e) {
	        return true; // s'attaque à tous les types d'ennemis
	    }


}
