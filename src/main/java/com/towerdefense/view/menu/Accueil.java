package com.towerdefense.view.menu;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import com.towerdefense.view.Window;

public class Accueil extends JPanel {

	public Accueil(Window window) {
		setSize(1000, 1000);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setSize(100, 100); // A modifier

		JButton start = new JButton("Lancer le jeu");
		start.addActionListener(e -> {
			window.setMenu();
		});

		panel.add(start);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			BufferedImage image = ImageIO
					.read(new File(
							"src/main/resources/Images/towerDefense_tile5000.png"));
			g.drawImage(image, 32, 32, null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
