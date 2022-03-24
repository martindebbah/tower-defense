package com.towerdefense.view;

import javax.swing.JFrame;

import com.towerdefense.model.Player;
import com.towerdefense.view.menu.*;

public class Window extends JFrame {

    public Window() {

        //Définition de la fenêtre
        setSize(1000, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        setAccueil();

        // test
        //play();

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

    public void setNewPlayer() {
        setContentPane(new NewPlayer(this));
        refresh();
    }

    public void setNewGame(Player p) {
        setContentPane(new NewGame(this, p));
        refresh();
    }

    public void setParametres() {
        setContentPane(new Parametres(this));
        refresh();
    }

    public void refresh(){
        revalidate();
        repaint();
    }

    public void play(Player p) {
        GameView gameView = new GameView(this, p);
        setContentPane(gameView);
        gameView.start();
    }
    
}
