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
	private JButton next ;
	
	public Discover(){
		
		 img= new ImageIcon("src/main/resources/images/disc1.png");
		   labelDisc=new JLabel(img);
		   labelDisc.setSize(700,530);
		   
		   next= new JButton("Back");
		    next.setBackground(Color.BLUE); 
			next.setBounds(60,300,80,40);
			labelDisc.add(next);
			next.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					 //new MenuEssai();
				   }	   
			}
					 );
		   disco= new JFrame("You need help to discover the game?Here we go!");
		   disco.setSize(1000,1000);
		   disco.add(labelDisc);
		   disco.setLayout(null);
		   disco.setLocationRelativeTo(null);
		   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   disco.setVisible(true);
		
	}

}
