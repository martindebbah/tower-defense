package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class parametres implements Music , Sound {
	private JFrame parametres ;
	private JLabel labelparametres ;
	private ImageIcon img;
	private JButton sound ;
	private JButton music ;
	private JButton back ;
	//private JProgressBar soundBar ;
	//private JProgressBar musicBar ;
	private static int minimum=0;
	private static int maximum=100 ;
	
	  public parametres() {	
	
    img= new ImageIcon(this.getClass().getResource("/accueil2.jpeg"));
	labelparametres=new JLabel(img);
	labelparametres.setSize(650,450);
	
	sound= new JButton("SOUND");
    sound.setBackground(Color.BLUE); 
	sound.setBounds(200,150,100,50);
	labelparametres.add(sound);
	sound.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   //Définir muteSound dans l'interface Sound
			 //mutesound();
		   }	   
	}
			 );
	
	music= new JButton("MUSIC");
    music.setBackground(Color.BLUE); 
	music.setBounds(200,200,100,50);
	labelparametres.add(music);
	music.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   //Définir muteMusic dans l'interface Music
			 //muteMusic();
		   }	   
	}
			 );
	
	/*soundBar=new JProgressBar();
	soundBar.setMinimum(minimum);
	soundBar.setMaximum(maximum);
	labelparametres.add(soundBar) ;

	musicBar=new JProgressBar();
	musicBar.setMinimum(minimum);
	musicBar.setMaximum(maximum);
	labelparametres.add(musicBar);
	
	*/ 
	
	back= new JButton("Back");
    back.setBackground(Color.BLUE); 
	back.setBounds(60,300,80,40);
	labelparametres.add(back);
	back.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			 new MenuEssai();
		   }	   
	}
			 );
	parametres=new JFrame("Settings");
	parametres.setSize(650,450);
	parametres.add(labelparametres);

	parametres.setLayout(null);
    parametres.setLocationRelativeTo(null);
    parametres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    parametres.setVisible(true);
    
    
}
	  public static void main (String[] args) {
		  new parametres();
	  }
   
}

