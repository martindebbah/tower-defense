package com.towerdefense.view.menu;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Graphics;

import com.towerdefense.view.Window;

public class Accueil extends JPanel {

	private ImageIcon background;

	public Accueil(Window window, String filename) {
		super();
		this.background = new ImageIcon(filename);
		setLayout(null);

		MyButton start = new MyButton("Cliquez pour jouer", null, null);
		start.addActionListener(e -> {
			window.setMenu();
		});
		start.setBounds(500,400,200,100);
		add(start);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);

	}

}
