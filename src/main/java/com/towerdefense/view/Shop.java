package com.towerdefense.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Color;

import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Tower;

public class Shop extends JPanel {

    private TowerPanel towerPanel;
    private JPanel description;
    private Tower selected;
    private boolean wantPurchase;

    public Shop() {
        setPreferredSize(new java.awt.Dimension(300, 700));
        setBackground(Color.RED);
        setLayout(new BorderLayout());

        towerPanel = new TowerPanel();
        add(towerPanel, BorderLayout.NORTH);
        description = new JPanel();
        add(description, BorderLayout.SOUTH);
    }

    public void refreshDesc(Tower t) {
        deselect();
        selected = t;
        add(new JLabel(t.toString()));
    }

    public void deselect() {
        description.removeAll();
        selected = null;
        wantPurchase = false;
    }

    public void purchase() {
        wantPurchase = true;
    }

    public boolean wantPurchase() {
        return wantPurchase;
    }

    public Tower getSelected() {
        return selected;
    }

    public class TowerPanel extends JPanel {

        public TowerPanel() {
            setPreferredSize(new java.awt.Dimension(300, 200));
            setBackground(Color.BLACK);
            add(new TowerView(new BasicTower(), Shop.this));
        }

    }
    
}
