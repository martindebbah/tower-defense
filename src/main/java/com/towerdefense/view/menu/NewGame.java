package com.towerdefense.view.menu;

import java.awt.GridLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.towerdefense.level.Level;
import com.towerdefense.model.Player;
import com.towerdefense.view.Window;

public class NewGame extends JPanel {

	private JPanel buttons;
	private Window window;
	private ImageIcon background;
    
    public NewGame(Window w, String filename){
		//setSize(1000, 1000);
		super();
		this.background = new ImageIcon(filename);

		this.window = w;

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0, 1));
		
		JButton hard = new JButton("Difficle");
		hard.addActionListener(e -> {
			window.play(Level.DIFFICULT); // Mode hard
		});
		
		JButton infiny = new JButton("Mode Infini");
		infiny.addActionListener(e -> {
				window.play(Level.INFINY); // Mode moyen
			});
		
		JButton easy = new JButton("Facile");
		easy.addActionListener(e -> {
			window.play(Level.EASY); // Mode facile
		});

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			window.setMenu();
		});
		
		JLabel label = new JLabel("Choisissez la difficulté");

		add(buttons);

		buttons.add(label);
		buttons.add(easy);
		buttons.add(hard);
		buttons.add(infiny);
		buttons.add(back);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);

	}

}
