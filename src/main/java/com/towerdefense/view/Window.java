package com.towerdefense.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.towerdefense.level.Level;
import com.towerdefense.model.Player;
import com.towerdefense.view.menu.*;

public class Window extends JFrame {

    private SoundManager s = new SoundManager();
    private String background = "src/main/resources/Images/towerDefense_tile5000.png";

    public Window() {
        s.play(2);
        // Définition de la fenêtre
        setSize(1200, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setAccueil();

    }

    public void setAccueil() {
        getContentPane().add(new Accueil(this, background));
        refresh();
    }

    public void setMenu() {
        getContentPane().removeAll();
        setContentPane(new Menu(this,background));
        refresh();
    }

    public void setNewGame() {
        getContentPane().removeAll();
        setContentPane(new NewGame(this,background));
        refresh();
    }

    public void setHighScore() {
        getContentPane().removeAll();
        setContentPane(new HighScoreInMenu(this, background));
        refresh();
    }

    public void setParametres() {
        getContentPane().removeAll();
        setContentPane(new Parametres(this, s, background));
        refresh();
    }

    public void refresh() {
        revalidate();
        repaint();
    }

    public void play(Level level) {
        s.stop();
        GameView gameView = new GameView(this,level);
        setContentPane(gameView);
        gameView.start();
    }

    public void endGame(int status, Player p) {
        getContentPane().removeAll();
        setContentPane(new EndGame(this, status, p));
        refresh();
    }
}
