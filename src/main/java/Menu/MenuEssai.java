package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuEssai {
	private JFrame menu ; 
	private ImageIcon img;
	private JLabel labelMenu ;
    private JButton player ;
    private JButton newGame ;
    private JButton resumeGame ;
    private JButton parametres ;
    private JButton discover ;
    
      public MenuEssai() {
		img= new ImageIcon(this.getClass().getResource("/accueil2.jpeg"));
		labelMenu=new JLabel(img);
		labelMenu.setSize(650,450);
		
		player=new JButton("Player");
		player.setBackground(Color.BLUE); 
		player.setBounds(500,200,100,50);
		labelMenu.add(player);
		player.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   new NewPlayer();
			   }	   
		}
				     );
		
		newGame=new JButton("New Game");
		newGame.setBackground(Color.BLUE); 
		newGame.setBounds(500,100,100,50);
		labelMenu.add(newGame);
		newGame.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   new newGame();
			   }	   
		}
				     );
		
		resumeGame=new JButton("Resume");
		resumeGame.setBackground(Color.BLUE); 
		resumeGame.setBounds(500,150,100,50);
		labelMenu.add(resumeGame);
		resumeGame.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   new resumeGame();
			   }	   
		}
				     );
		
		parametres=new JButton("Settings");
		parametres.setBackground(Color.BLUE); 
		parametres.setBounds(500,300,100,50);
		labelMenu.add(parametres);
		parametres.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   new parametres();
			   }	   
		}
				     );
		
		discover=new JButton("Discover");
		discover.setBackground(Color.BLUE); 
		discover.setBounds(500,250,100,50);
		labelMenu.add(discover);
		discover.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //Ici on mettra une description détaillée du jeu 
				   //Aider les nouveaux joueur à comprendre le concept : cahier des cahrges
				   new Discover();
			   }	   
		}
				     );
		
		menu=new JFrame("Menu");
		menu.setSize(650,450);
		menu.add(labelMenu);
		menu.setLayout(null);
	    menu.setLocationRelativeTo(null);
	    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    menu.setVisible(true);
		
		
		
	}
      public static void main(String[] args) {
    	  new MenuEssai();
      }

}
