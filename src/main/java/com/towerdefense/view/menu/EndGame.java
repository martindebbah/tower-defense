package com.towerdefense.view.menu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import com.towerdefense.view.Window;

public class EndGame extends JPanel{

    private JPanel buttons;
	private Window window;
    
    public EndGame(Window w, int status){
		setSize(1000, 1000);

		this.window = w;

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,1));
		
		/*JButton hard = new JButton("Difficle");
		hard.addActionListener(e -> {
			window.play(); // Mode hard
		});*/

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

		add(buttons);

		buttons.add(label);
		//buttons.add(hard);
		buttons.add(back);
	}
    
}
