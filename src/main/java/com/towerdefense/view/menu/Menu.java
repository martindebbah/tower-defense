package com.towerdefense.view.menu;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;

import com.towerdefense.view.Window;

public class Menu extends JPanel {
	
	private JPanel buttons;
    
    public Menu(Window window) {			 
		setSize(1000, 1000);
		
		buttons = new JPanel();
		buttons.setSize(1000, 1000);
		add(buttons);
		buttons.setLayout(new GridLayout(0, 1));
		
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

}
