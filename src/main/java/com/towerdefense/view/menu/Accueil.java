package com.towerdefense.view.menu;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;

import com.towerdefense.view.Window;

public class Accueil extends JPanel {
	
	public Accueil(Window window) {
		setSize(1000, 1000);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setSize(100, 100); // A modifier

		JButton start =  new JButton("Lancer le jeu");
		start.addActionListener(e -> {
			window.setMenu();
		});
		panel.add(start);
	}

}
