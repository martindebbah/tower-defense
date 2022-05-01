package com.towerdefense.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.towerdefense.model.Player;
import com.towerdefense.view.menu.*;

public class Window extends JFrame {

    public Window() {
        // Définition de la fenêtre
        setSize(1000, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setAccueil();

    }

    public void setAccueil() {
        getContentPane().add(new Accueil(this));
        refresh();
    }

    public void setMenu() {
        getContentPane().removeAll();
        getContentPane().add(new Menu(this));
        refresh();
    }

    public void setNewGame() {
        setContentPane(new NewGame(this));
        refresh();
    }

    public void setHighScore() {
        setContentPane(new HighScore(null, this));
        JButton back = new JButton("Retour");
        back.addActionListener(e -> {
            setMenu();
        });
        add(back);
        refresh();
    }

    public void setParametres() {
        setContentPane(new Parametres(this));
        refresh();
    }

    public void refresh() {
        revalidate();
        repaint();
    }

    public void play() {
        GameView gameView = new GameView(this);
        setContentPane(gameView);
        gameView.start();
    }

    public void endGame(int status, Player p) {
        setContentPane(new EndGame(this, status, p));
        refresh();
    }
}
