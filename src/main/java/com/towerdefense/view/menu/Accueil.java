package com.towerdefense.view.menu;

import javax.swing.*;

import com.towerdefense.view.Window;



public class Accueil extends JPanel {

	private JButton start;
	
	
	public  Accueil(Window window) {
		setSize(1000, 1000);

		JButton start =  new JButton("Lancer le jeu");
		start.addActionListener(e -> {
			window.setMenu();
		});
		add(start);
	}

}
