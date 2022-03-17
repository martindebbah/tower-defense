package com.towerdefense.view;

import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
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
        
    }

    public Tower newTower() {
        return tower.newTower();
    }

    public void select() {
        shop.refreshDesc(tower);
        setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(2,  2,  2,  2, Color.BLACK),
                    BorderFactory.createMatteBorder(3,  3,  3,  3, Color.WHITE)));
        shop.purchase(this);
    }

    public void deselect() {
        setBorder(null);
    }
    
}
