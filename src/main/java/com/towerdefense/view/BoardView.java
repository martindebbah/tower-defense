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
import com.towerdefense.model.enemy.Enemy;
import com.towerdefense.model.tower.Tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class BoardView extends JPanel implements MouseInputListener {

    private Board board;
    private int size;
    private Shop shop;
    private int[] preview;
    private boolean isPaused = false;
    private Player player;

    public BoardView(Game game, Shop shop) {
        this.board = game.getBoard();
        this.player = game.getPlayer();
        size = board.getSize();
        setPreferredSize(new java.awt.Dimension(size * board.getNbCases(), size * board.getNbCases()));
        this.shop = shop;

        addMouseListener(this);
        addMouseMotionListener(this);
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
                try {
                    BufferedImage image = ImageIO
                            .read(new File(
                                    "src/main/resources/Images/towerDefense_tile024.png"));
                    g.drawImage(image, x * size, y * size, 34, 34, null);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintComponentInit(g);// ok mais ça freeze demander à Martin

        /*
         * Combien de cases dans le tableau ? pour le moment 20x20 (choix dans création
         * de Board)
         * Est-ce qu'on dessine les cases quand le tableau est vide ?
         */

        for (int x = 0; x < board.getNbCases(); x++) {
            for (int y = 0; y < board.getNbCases(); y++) {
                if (x == 10 && y == 0) {
                    g.setColor(Color.PINK);
                    g.fillRect(y * size, x * size, size, size);
                }
                if (x == 10 && y == 19) {
                    g.setColor(Color.GREEN);
                    g.fillRect(y * size, x * size, size, size);
                }
                if (board.getBoard()[x][y].containsTower()) {
                    // g.setColor(board.getBoard()[x][y].getTower().getColor());
                    // g.fillRect(x * size, y * size, size, size);
                    board.getBoard()[x][y].getTower().typeTower(g, x * size, y * size);
                }
                g.setColor(Color.BLACK);
                g.drawRect(y * size, x * size, size, size);
            }
        }

        for (Enemy e : board.getEnemies()) {
            e.typeEnemy(g);
            g.setColor(Color.GREEN);
            g.drawRect(e.getCoord()[0], e.getCoord()[1] - 10, size, 5);
            g.fillRect(e.getCoord()[0], e.getCoord()[1] - 10, e.getHP() * size / 100, 5);
            // System.out.println(e.getX() + " : " + e.getY());
        }

        for (Tile[] tab : board.getBoard())
            for (Tile t : tab)
                if (t.containsTower())
                    for (Projectile p : t.getTower().getProjectiles()) {
                        g.setColor(p.getColor());
                        g.fillOval((int) p.getX(), (int) p.getY(), size / 4, size / 4);
                    }

        if (preview != null) { // Bug avec la tour de base (le preview est vert puis noir entre deux waves)
            if (!board.getBoard()[preview[0] / size][preview[1] / size].containsTower()) {
                g.setColor(shop.getPreviewColor());
                g.fillRect(preview[0], preview[1], size, size);
            }
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

        if (board.containsEnemyOn(x / size, y / size)) // Pour ne pas pouvoir poser une tour sur un ennemi
            return;

        if (board.getBoard()[x / size][y / size].containsTower()) { // Ouvre la description dans le shop
            shop.refreshDesc(board.getBoard()[x / size][y / size].getTower());
        } else { // ou pose une tour
            if (player.canAfford(shop.getTowerPanel().getSelected().getTower()) && shop.wantPurchase() && !isPaused
                    && board.canBuildOn(x / size, y / size)) { // Vérifier aussi que le joueur a assez d'argent
                addTower(shop.addNewTower(), x / size, y / size); // Erreur lorsqu'on bloque la sortie !
                player.setMoney(player.getMoney() - shop.getTowerPanel().getSelected().getTower().getPrice()); // achète
                                                                                                               // la
                                                                                                               // tour
            }
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void start() {
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
