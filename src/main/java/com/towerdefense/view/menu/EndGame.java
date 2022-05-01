package com.towerdefense.view.menu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import com.towerdefense.model.Player;
import com.towerdefense.view.Window;

public class EndGame extends JPanel{

    private JPanel buttons;
	private Window window;
	private NewPlayer player;
	private JPanel scorePanel;
    
    public EndGame(Window w, int status, Player p){
		setSize(1000, 1000);

		this.window = w;
		this.player = new NewPlayer(window, p, this);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,1));

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			window.setMenu();
		});
		
        JLabel label = new JLabel();

        if(status == 0){
            label = new JLabel("Vous avez gagné !");
        }
        if(status == 1){
            label = new JLabel("Vous avez perdu :(");
        }

		this.scorePanel = new JPanel();
		add(scorePanel);
		
		refreshScore(null);

		add(player);

		add(buttons);

		buttons.add(label);
		//buttons.add(hard);
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
    
}
