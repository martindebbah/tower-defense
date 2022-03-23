package com.towerdefense.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.towerdefense.model.Wave;

import java.awt.Graphics;

public class WaveView extends JPanel {

    private Wave wave;

    public WaveView(Wave wave, GameView gv) {
        this.wave = wave;
        setPreferredSize(new java.awt.Dimension(1000, 112));
        wave.start();

        JButton pause =  new JButton("Pause");
        JButton resume = new JButton("Reprendre");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(pause);

        pause.addActionListener(e -> {
            buttonPanel.remove(pause);
            buttonPanel.add(resume);
            gv.pause();
            wave.pause();
        });
        resume.addActionListener(e -> {
            buttonPanel.remove(resume);
            buttonPanel.add(pause);
            gv.start();
            wave.start();
        });

        add(buttonPanel);
        add(wave.getCptWave());
        add(wave.getChrono());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawRect(230, 50, 500, 20); // affiche la barre de vie du joueur (peut etre il faudrait l aligner au centre)
        g.fillRect(230, 50, wave.getPlayer().getHP() * 500 / 1000, 20);
    }    
    
}
