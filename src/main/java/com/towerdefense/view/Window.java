package com.towerdefense.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.towerdefense.model.BasicEnemy;
import com.towerdefense.model.Enemy;
import com.towerdefense.model.Game;
import com.towerdefense.model.Player;
import com.towerdefense.model.Wave;
import com.towerdefense.view.menu.*;

import java.awt.BorderLayout;

public class Window extends JFrame {

    private JPanel mainPanel;
    private BoardView board;
    private Shop shop;
    private Game game;

    public Window() {

        //Définition de la fenêtre
        setSize(1000, 1000);
        setTitle("Tower Defense");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setAccueil();

        // test
        //play();

    }

    public void setAccueil() {
        setContentPane(new Accueil(this));
        revalidate();
        repaint();
    }

    public void setMenu() {
        setContentPane(new Menu(this));
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

    private void createBoard() { // Créer une vue pour le plateau
        board = new BoardView(game, shop);
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panel.add(board);
        add(panel, BorderLayout.WEST);
    }

    private void createShop() {
        shop = new Shop();
        add(shop, BorderLayout.EAST);
    }

    public void play() {
        // Création du plateau de jeu
        Player player = new Player("Martin");
        this.game = new Game(32, 20, player);
        // mainPanel = new JPanel();
        setLayout(new BorderLayout());
        // setContentPane(mainPanel);
        createShop();
        createBoard();
        add(new WaveView(new Wave(player)), BorderLayout.NORTH);
        revalidate();
        repaint();

        int r = 0;
        
        while(game.getPlayer().isAlive()) {
            if(r == 0){
                Enemy e1 = new BasicEnemy(game);
                e1.setPath();
                board.addEnemy(e1);
            }
            playRound();
            r++;
        }
    }

    public void playRound() {
        try {
            Thread.sleep(50);
        }catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        game.play();
        revalidate();
        repaint();
    }
    
}
