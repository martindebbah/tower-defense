package com.towerdefense.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.towerdefense.level.Level;
import com.towerdefense.model.Player;
import com.towerdefense.view.menu.*;

public class Window extends JFrame {

    SoundManager s = new SoundManager("src/main/resources/sound/su.wav");

    public Window() {
        s.play();
        // Définition de la fenêtre
        setSize(1200, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setAccueil();

        // test
        // play();

    }

    public void setAccueil() {
        getContentPane().add(new Accueil(this,"src/main/resources/Images/towerDefense_tile5000.png"));
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

    public void setParametres() {
        setContentPane(new Parametres(this));
        refresh();
    }

    public void refresh() {
        revalidate();
        repaint();
    }

    public void play(Level level) {
        GameView gameView = new GameView(this,level);
        setContentPane(gameView);
        gameView.start();
    }

    public void endGame(int status, Player p) {
        setContentPane(new EndGame(this, status, p));
        refresh();
    }
}
