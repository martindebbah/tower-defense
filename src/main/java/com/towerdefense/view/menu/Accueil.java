package com.towerdefense.view.menu;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import com.towerdefense.view.Window;

public class Accueil extends JPanel {

	private ImageIcon background;

	public Accueil(Window window, String filename) {
		super();
		this.background = new ImageIcon(filename);
		setLayout(new BorderLayout());

		MyButton start = new MyButton("Cliquez pour jouer", null, null);
		start.addActionListener(e -> {
			window.setMenu();
		});
		add(start);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, 1500, 1000, this);

	}

}
