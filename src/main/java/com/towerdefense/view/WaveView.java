package com.towerdefense.view;

import java.awt.Color;

import javax.swing.JPanel;

import com.towerdefense.model.Player;
import com.towerdefense.model.Wave;

import java.awt.Graphics;

public class WaveView extends JPanel {

    private Wave wave;

    public WaveView(Wave wave) {
        this.wave = wave;
        setPreferredSize(new java.awt.Dimension(1000, 112));
        wave.chrono();
        add(wave.getChrono());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawRect(230, 20, 500, 20); // affiche la barre de vie du joueur (peut etre il faudrait l aligner au centre)
        g.fillRect(230, 20, wave.getPlayer().getHP() * 500 / 1000, 20);
    }    
    
}
