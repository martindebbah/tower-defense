package Menu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewPlayer {
	private JFrame newplayer ; 
	private ImageIcon img;
	private JLabel labelplayer ;
	
	public NewPlayer() {
		 img= new ImageIcon(this.getClass().getResource("/Personnage.jpeg"));
		   labelplayer=new JLabel(img);
		   labelplayer.setSize(700,500);
		   
		   
		    newplayer= new JFrame("Become a warrior?");
		    newplayer.setSize(650,450);
			newplayer.add(labelplayer);
			newplayer.setLayout(null);
		    newplayer.setLocationRelativeTo(null);
		    newplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    newplayer.setVisible(true);
		
	}
	
	

	

}
