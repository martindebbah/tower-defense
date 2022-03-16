package com.towerdefense.view.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.towerdefense.view.Window;

public class NewGame extends JPanel {

	private JPanel buttons;
    
    public NewGame(Window window){
		setSize(1000, 1000);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0, 1));
		
		JButton hard = new JButton("Difficle");
		hard.addActionListener(e -> {
			window.play(); // Mode hard
		});
		
		JButton medium = new JButton("Intermédiaire");
		medium.addActionListener(e -> {
				window.play(); // Mode moyen
			});
		
		JButton easy = new JButton("Facile");
		easy.addActionListener(e -> {
			window.play(); // Mode facile
		});

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			window.setMenu();
		});
		
		JLabel label = new JLabel("Choisissez la difficulté");

		add(buttons);

		buttons.add(label);
		buttons.add(easy);
		buttons.add(medium);
		buttons.add(hard);
		buttons.add(back);
	}

}
