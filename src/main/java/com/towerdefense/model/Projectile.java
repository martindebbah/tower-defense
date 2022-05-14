package com.towerdefense.model;

import java.awt.Color;

import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.BasicTower;
import com.towerdefense.model.tower.InfernalTower;
import com.towerdefense.model.tower.SuperTower;
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
    private BufferedImage image1 = null;
    private BufferedImage image2= null;
    private BufferedImage image3= null;
    private BufferedImage image4= null;
    private BufferedImage image10= null;
    private BufferedImage image20= null;
    private BufferedImage image30= null;
    private BufferedImage image40= null;
    private BufferedImage image100= null;
    private BufferedImage image200= null;
    private BufferedImage image300= null;
    private BufferedImage image400= null;
    private BufferedImage image1000= null;
    private BufferedImage image2000= null;
    private BufferedImage image3000= null;
    private BufferedImage image4000= null;
    private BufferedImage image10000= null;
    private BufferedImage image20000= null;
    private BufferedImage image30000= null;
    private BufferedImage image40000= null;
    private BufferedImage image100000= null;
    private BufferedImage image200000= null;
    private BufferedImage image300000= null;
    private BufferedImage image400000= null;
    private BufferedImage image1000000= null;
    private BufferedImage image2000000= null;
    private BufferedImage image3000000= null;
    private BufferedImage image4000000= null;
    private BufferedImage image10000000= null;
    private BufferedImage image20000000= null;
    private BufferedImage image30000000= null;
    private BufferedImage image40000000= null;
    private BufferedImage boom1= null;
    private BufferedImage boom2= null;
    private BufferedImage boom3= null;
    private BufferedImage boom4= null;
    private BufferedImage boom5= null;
    private BufferedImage boom6= null;
    private BufferedImage boom7= null;
    private BufferedImage boom8= null;
    private BufferedImage boom9= null;
    private BufferedImage boom10= null;
    private BufferedImage boom11= null;
    private BufferedImage boom12= null;
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
                this.image1 = ImageIO.read(new File("src/main/resources/Images/projectile/projectile.png"));
                this.boom1 = ImageIO.read(new File("src/main/resources/Images/projectile/boom1.png"));
                this.boom2 = ImageIO.read(new File("src/main/resources/Images/projectile/boom2.png"));
                this.boom3 = ImageIO.read(new File("src/main/resources/Images/projectile/boom3.png"));
                this.boom4 = ImageIO.read(new File("src/main/resources/Images/projectile/boom4.png"));
                this.boom5 = ImageIO.read(new File("src/main/resources/Images/projectile/boom5.png"));
                this.boom6 = ImageIO.read(new File("src/main/resources/Images/projectile/boom6.png"));
            } else if(source instanceof SuperTower){
                this.image1 = ImageIO.read(new File("src/main/resources/Images/projectile/projectile.png"));
                this.boom1 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl1.png"));
                this.boom2 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl2.png"));
                this.boom3 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl3.png"));
                this.boom4 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl4.png"));
                this.boom5 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl5.png"));
                this.boom6 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl6.png"));
                this.boom7 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl7.png"));
                this.boom8 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl8.png"));
                this.boom9 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl9.png"));
                this.boom10 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl10.png"));
                this.boom11 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl11.png"));
                this.boom12 = ImageIO.read(new File("src/main/resources/Images/explosion_sprite/expl12.png"));
            } else if(source instanceof InfernalTower){
                this.image1 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_2.png"));
                this.image2 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_3.png"));
                this.image3 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_4.png"));
                this.image4 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_5.png"));

                this.image10 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_up_2.png"));
                this.image20 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_up_3.png"));
                this.image30 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_up_4.png"));
                this.image40 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_up_5.png"));

                this.image100 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_down_2.png"));
                this.image200 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_down_3.png"));
                this.image300 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_down_4.png"));
                this.image400 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/left_down_5.png"));

                this.image1000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_2.png"));
                this.image2000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_3.png"));
                this.image3000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_4.png"));
                this.image4000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_5.png"));

                this.image10000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_up_2.png"));
                this.image20000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_up_3.png"));
                this.image30000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_up_4.png"));
                this.image40000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_up_5.png"));

                this.image100000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_down_2.png"));
                this.image200000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_down_3.png"));
                this.image300000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_down_4.png"));
                this.image400000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/right_down_5.png"));

                this.image1000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/up_2.png"));
                this.image2000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/up_3.png"));
                this.image3000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/up_4.png"));
                this.image4000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/up_5.png"));

                this.image10000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/down_2.png"));
                this.image20000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/down_3.png"));
                this.image30000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/down_4.png"));
                this.image40000000 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/down_5.png"));

                this.boom1 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/1.png"));
                this.boom2 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/2.png"));
                this.boom3 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/3.png"));
                this.boom4 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/4.png"));
                this.boom5 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/5.png"));
                this.boom6 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/6.png"));
                this.boom7 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/7.png"));
                this.boom8 = ImageIO.read(new File("src/main/resources/Images/infernalBullet/explosionInfernal/8.png"));
            } else{
                this.image1 = ImageIO.read(new File("src/main/resources/Images/projectile/projectile.png"));
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

    public int getCurrentImg(){
        return currentAnime;
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
        explosion();
    }

    public void explosion(){
        currentAnime = 1;
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

    public BufferedImage getImage(){
        switch(currentAnime){
            case 0:
                return image1;
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
            case 7:
                currentAnime++;
                return boom7;
            case 8:
                currentAnime++;
                return boom8;
            case 9:
                currentAnime++;
                return boom9;
            case 10:
                currentAnime++;
                return boom10;
            case 11:
                currentAnime++;
                return boom11;
            case 12:
                currentAnime = 100;
                return boom12;

            case 13:
                return image2;
            case 14:
                return image3;
            case 15:
                return image4;

            case 20:
                return image10;
            case 21:
                return image20;
            case 22:
                return image30;
            case 23:
                return image40;

            case 30:
                return image100;
            case 31:
                return image200;
            case 32:
                return image300;
            case 33:
                return image400;

            case 40:
                return image1000;
            case 41:
                return image2000;
            case 42:
                return image3000;
            case 43:
                return image4000;

            case 50:
                return image10000;
            case 51:
                return image20000;
            case 52:
                return image30000;
            case 53:
                return image40000;

            case 60:
                return image100000;
            case 61:
                return image200000;
            case 62:
                return image300000;
            case 63:
                return image400000;

            case 70:
                return image1000000;
            case 71:
                return image2000000;
            case 72:
                return image3000000;
            case 73:
                return image4000000;

            case 80:
                return image10000000;
            case 81:
                return image20000000;
            case 82:
                return image30000000;
            case 83:
                return image40000000;
        }
        return null;
    }

    public void rotateProjectile(){
        if(source instanceof InfernalTower){
            if(target.getX()/size < source.getCoord()[0] && target.getY()/size == source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 0;
                } else if(source.getLevel() == 1){
                    currentAnime = 13;
                } else if(source.getLevel() == 2){
                    currentAnime = 14;
                } else if(source.getLevel() == 3){
                    currentAnime = 15;
                }
            } else if(target.getX()/size < source.getCoord()[0] && target.getY()/size < source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 20;
                } else if(source.getLevel() == 1){
                    currentAnime = 21;
                } else if(source.getLevel() == 2){
                    currentAnime = 22;
                } else if(source.getLevel() == 3){
                    currentAnime = 23;
                }
            } else if(target.getX()/size < source.getCoord()[0] && target.getY()/size > source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 30;
                } else if(source.getLevel() == 1){
                    currentAnime = 31;
                } else if(source.getLevel() == 2){
                    currentAnime = 32;
                } else if(source.getLevel() == 3){
                    currentAnime = 33;
                }
            } else if(target.getX()/size > source.getCoord()[0] && target.getY()/size == source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 40;
                } else if(source.getLevel() == 1){
                    currentAnime = 41;
                } else if(source.getLevel() == 2){
                    currentAnime = 42;
                } else if(source.getLevel() == 3){
                    currentAnime = 43;
                }
            } else if(target.getX()/size > source.getCoord()[0] && target.getY()/size < source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 50;
                } else if(source.getLevel() == 1){
                    currentAnime = 51;
                } else if(source.getLevel() == 2){
                    currentAnime = 52;
                } else if(source.getLevel() == 3){
                    currentAnime = 53;
                }
            } else if(target.getX()/size > source.getCoord()[0] && target.getY()/size > source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 60;
                } else if(source.getLevel() == 1){
                    currentAnime = 61;
                } else if(source.getLevel() == 2){
                    currentAnime = 62;
                } else if(source.getLevel() == 3){
                    currentAnime = 63;
                }
            } else if(target.getX()/size == source.getCoord()[0] && target.getY()/size < source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 70;
                } else if(source.getLevel() == 1){
                    currentAnime = 71;
                } else if(source.getLevel() == 2){
                    currentAnime = 72;
                } else if(source.getLevel() == 3){
                    currentAnime = 73;
                }
            } else if(target.getX()/size == source.getCoord()[0] && target.getY()/size > source.getCoord()[1]){
                if(source.getLevel() == 0){
                    currentAnime = 80;
                } else if(source.getLevel() == 1){
                    currentAnime = 81;
                } else if(source.getLevel() == 2){
                    currentAnime = 82;
                } else if(source.getLevel() == 3){
                    currentAnime = 83;
                }
            }
        }
    }
    
}
