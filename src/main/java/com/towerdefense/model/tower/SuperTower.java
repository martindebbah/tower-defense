package com.towerdefense.model.tower;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Color;
import com.towerdefense.model.enemy.Enemy;

public class SuperTower extends Tower {

	private BufferedImage image;
	
	public SuperTower(int damage) {
		super(damage);
		try {
			this.image = ImageIO.read(new File("src/main/resources/Images/towerDefense_tile2002.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
	    return 25;
	}

	@Override
	public int getPrice() {
	    return 650;
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
		System.out.println(level);
    	switch(level){
        	case 1:
            	initialDamage += 20;
            	break;
         	case 2:
            	initialDamage += 40;
            	break;
        	case 3:
            	initialDamage += 100;
				break;
        }
    }

}
