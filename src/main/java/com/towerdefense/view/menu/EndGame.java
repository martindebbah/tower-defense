package com.towerdefense.view.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Graphics;

import com.towerdefense.model.Player;
import com.towerdefense.view.Window;

public class EndGame extends JPanel{

    private JPanel buttons;
	private Window window;
	private NewPlayer player;
	private JPanel scorePanel;
	private SoundManager sound = new SoundManager();
	private ImageIcon background;
    
    public EndGame(Window w, int status, Player p){
		super();
		if(status == 0){
			sound.play(0);
		} else {
			sound.play(1);
		}
		setSize(1000, 1000);

		this.window = w;
		this.player = new NewPlayer(window, p, this);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,1));

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			sound.stop();
			this.background = null;
			window.setMenu();
		});
		
        JLabel label = new JLabel();

        if(status == 0){
			this.background = null;
            label = new JLabel("Vous avez gagné !");
        }
        if(status == 1){
			this.background = new ImageIcon("src/main/resources/Images/defeat.png");
            label = new JLabel("Vous avez perdu :(");
        }

		this.scorePanel = new JPanel();
		add(scorePanel);
		
		refreshScore(null);

		add(player);

		add(buttons);

		buttons.add(label);
		buttons.add(back);
	}

	public void refreshScore(Player p) {
		scorePanel.removeAll();
		scorePanel.add(new HighScore(p, window));
		window.refresh();
	}

	// GridLayout :

	// Enregistrer score
	// Score 
	// Relancer
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background != null)g.drawImage(background.getImage(), 0, 0, 1200, 1000, this);

	}
}
