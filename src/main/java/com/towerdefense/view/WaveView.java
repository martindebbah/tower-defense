package com.towerdefense.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.towerdefense.model.Wave;
import com.towerdefense.view.menu.MyButton;

import java.awt.Graphics;

public class WaveView extends JPanel {

    private Wave wave;
    private JButton nextWave = new JButton("Vague suivante");
    private MyButton mute = new MyButton("", "src/main/resources/Images/button.png", "src/main/resources/Images/button2.png");
    private MyButton demute = new MyButton("", "src/main/resources/Images/mute.png", "src/main/resources/Images/mute2.png");

    public WaveView(Wave wave, GameView gv) {
        this.wave = wave;
        setPreferredSize(new java.awt.Dimension(1000, 112));

        JPanel pausePanel = new JPanel();
        MyButton pause =  new MyButton("","src/main/resources/Images/continue.png","src/main/resources/Images/continue.png");
        MyButton resume = new MyButton("","src/main/resources/Images/pause.png","src/main/resources/Images/pause.png");
        JButton faster = new JButton("x1");
        JPanel buttonPanel = new JPanel();
        pausePanel.add(pause);
        buttonPanel.add(pausePanel);
        buttonPanel.add(faster);
        buttonPanel.add(nextWave);
        buttonPanel.add(mute);
        buttonPanel.add(demute);
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
        nextWave.addActionListener(e -> {
            wave.setCountDown(-1);
        });
        mute.setVisible(true);
        mute.addActionListener(e -> {
            gv.muteEnemies();
            wave.setMute(true);
        });
        demute.setVisible(false);
        demute.addActionListener(e -> {
            gv.demuteEnemies();
            wave.setMute(false);
        });

        setLayout(new GridLayout(2, 3));
        setBorder(new EmptyBorder(0, 10, 0, 10));

        add(wave.getScore());
        add(wave.getMoneyPlayer());
        add(wave.getEnemiesLeft());
        add(wave.getCptWave());
        add(wave.getChrono());
        add(buttonPanel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.drawRect(230, 50, 500, 20); // affiche la barre de vie du joueur
        g.fillRect(230, 50, wave.getPlayer().getHP() * 500 / 1000, 20);

        nextWave.setEnabled(wave.getNbEnemies() <= 0 && wave.getCurrentWave() < wave.getNbWaves());
        if(wave.getMute()){
            mute.setVisible(false);
            demute.setVisible(true);
        } else {
            mute.setVisible(true);
            demute.setVisible(false);
        }
    }    
    
}
