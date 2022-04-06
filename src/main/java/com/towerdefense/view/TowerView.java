package com.towerdefense.view;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import com.towerdefense.model.tower.Tower;

public class TowerView extends JPanel {

    private Tower tower;
    private Shop shop;

    public TowerView(Tower tower, Shop shop) { // L'affichage des tours se fera sûrement depuis cette classe.
        this.tower = tower;
        this.shop = shop;

        setPreferredSize(new java.awt.Dimension(32, 32));
        setBackground(tower.getColor());

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                select();
            }
        });
        /*
         * try {
         * BufferedImage img = ImageIO.read(new File("towerDefense_tile134.png"));
         * Graphics g = this.getGraphics();
         * g.drawImage(img, getX(), getY(), imageObserver(null));
         * } catch (IOException e1) {
         * // TODO Auto-generated catch block
         * e1.printStackTrace();
         * }
         */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tower.typeTower(g, 0, 0);

    }

    private ImageObserver imageObserver(Object object) {
        return null;
    }

    public Tower newTower() {
        return tower.newTower();
    }

    public Tower getTower() {
        return tower;
    }

    public void select() {
        shop.refreshDesc(tower);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK),
                BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE)));
        shop.purchase(this);
    }

    public void deselect() {
        setBorder(null);
    }

}
