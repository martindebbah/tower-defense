package com.towerdefense.view.menu;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
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
		try {
			BufferedImage image = ImageIO
					.read(new File(
							"/Users/dorian/Desktop/towerdef/tower-defense/src/main/resources/Images/towerDefense_tile024.png"));
			BufferedImage img = new BufferedImage(32, 32, image.getType());
			JLabel label = new JLabel(new ImageIcon(img));
			this.add(label);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		panel.add(start);
	}

}
