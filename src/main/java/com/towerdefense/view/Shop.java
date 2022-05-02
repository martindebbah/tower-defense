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

import com.towerdefense.model.Board;
import com.towerdefense.model.Player;
import com.towerdefense.model.tower.AerialTower;
import com.towerdefense.model.tower.BasicTower;
import com.towerdefense.model.tower.DestructiveTower;
import com.towerdefense.model.tower.InfernalTower;
import com.towerdefense.model.tower.RapidTower;
import com.towerdefense.model.tower.SuperTower;
import com.towerdefense.model.tower.Tower;

public class Shop extends JPanel {

    protected TowerPanel towerPanel;
    private Description description;
    private boolean wantPurchase;
    protected Player player;
    protected Board board;
    private Window window;

    public Shop(Player player, Window window, GameView g) {
        setPreferredSize(new Dimension(300, 700));
        setLayout(new BorderLayout());

        this.player = player;
        this.window = window;
        JButton back = new JButton("Quitter");
        back.addActionListener(e -> {
			g.killBoard();
            this.window.setMenu();
		});
        towerPanel = new TowerPanel();
        add(towerPanel, BorderLayout.NORTH);
        description = new Description(player);
        add(description, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
    }

    public TowerPanel getTowerPanel(){
        return towerPanel;
    }

    public Description getDescription() {
        return description;
    }

    public Board getBoard(){
        return board;
    }

    public void setBoard(Board b){
        this.board = b;
    }

    public void refreshDesc(Tower t) {
        deselect();
        description.refresh(t);
    }

    public void deselect() {
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
            addTower(new TowerView(new BasicTower(0), Shop.this));
            addTower(new TowerView(new AerialTower(0), Shop.this));
            addTower(new TowerView(new RapidTower(0), Shop.this));
            addTower(new TowerView(new InfernalTower(0), Shop.this));
            addTower(new TowerView(new SuperTower(0), Shop.this));
            addTower(new TowerView(new DestructiveTower(0), Shop.this));

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
        private JButton upgrade;
        private JButton sellTower;
        private JButton cancel;
        private JPanel labels;
        private Tower selected;

        public Description(Player player) {
            setPreferredSize(new Dimension(900, 900));
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));

            this.name = new JLabel();
            this.damage = new JLabel();
            this.range = new JLabel();
            this.attackSpeed = new JLabel();
            this.price = new JLabel();
            this.upgrade = new JButton("Améliorer");
            this.sellTower = new JButton("Vendre");
            this.cancel = new JButton("Annuler");
            upgrade.setVisible(false);
            upgrade.addActionListener(e -> {
                player.setMoney(player.getMoney()-selected.moneyOnLevel());
                selected.upgrade();
                refresh(selected);
            });
            sellTower.setVisible(false);
            sellTower.addActionListener(e -> {
                player.setMoney(player.getMoney()+selected.getPrice()/2);
                getBoard().removeTower(selected.getCoord()[0], selected.getCoord()[1]);
                refresh(null);
            });
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
            labels.add(upgrade);
            labels.add(sellTower);
            labels.add(cancel);

            JPanel border = new JPanel();
            border.setPreferredSize(new Dimension(160, 160));
            border.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            border.add(labels);

            add(border);

            refresh(null);
        }

        public void refresh(Tower t) {
            this.selected = t;
            
            if (t == null) {
                labels.setVisible(false);
            }else {
                name.setText(t.toString());
                if(t.getDamage() == 0 && t instanceof BasicTower || t instanceof AerialTower){
                    damage.setText("Dégâts : 20");
                } else if(t.getDamage() == 0 && t instanceof RapidTower){
                    damage.setText("Dégâts : 10");
                } else if(t.getDamage() == 0 && t instanceof InfernalTower){
                    damage.setText("Dégâts : 5->2000");
                } else if(t.getDamage() == 0 && t instanceof SuperTower){
                    damage.setText("Dégâts : 50");
                } else if(t.getDamage() == 0 && t instanceof DestructiveTower){
                    damage.setText("Dégâts : 150");
                } else {
                    damage.setText("Dégâts : " + t.getDamage());
                }
                attackSpeed.setText("Vitesse d'attaque : " + t.getAttackSpeed());
                range.setText("Portée : " + t.getRange() + " cases");
                price.setText("Prix : " + t.getPrice());
                if(t.getDamage() != 0){
                    sellTower.setVisible(true);
                    upgrade.setVisible(true);
                } else {
                    sellTower.setVisible(false);
                    upgrade.setVisible(false);
                }
                if(selected.moneyOnLevel() == 400){
                    upgrade.setText("MAX");
                } else {
                    upgrade.setText("Améliorer "+selected.moneyOnLevel());
                }
                upgrade.setEnabled(selected.getDamage() != 0 && selected.canUpgrade(player)); // changer la premiere condition
                sellTower.setEnabled(selected.getDamage() != 0);

                labels.setVisible(true);
            }

            for (TowerView tower : Shop.this.towerPanel.getTowers()){
                tower.deselect();
            }
            
        }

        public Tower getSelected() {
            return selected;
        }

    }
    
}
