package com.towerdefense.view.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Graphics;

import com.towerdefense.view.Window;

public class Menu extends JPanel {

	private JPanel buttons;
	private ImageIcon background;

	public Menu(Window window, String filename) {
		this.background = new ImageIcon(filename);

		setLayout(new GridBagLayout());

		buttons = new JPanel();
		buttons.setSize(500, 500);
		add(buttons, new GridBagConstraints());
		buttons.setLayout(new GridLayout(0, 1));
		buttons.setOpaque(false);

		JButton newGame = new JButton("Nouvelle partie");
		newGame.addActionListener(e -> {
			window.setNewGame();
		});

		JButton discover = new JButton("Découvrir");
		discover.addActionListener(e -> {
			new Discover();
		});

		JButton highScore = new JButton("High Score");
		highScore.addActionListener(e -> {
			window.setHighScore();
		});

		JButton parametres = new JButton("Paramètres");
		parametres.addActionListener(e -> {
			window.setParametres();
		});

		buttons.add(newGame);
		buttons.add(discover);
		buttons.add(highScore);
		buttons.add(parametres);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);
	}
}
