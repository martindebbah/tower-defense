package com.towerdefense.view.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Discover {
	private ImageIcon img ;
	private JLabel labelDisc ; 
	private JFrame disco ;
	private JButton back ;
	
	public Discover(){
		
		 img= new ImageIcon("src/main/resources/images/accueil2.jpeg");
		   labelDisc=new JLabel(img);
		   labelDisc.setSize(650,450);
		   
		   back= new JButton("Back");
		    back.setBackground(Color.BLUE); 
			back.setBounds(60,300,80,40);
			labelDisc.add(back);
			back.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					 //new MenuEssai();
				   }	   
			}
					 );
		   disco= new JFrame("You need help to discover the game?Here we go!");
		   disco.setSize(650,450);
		   disco.add(labelDisc);
		   disco.setLayout(null);
		   disco.setLocationRelativeTo(null);
		   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   disco.setVisible(true);
		
	}

}
