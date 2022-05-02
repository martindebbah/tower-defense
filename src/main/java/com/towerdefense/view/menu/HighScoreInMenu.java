package com.towerdefense.view.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.towerdefense.view.Window;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class HighScoreInMenu extends JPanel {

    private ImageIcon background;

    public HighScoreInMenu(Window window, String filename) {
        this.background = new ImageIcon(filename);
        
        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        HighScore highScore = new HighScore(null, window);
        add(highScore, gbc);

        if (highScore.getNbScores() != 0) {
            // Bouton pour supprimer les données
            JButton reset = new JButton("Supprimer les scores");
            reset.addActionListener(e -> {
                highScore.reset();
                window.setHighScore();
            });
            add(reset, gbc);
        }else {
            add(new JLabel("Il n'y a aucun score enregistré"), gbc);
        }

        JButton back = new JButton("Retour");
        back.addActionListener(e -> {
            window.setMenu();
        });

        add(back, gbc);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);
    }
    
}
