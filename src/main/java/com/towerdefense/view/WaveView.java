package com.towerdefense.view;

import java.awt.Color;

import javax.swing.JPanel;

import com.towerdefense.model.Wave;

public class WaveView extends JPanel {

    private Wave wave = new Wave();

    public WaveView() {
        setPreferredSize(new java.awt.Dimension(1000, 112));
        wave.chrono();
        add(wave.getChrono());
        //setBackground(Color.GREEN);
    }
    
}
