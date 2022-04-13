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
		
		 img= new ImageIcon("src/main/resources/images/discover/disc1.png");
		   labelDisc=new JLabel(img);
		   labelDisc.setSize(1464,1100);
		   
		   next= new JButton("Next");
		    next.setBackground(Color.BLUE); 
			next.setBounds(1350,700,70,50);
			labelDisc.add(next);
			next.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					 disco.dispose();
					 new Step2( "src/main/resources/images/discover/disc2.png" );
				   }	   
			}
					 );
		   disco= new JFrame("You need help to discover the game?Here we go!");
		   disco.setSize(1500,1500);
		   disco.add(labelDisc);
		   disco.setLayout(null);
		   disco.setLocationRelativeTo(null);
		   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   disco.setVisible(true);
		
	}
	
	
	
	public class Step2{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step2(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,950);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,700,70,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step3( "src/main/resources/images/discover/disc3.png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1500);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}
	public class Step3{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step3(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,1100);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,700,70,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step4( "src/main/resources/images/discover/disc4 .png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1500);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}
	
	
	
	public class Step4{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step4(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,802);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,700,70,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step5( "src/main/resources/images/discover/disc5.png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1000);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}
	
	public class Step5{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step5(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,1000);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,700,70,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step6( "src/main/resources/images/discover/disc6.png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1500);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}
	
	public class Step6{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step6(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,950);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,700,70,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step7( "src/main/resources/images/discover/disc7.png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1500);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}
	public class Step7{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JFrame disco ;
		private JButton next ;
		
		public Step7(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1464,1000);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.BLUE); 
				next.setBounds(1350,800,100,50);
				labelDisc.add(next);
				next.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent e) {
						 disco.dispose();
						 new Step8( "src/main/resources/images/discover/disc8.png" );
					   }	   
				}
						 );
			   disco= new JFrame("You need help to discover the game?Here we go!");
			   disco.setSize(1500,1500);
			   disco.add(labelDisc);
			   disco.setLayout(null);
			   disco.setLocationRelativeTo(null);
			   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   disco.setVisible(true);
			
		}
		}public class Step8{
			private ImageIcon img ;
			private JLabel labelDisc ; 
			private JFrame disco ;
			private JButton next ;
			
			public Step8(String s ) {
				img= new ImageIcon(s);
				labelDisc=new JLabel(img);
				   labelDisc.setSize(1464,1000);
				   
				   next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,850,100,50);
					labelDisc.add(next);
					next.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent e) {
							 disco.dispose();
							 new Step9( "src/main/resources/images/discover/disc9.png" );
						   }	   
					}
							 );
				   disco= new JFrame("You need help to discover the game?Here we go!");
				   disco.setSize(1500,1500);
				   disco.add(labelDisc);
				   disco.setLayout(null);
				   disco.setLocationRelativeTo(null);
				   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   disco.setVisible(true);
				
			}
			}
		public class Step9{
			private ImageIcon img ;
			private JLabel labelDisc ; 
			private JFrame disco ;
			private JButton next ;
			
			public Step9(String s ) {
				img= new ImageIcon(s);
				labelDisc=new JLabel(img);
				   labelDisc.setSize(1330,880);
				   
				   next= new JButton("Retour au menu principale");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1130,700,200,50);
					labelDisc.add(next);
					next.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent e) {
							 disco.dispose();
						   }	   
					}
							 );
				   disco= new JFrame("You need help to discover the game?Here we go!");
				   disco.setSize(1330,880);
				   disco.add(labelDisc);
				   disco.setLayout(null);
				   disco.setLocationRelativeTo(null);
				   disco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   disco.setVisible(true);
				
			}
			}
		
	}


