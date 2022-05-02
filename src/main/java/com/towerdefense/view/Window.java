package com.towerdefense.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.towerdefense.level.Level;
import com.towerdefense.model.Player;
import com.towerdefense.view.menu.*;
import com.towerdefense.view.menu.SoundManager;

public class Window extends JFrame {

    private SoundManager s = new SoundManager();

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
        getContentPane().add(new Accueil(this, "src/main/resources/Images/towerDefense_tile5000.png"));
        refresh();
    }

    public void setMenu() {
        getContentPane().removeAll();
        getContentPane().add(new Menu(this,"src/main/resources/Images/towerDefense_tile5000.png"));
        refresh();
    }

    public void setNewGame() {
        getContentPane().removeAll();
        setContentPane(new NewGame(this,"src/main/resources/Images/towerDefense_tile5000.png"));
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
        getContentPane().removeAll();
        setContentPane(new Parametres(this,s));
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
