package Menu;
import javax.imageio.ImageIO ;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.ColorType;

import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.Graphics ;
import java.awt.Image ;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;



public class Accueil {
	private JFrame accueil ; 
	private ImageIcon img;
	private JLabel labelAcc ;
	private JButton start ;
	
	
	public  Accueil() {
		
	   img= new ImageIcon(this.getClass().getResource("/accueiltour.jpeg"));
	   labelAcc=new JLabel(img);
	   labelAcc.setSize(650,450);
	   JButton start=  new JButton("TAP TO START !");
	   start.setBackground(Color.GREEN); 
	   start.setBounds(240,250,200,50);
	   start.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   new MenuEssai();
			   
		   }
		   
	   }
			   
			   );
          
	   
	   labelAcc.add(start);
	   accueil= new JFrame("Bienvenue à TOWER-DEFENSE !");
	   accueil.setSize(650,450);
	   accueil.add(labelAcc);
	   accueil.setLayout(null);
	   accueil.setLocationRelativeTo(null);
	   accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   accueil.setVisible(true);
	  

	}
	
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new Accueil();
	}

}
