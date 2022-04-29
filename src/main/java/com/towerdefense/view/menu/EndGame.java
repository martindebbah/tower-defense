package com.towerdefense.view.menu;

import javax.swing.ImageIcon;
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
	private SoundManager sound = new SoundManager();
	private ImageIcon background;
    
    public EndGame(Window w, int status, Player p){
		sound.play(status);
		setSize(1000, 1000);

		this.window = w;
		this.player = new NewPlayer(window, p);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,1));

		JButton back = new JButton("Retour");
		back.addActionListener(e -> {
			sound.stop();
			window.setMenu();
		});
		
        JLabel label = new JLabel();

        if(status == 0){
            label = new JLabel("Vous avez gagné !");
        }
        if(status == 1){
            label = new JLabel("Vous avez perdu :(");
        }

		add(player);

		add(buttons);

		buttons.add(label);
		buttons.add(back);
	}
    
}
