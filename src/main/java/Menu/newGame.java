package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.towerdefense.view.Window;

public class newGame {
	private JFrame newGame ; 
	private ImageIcon img;
	private JLabel labelnewGame;
    private JButton hard ;
    private JButton medium ;
    private JButton easy ;
    private JButton back ;
    
    public newGame(){
    	img= new ImageIcon(this.getClass().getResource("/accueil2.jpeg"));
		labelnewGame=new JLabel(img);
		labelnewGame.setSize(650,450);
		
		hard=new JButton("HARD");
		hard.setBackground(Color.BLUE); 
		hard.setBounds(260,150,100,50);
		labelnewGame.add(hard);
		hard.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   //hard game launch
				   //Pour le moment on va lancer window
				   new Window();
			   }	   
		}
				     );
		
		medium=new JButton("MEDIUM");
		medium.setBackground(Color.BLUE); 
		medium.setBounds(260,200,100,50);
		labelnewGame.add(medium);
		medium.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				  // medium game launch
				   new Window();
			   }	   
		}
				     );
		
		easy=new JButton("EASY");
		easy.setBackground(Color.BLUE); 
		easy.setBounds(260,250,100,50);
		labelnewGame.add(easy);
		easy.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				//easy game launch
				   new Window();
			   }	   
		}
				     );
		back= new JButton("Back");
		back.setBackground(Color.BLUE); 
	    back.setBounds(60,300,80,40);
		labelnewGame.add(back);
		back.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					 new MenuEssai();
				   }	   
			}
					 );
		
		newGame=new JFrame("New Game on , how hard do you want it to be?");
		newGame.setSize(650,450);
		newGame.add(labelnewGame);
		newGame.setLayout(null);
	    newGame.setLocationRelativeTo(null);
	    newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    newGame.setVisible(true);
	    
	    
    }

}
