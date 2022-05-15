package com.towerdefense.view.menu;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.towerdefense.view.Window;

public class Parametres extends JPanel { //implements Music, Sound {
	
	private JPanel panel;
	private boolean musicCut;
	private JButton cutMusic;

	private ImageIcon background;
	
	public Parametres(Window window, SoundManager s, String filename) {	
		setSize(1000, 1000);
		setLayout(new GridBagLayout());

		this.background = new ImageIcon(filename);

		this.musicCut = !s.isRunning();
		this.cutMusic = new JButton();
		cutMusic.addActionListener(e -> {
			//s.stop();
			if (!musicCut) { // Le bouton coupe la musique
				s.stop();
			}else { // Le bouton remet la musique
				s.play(2);
			}
			musicCut = !musicCut;
			setButtonsText();
		});

		setButtonsText();

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setOpaque(false);
		panel.add(cutMusic);

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			window.setMenu();
		});;
		panel.add(back);

		add(panel, new GridBagConstraints());
	}

	public void setButtonsText() {
		if (musicCut) {
			cutMusic.setText("Activer la musique");
		}else {
			cutMusic.setText("Désactiver la musique");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);
	}

}

