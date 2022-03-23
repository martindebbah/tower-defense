package com.towerdefense.view;

import javax.swing.JFrame;
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
        revalidate();
        repaint();
    }

    public void setMenu() {
        getContentPane().removeAll();
        getContentPane().add(new Menu(this));
        revalidate();
        repaint();
    }

    public void setNewGame() {
        setContentPane(new NewGame(this));
        revalidate();
        repaint();
    }

    public void setParametres() {
        setContentPane(new Parametres(this));
        revalidate();
        repaint();
    }

    public void refresh(){
        revalidate();
        repaint();
    }

    public void play() {
        GameView gameView = new GameView(this);
        setContentPane(gameView);
        gameView.start();
    }
    
}
