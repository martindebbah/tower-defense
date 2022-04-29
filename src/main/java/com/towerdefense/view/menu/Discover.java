package com.towerdefense.view.menu;

import java.awt.Color;
import java.io.IOException;

import javax.swing.*;

public class Discover extends JFrame {
	private ImageIcon img ;
	private JLabel labelDisc ; 
	private JButton next ;
	
	public Discover() {
	
		img= new ImageIcon("src/main/resources/Images/DiscoverFinal/disco1.png");
		labelDisc=new JLabel(img);
		labelDisc.setSize(1464,780);

		next= new JButton("Next");
		next.setBackground(Color.RED); 
		next.setBounds(1350,650,70,50);
		labelDisc.add(next);
		next.addActionListener(e -> {
			this.dispose();
			new Step2( "src/main/resources/Images/DiscoverFinal/disco2.png" );
		});
		setTitle("You need help to discover the game?Here we go!");
		setSize(1464,780);
		add(labelDisc);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
	public class Step2 extends JFrame {
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step2(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			labelDisc.setSize(1500,1000);

			   
			    next= new JButton("Next");
			    next.setBackground(Color.RED); 
				next.setBounds(1350,650,70,50);
				labelDisc.add(next);
				next.addActionListener(e -> {
					this.dispose();
						new Step3( "src/main/resources/Images/DiscoverFinal/disco3.png" );
				});
				
				
			   setTitle("You need help to discover the game?Here we go!");
			   setSize(1500,1000);
			   add(labelDisc);
			   setLayout(null);
			   setLocationRelativeTo(null);
			   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   setVisible(true);
			
		}
		}
	public class Step3 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step3(String s ) {
			img= new ImageIcon(s);
			labelDisc=new JLabel(img);
			   labelDisc.setSize(1500,1000);
			   
			   next= new JButton("Next");
			    next.setBackground(Color.RED); 
				next.setBounds(1350,650,70,50);
				labelDisc.add(next);
				next.addActionListener(e ->{
						this.dispose();
						 new Step4( "src/main/resources/Images/DiscoverFinal/disco4.png" );
					      
				});
			   setSize(1500,1000);
			   add(labelDisc);
			   setLayout(null);
			   setLocationRelativeTo(null);
			   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   setVisible(true);
			
		}
		}
	
	
	
	public class Step4 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step4(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.RED); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step5( "src/main/resources/Images/DiscoverFinal/disco5.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	
	
	public class Step5 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step5(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,650,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step6( "src/main/resources/Images/DiscoverFinal/disco6.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	
	public class Step6 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step6(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step7( "src/main/resources/Images/DiscoverFinal/disco7.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	
	public class Step7 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step7(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step8( "src/main/resources/Images/DiscoverFinal/disco8.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	public class Step8 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step8(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step9( "src/main/resources/Images/DiscoverFinal/disco9.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	public class Step9 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step9(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
							 new Step10( "src/main/resources/Images/DiscoverFinal/disco10.png" );
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				   
				   
		}
	    }
	public class Step10 extends JFrame{
		private ImageIcon img ;
		private JLabel labelDisc ; 
		private JButton next ;
		
		public Step10(String s ) {
				   img= new ImageIcon(s);
				   labelDisc=new JLabel(img);
				   labelDisc.setSize(1500,1000);
				   
				    next= new JButton("Next");
				    next.setBackground(Color.BLUE); 
					next.setBounds(1350,700,70,50);
					labelDisc.add(next);
					next.addActionListener(e-> {
					 		 this.dispose();
						   	   
					} );
				   setSize(1500,1000);
				   add(labelDisc);
				   setLayout(null);
				   setLocationRelativeTo(null);
				   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				   setVisible(true);
				
		}
		}
	
	
	
	
	
 }
		
	


