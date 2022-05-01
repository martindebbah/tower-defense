package com.towerdefense.view.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.towerdefense.view.Window;

public class Parametres extends JPanel { //implements Music, Sound {
	
	private JPanel panel;
	private boolean soundCut = false;
	private boolean musicCut = false;
	
	public Parametres(Window window, SoundManager s) {	
		setSize(1000, 1000);
		setLayout(new GridLayout(0, 1));

		JSlider sound = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Valeur de base à définir
		sound.setMinorTickSpacing(10);
		sound.setPaintTicks(true);

		JSlider music = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Valeur de base à définir
		music.setMinorTickSpacing(10);
		music.setPaintTicks(true);
		
		JButton cutSound = new JButton("Couper le son");
		cutSound.addActionListener(e -> {
			soundCut = !soundCut;
		});

		JButton cutMusic = new JButton("Couper la musique");
		cutMusic.addActionListener(e -> {
			s.stop();
		});

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.add(cutSound);
		panel.add(sound);
		panel.add(cutMusic);
		panel.add(music);

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			window.setMenu();
		});

		JPanel buttons = new JPanel();
		buttons.add(back);

		add(panel);
		add(buttons);
	}	

}

