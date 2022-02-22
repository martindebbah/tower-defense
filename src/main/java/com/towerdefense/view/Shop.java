package com.towerdefense.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;

import com.towerdefense.model.BasicTower;
import com.towerdefense.model.Tower;

public class Shop extends JPanel {

    private TowerPanel towerPanel;
    private Description description;
    private Tower selected;
    private boolean wantPurchase;

    public Shop() {
        setPreferredSize(new Dimension(300, 700));
        //setBackground(Color.RED);
        setLayout(new BorderLayout());

        towerPanel = new TowerPanel();
        add(towerPanel, BorderLayout.NORTH);
        description = new Description();
        add(description, BorderLayout.SOUTH);
    }

    public void refreshDesc(Tower t) {
        deselect();
        description.refresh(t);
    }

    public void deselect() {
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
            setPreferredSize(new Dimension(300, 200));
            //setBackground(Color.BLACK);
            add(new TowerView(new BasicTower(), Shop.this));
            setOpaque(false);
        }

    }

    public class Description extends JPanel {

        private JLabel name;
        private JLabel damage;
        private JLabel range;
        private JLabel attackSpeed;
        private JLabel price;
        private JButton cancel;

        public Description() {
            setPreferredSize(new Dimension(300, 500));
            //setBackground(Color.YELLOW);

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.name = new JLabel();
            this.damage = new JLabel();
            this.range = new JLabel();
            this.attackSpeed = new JLabel();
            this.price = new JLabel();
            this.cancel = new JButton("Annuler");
            cancel.addActionListener(e -> {
                Shop.this.refreshDesc(null);
            });

            add(name);
            add(damage);
            add(range);
            add(attackSpeed);
            add(price);
            add(cancel);

            refresh(null);
        }

        public void refresh(Tower t) {
            if (t == null) {
                setVisible(false);
            }else {
                name.setText("Tour : " + t);
                damage.setText("Dégâts : " + t.getDamage());
                attackSpeed.setText("Vitesse d'attaque : " + t.getAttackSpeed());
                range.setText("Portée : " + t.getRange() + " cases");
                price.setText("Prix : " + t.getPrice());

                setVisible(true);
            }
        }

    }
    
}
