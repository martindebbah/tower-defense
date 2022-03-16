package com.towerdefense.view;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Board;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Game;
import com.towerdefense.model.Projectile;
import com.towerdefense.model.Tile;
import com.towerdefense.model.Tower;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;


public class BoardView extends JPanel implements MouseInputListener {

    private Board board;
    private int size;
    private Shop shop;
    private int[] preview;

    public BoardView(Game game, Shop shop) {
        this.board = game.getBoard();
        size = board.getSize();
        setPreferredSize(new java.awt.Dimension(size * board.getNbCases(), size * board.getNbCases()));
        this.shop = shop;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public Board getBoard(){
        return board;
    }

    public void addEnemy(Enemy e) {
        board.addEnemy(e);
    }

    public void addTower(Tower t, int x, int y) {
        board.addTower(t, x, y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*
        Combien de cases dans le tableau ? pour le moment 20x20 (choix dans création de Board)
        Est-ce qu'on dessine les cases quand le tableau est vide ?
        */

        for(int x = 0; x < board.getNbCases(); x++) {
        	for(int y = 0; y < board.getNbCases(); y++) {
                if(x == 10 && y == 0){
                    g.setColor(Color.PINK);
                    g.fillRect(y*size, x*size, size, size);
                }
                if(x == 10 && y == 19){
                    g.setColor(Color.GREEN);
                    g.fillRect(y*size, x*size, size, size);
                }
                if (board.getBoard()[x][y].containsTower()) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * size, y * size, size, size);
                }
        		g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
        	}
        }

        for (Enemy e : board.getEnemies()) {
            g.setColor(Color.RED);
            int[] coord = e.getCoord();
            g.fillOval(coord[0], coord[1], size, size);
            g.setColor(Color.GREEN);
            g.drawRect(coord[0], coord[1]- 10, size, 5);
            g.fillRect(coord[0], coord[1]- 10, e.getHP() * size / 100, 5);
            //System.out.println(e.getX()/32 + " : " + e.getY()/32);
        }

        for (Tile[] tab : board.getBoard())
            for (Tile t : tab)
                if (t.containsTower())
                    for (Projectile p : t.getTower().getProjectiles()) {
                        g.setColor(p.getColor());
                        g.fillOval(p.getX(), p.getY(), size / 4, size / 4);
                    }

        if (preview != null) {
            if (!board.getBoard()[preview[0] / size][preview[1] / size].containsTower()) {
                g.setColor(Color.PINK);
                g.fillRect(preview[0], preview[1], size, size);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        if(board.containsEnemyOn(x / size, y / size))  // Pour ne pas pouvoir poser une tour sur un ennemi
            return;

        if (board.getBoard()[x / size][y / size].containsTower()) { // Ouvre la description dans le shop
            shop.refreshDesc(board.getBoard()[x / size][y / size].getTower());
        }else { // ou pose une tour
            addTower(new BasicTower(), x / size, y / size); // Erreur lorsqu'on bloque la sortie !
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Ne fait rien
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
        // Déplace le preview de la tour à poser
        int x = e.getX();
        int y = e.getY();
        if (shop.wantPurchase()) {
            preview = new int[2];
            preview[0] = x - x % size;
            preview[1] = y - y % size;
        }
    }

}
