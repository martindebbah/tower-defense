package com.towerdefense.model.tower;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import com.towerdefense.model.enemy.Enemy;

public class DestructiveTower extends Tower {
	
	private BufferedImage image;
	
	 public DestructiveTower(int damage) {
		super(damage);
		try {
			this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2004.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Tower newTower() {
	    return new DestructiveTower(50);
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
		switch (level) {
			case 1: return 3200;
			case 2:	return 3600;
			default: return 3000;
		}
    } 

    @Override
    public int getRange() {
        return 20;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

	@Override
	public BufferedImage getImage() {
		return image;
	}
	  
	@Override
	public boolean canFocusAerial(Enemy e) {
	    return true; // s'attaque à tous les types d'ennemis
	}

	@Override
	public void upgrade(){
		level++;
		switch(level){
			case 1:
				initialDamage += 50;
				break;
			case 2:
				initialDamage += 100;
				break;
			case 3:
				initialDamage += 200;
				break;
		}
	}
}
