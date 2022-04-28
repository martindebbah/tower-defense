package com.towerdefense.view.menu;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;

import com.towerdefense.view.Window;

import javafx.scene.text.Font;

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

		JButton resumeGame = new JButton("Continuer");
		resumeGame.addActionListener(e -> {
			new ResumeGame();
		});

		JButton discover = new JButton("Découvrir");
		discover.addActionListener(e -> {
			new Discover();
		});

		JButton parametres = new JButton("Paramètres");
		parametres.addActionListener(e -> {
			window.setParametres();
		});

		buttons.add(newGame);
		buttons.add(resumeGame);
		buttons.add(discover);
		buttons.add(parametres);
	}

}
