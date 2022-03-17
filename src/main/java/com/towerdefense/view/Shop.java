package com.towerdefense.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.towerdefense.model.AerialTower;
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
        towerPanel.select(null);
    }

    public void purchase(TowerView t) {
        wantPurchase = true;
        towerPanel.select(t);
    }

    public boolean wantPurchase() {
        return wantPurchase;
    }

    public Tower getSelected() {
        return selected;
    }

    public Tower addNewTower() {
        return towerPanel.getSelected().newTower();
    }

    public class TowerPanel extends JPanel {

        private List<TowerView> towers; // La liste des tours dans le shop
        private JPanel panel;
        private TowerView selected;

        public TowerPanel() {
            this.towers = new ArrayList<TowerView>();
            setPreferredSize(new Dimension(300, 200));
            this.panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
            add(panel);
            addTower(new TowerView(new BasicTower(), Shop.this));
            addTower(new TowerView(new AerialTower(), Shop.this));
            setOpaque(false);
        }

        private void addTower(TowerView t) {
            panel.add(t);
            towers.add(t);
        }

        public List<TowerView> getTowers() {
            return towers;
        }

        public TowerView getSelected() {
            return selected;
        }

        public void select(TowerView t) {
            selected = t;
        }

    }

    public class Description extends JPanel {

        private JLabel name;
        private JLabel damage;
        private JLabel range;
        private JLabel attackSpeed;
        private JLabel price;
        private JButton cancel;
        private JPanel labels;

        public Description() {
            setPreferredSize(new Dimension(300, 500));
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));
            //setBackground(Color.YELLOW);

            this.name = new JLabel();
            this.damage = new JLabel();
            this.range = new JLabel();
            this.attackSpeed = new JLabel();
            this.price = new JLabel();
            this.cancel = new JButton("Annuler");
            cancel.addActionListener(e -> {
                Shop.this.refreshDesc(null);
            });

            this.labels = new JPanel();
            labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));

            labels.add(name);
            labels.add(damage);
            labels.add(range);
            labels.add(attackSpeed);
            labels.add(price);
            labels.add(cancel);

            JPanel border = new JPanel();
            border.setPreferredSize(new Dimension(150, 120));
            border.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            border.add(labels);

            add(border);

            refresh(null);
        }

        public void refresh(Tower t) {
            if (t == null) {
                labels.setVisible(false);
            }else {
                name.setText(t.toString());
                damage.setText("Dégâts : " + t.getDamage());
                attackSpeed.setText("Vitesse d'attaque : " + t.getAttackSpeed());
                range.setText("Portée : " + t.getRange() + " cases");
                price.setText("Prix : " + t.getPrice());

                labels.setVisible(true);
            }

            for (TowerView tower : Shop.this.towerPanel.getTowers())
                tower.deselect();
        }

    }
    
}
