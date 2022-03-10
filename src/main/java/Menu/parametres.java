package Menu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class parametres {
	private JFrame parametres ;
	private JLabel labelparametres ;
	private ImageIcon img;
	private JProgressBar soundBar ;
	private JProgressBar musicBar ;
	private static int minimum=0;
	private static int maximum=100 ;
	
	  public parametres() {	
	
    img= new ImageIcon(this.getClass().getResource("/accueil2.jpeg"));
	labelparametres=new JLabel(img);
	labelparametres.setSize(650,450);
	
	soundBar=new JProgressBar();
	soundBar.setMinimum(minimum);
	soundBar.setMaximum(maximum);
	labelparametres.add(soundBar) ;
	
	
	musicBar=new JProgressBar();
	musicBar.setMinimum(minimum);
	musicBar.setMaximum(maximum);
	labelparametres.add(musicBar);
	
	
	parametres=new JFrame("Settings");
	parametres.setSize(650,450);
	parametres.add(labelparametres);
	parametres.add(soundBar);
	parametres.setLayout(null);
    parametres.setLocationRelativeTo(null);
    parametres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    parametres.setVisible(true);

    }
}
