package com.towerdefense.view.menu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.towerdefense.model.Player;
import com.towerdefense.view.Window;

public class NewPlayer extends JPanel {

	private Player player;

	public NewPlayer(Window window, Player p, EndGame endGame) {
		setSize(1000, 1000);
		setOpaque(false);

		JLabel label = new JLabel("Entrez un nom d'utilisateur");

		JTextField name = new JTextField(20);
		name.addKeyListener(new KeyAdapter() {  // Empêche d'écrire le caractère délimiteur (':')
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ':')
					e.consume();
            }
        });

		this.player = p;

		JLabel error = new JLabel();
		error.setForeground(Color.RED);

		JButton start = new JButton("Enregistrer mon score");
		start.addActionListener(e -> {
			if (name.getText().isBlank()) {
				error.setText("Veuillez entrer un nom d'utilisateur");
			} else {
				player.setName(name.getText());
				endGame.remove(this);
				endGame.refreshScore(player);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.setSize(300, 200);
		panel.setOpaque(false);

		panel.add(label, gbc);
		panel.add(name, gbc);
		panel.add(start, gbc);
		panel.add(error, gbc);

		add(panel);
	}

}
