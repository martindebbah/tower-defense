package com.towerdefense.view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.towerdefense.model.Board;
import com.towerdefense.model.Game;
import com.towerdefense.model.Player;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.Tile;
import com.towerdefense.model.Wave;
import com.towerdefense.model.enemy.AerialEnemy;
import com.towerdefense.model.enemy.BasicEnemy;
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.enemy.Boss;
import com.towerdefense.model.enemy.TankEnemy;
import com.towerdefense.model.tower.SuperTower;
import com.towerdefense.model.tower.Tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class BoardView extends JPanel implements MouseInputListener {

    private Board board;
    private int size;
    private Shop shop;
    private int[] preview;
    private int[] selection;
    private boolean isPaused = false;
    private Player player;
    private BufferedImage background;

    public BoardView(Game game, Shop shop) {
        this.board = game.getBoard();
        this.player = game.getPlayer();
        size = board.getSize();
        setPreferredSize(new java.awt.Dimension(size * board.getNbCases(), size * board.getNbCases()));
        this.shop = shop;

        addMouseListener(this);
        addMouseMotionListener(this);

        try {
            this.background = ImageIO.read(new File("src/main/resources/Images/floor_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Board getBoard() {
        return board;
    }

    public void addEnemy(Enemy e) {
        board.addEnemy(e);
    }

    public void addTower(Tower t, int x, int y) {
        board.addTower(t, x, y);
    }

    public void paintComponentInit(Graphics g) {
        for (int x = 0; x < board.getNbCases(); x++) {
            for (int y = 0; y < board.getNbCases(); y++) {
                g.drawImage(background, x * size, y * size, size, size, null);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintComponentInit(g);

        for (int x = 0; x < board.getNbCases(); x++) {
            for (int y = 0; y < board.getNbCases(); y++) {
                if (board.getGame().getLevel() == com.towerdefense.level.Level.DIFFICULT) {
                    if (x == 5 && y == 0) {
                        g.setColor(Color.PINK);
                        g.fillRect(y * size, x * size, size, size);
                    }
                    if (x == 15 && y == 0) {
                        g.setColor(Color.PINK);
                        g.fillRect(y * size, x * size, size, size);
                    }
                    if (x == 10 && y == 19) {
                        g.setColor(Color.GREEN);
                        g.fillRect(y * size, x * size, size, size);
                    }
                } else {
                    if (x == 10 && y == 0) {
                        g.setColor(Color.PINK);
                        g.fillRect(y * size, x * size, size, size);
                    }
                    if (x == 10 && y == 19) {
                        g.setColor(Color.GREEN);
                        g.fillRect(y * size, x * size, size, size);
                    }
                }
                if (board.getBoard()[x][y].containsTower()) {
                    try {
                        g.drawImage(board.getBoard()[x][y].getTower().getImage(), x * size, y * size, size, size, null);
                    } catch (NullPointerException ex) {
                        g.setColor(board.getBoard()[x][y].getTower().getColor());
                        g.fillRect(x * size, y * size, size, size);
                    }
                }
            }
        }

        for (Enemy e : board.getEnemies()) {
            try {
                if(e instanceof Boss){
                    g.drawImage(e.getImage(), e.getX(), e.getY()-15, size+5, size+15, null);
                } else{
                    if(e instanceof BasicEnemy){
                        g.drawImage(e.getImage(), e.getX(), e.getY()-5, size-5, size+5, null);
                    } else {
                        if(e instanceof AerialEnemy){
                            g.drawImage(e.getImage(), e.getX(), e.getY()-5, size+2, size+8, null);
                        } else {
                            if(e instanceof TankEnemy){
                                g.drawImage(e.getImage(), e.getX(), e.getY()-13, size+10, size+10, null);
                            } else{
                                g.drawImage(e.getImage(), e.getX(), e.getY(), size, size, null);
                            }
                        }
                    }
                    
                }
            } catch (NullPointerException ex) {
                g.setColor(Color.RED);
                g.fillOval(e.getX(), e.getY(), size, size);
            }
            if(!(e instanceof Boss)){g.setColor(Color.GREEN);}
            else{g.setColor(Color.RED);}
            if(e instanceof TankEnemy){
                g.drawRect(e.getCoord()[0]+5, e.getCoord()[1] - 15, size, 5);
                g.fillRect(e.getCoord()[0]+5, e.getCoord()[1] - 15, e.getHP() * size / 100, 5);
            } else{
                g.drawRect(e.getCoord()[0], e.getCoord()[1] - 10, size, 5);
                g.fillRect(e.getCoord()[0], e.getCoord()[1] - 10, e.getHP() * size / 100, 5);
            }
        }

        for (Tile[] tab : board.getBoard()){
            for (Tile t : tab)
                if (t.containsTower())
                    for (Projectile p : t.getTower().getProjectiles()) {
                        g.drawImage(p.getImage(), (int)p.getX(), (int)p.getY(), size/4, size/4,null);
                    }
        }

        for (Tile[] tab : board.getBoard())
            for (Tile t : tab)
                if (t.containsTower()){
                    for (Projectile p : t.getTower().getKillProjectiles()) {
                        if(t.getTower() instanceof SuperTower){
                            g.drawImage(p.getImage(), (int)p.getX()-40, (int)p.getY()-50, size+30, size+30,null);
                        } else{
                            g.drawImage(p.getImage(), (int)p.getX()-30, (int)p.getY()-15, size+5, size+5,null);
                        }
                    }
                }
        
        for (Tile[] tab : board.getBoard()){
            for (Tile t : tab)
                if (t.containsTower())
                    if(t.getTower().getTarget() == null) t.getTower().getKillProjectiles().clear();
        }            

        if (preview != null) {
            if (!board.getBoard()[preview[0] / size][preview[1] / size].containsTower()) {
                if (canPurchase(preview[0], preview[1]))
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.RED);
                g.fillRect(preview[0], preview[1], size, size);
            }
        }

        if (shop.wantPurchase() || shop.getDescription().getSelected() == null) {
            selection = null;
        }

        if (selection != null) {
            g.setColor(Color.WHITE);

            // Sélection de la tour
            g.drawRect(selection[0], selection[1], size, size);
            
            // Affichage de la portée de la tour
            Tower t = board.getBoard()[selection[0] / size][selection[1] / size].getTower();
            g.drawOval(selection[0] - t.getRange() * size + size / 2, selection[1] - t.getRange() * size + size / 2, t.getRange() * size * 2, t.getRange() * size * 2);
            
            // Mise à jour du shop
            shop.refreshDesc(t);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ne fait rien
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (board.getBoard()[x / size][y / size].containsTower()) { // Ouvre la description dans le shop
            shop.refreshDesc(board.getBoard()[x / size][y / size].getTower());
            selection = new int[2];
            selection[0] = x - x % size;
            selection[1] = y - y % size;
        } else { // ou pose une tour
            if (canPurchase(x, y)) { // Achète la tour
                addTower(shop.addNewTower(), x / size, y / size);
                player.setMoney(player.getMoney() - shop.getTowerPanel().getSelected().getTower().getPrice());
            }
            selection = null;
            if (!shop.wantPurchase())
                shop.refreshDesc(null);
        }
    }

    public boolean canPurchase(int x, int y) {
        // Vérifie que le joueur a assez d'argent, veut acheter une tour, peut poser la
        // tour (qu'il n'y a pas un ennemi ou une tour)et que le jeu n'est pas en pause
        return shop.wantPurchase() && player.canAfford(shop.getTowerPanel().getSelected().getTower()) && !isPaused
                && board.canBuildOn(x / size, y / size) && !board.containsEnemyOn(x / size, y / size);
    }

    public void pause() {
        for(Enemy e : board.getEnemies()){
            e.stop();
        }
        isPaused = true;
    }

    public void start(boolean mute) {
        if(!mute){
            for(Enemy e : board.getEnemies()){
                e.sound();
            }
        }
        isPaused = false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Ne fais rien
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Ne fais rien
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Enlève le preview
        preview = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Ne fais rien
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!shop.wantPurchase())
            return;

        // Déplace le preview de la tour à poser
        int x = e.getX();
        int y = e.getY();
        preview = new int[2];
        preview[0] = x - x % size;
        preview[1] = y - y % size;
    }

}
