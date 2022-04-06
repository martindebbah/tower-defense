package com.towerdefense.view.menu;

import java.lang.String.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;

import com.towerdefense.model.Player;
import com.towerdefense.view.Window;

public class NewPlayer extends JPanel {

	public NewPlayer(Window window) {
		setSize(1000, 1000);

		JLabel label = new JLabel("Entrez un nom d'utilisateur");

		JTextField name = new JTextField(20);

		Player player = new Player();

		JLabel error = new JLabel();
		error.setForeground(Color.RED);

		JButton start = new JButton("Continuer");
		start.addActionListener(e -> {
			if (name.getText().isEmpty()) {
				error.setText("Veuillez entrer un nom d'utilisateur");
			} else {
				player.setName(name.getText());
				window.setNewGame(player);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setSize(300, 200);

		panel.add(label);
		panel.add(name);
		panel.add(start);
		panel.add(error);

		add(panel);
	}

}
