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
        //wave.start();

        JPanel pausePanel = new JPanel();
        JButton pause =  new JButton("Pause");
        JButton resume = new JButton("Reprendre");
        JButton faster = new JButton("x1");
        JPanel buttonPanel = new JPanel();
        pausePanel.add(pause);
        buttonPanel.add(pausePanel);
        buttonPanel.add(faster);
        buttonPanel.setOpaque(false);

        pause.addActionListener(e -> {
            pausePanel.remove(pause);
            pausePanel.add(resume);
            gv.pause();
            faster.setEnabled(false);
        });
        resume.addActionListener(e -> {
            pausePanel.remove(resume);
            pausePanel.add(pause);
            gv.start();
            faster.setEnabled(true);
        });
        faster.addActionListener(e -> {
            gv.changeSpeed();
            faster.setText("x"+gv.getSpeed());
        });

        add(wave.getMoneyPlayer());
        add(wave.getCptWave());
        add(wave.getChrono());
        add(buttonPanel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawRect(230, 50, 500, 20); // affiche la barre de vie du joueur (peut etre il faudrait l aligner au centre)
        g.fillRect(230, 50, wave.getPlayer().getHP() * 500 / 1000, 20);
    }    
    
}
