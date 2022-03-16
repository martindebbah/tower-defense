package com.towerdefense.view.menu;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{
	
    private static final long serialVersionUID = 1L;
    private Image image;
     
    public ImagePanel(Image image){
        super();
        this.image = image;
    }
     /*
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    */


    public void paintComponent(Graphics g) {
        //Chargement de l"image de fond
        try {
            Image img = ImageIO.read(new File("src/main/resources/images/accueiltour.jpeg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Erreur image de fond : " + e.getMessage());
        }
    }
    /*
    public static JPanel setBackgroundImage(final JFrame frame, final File img) throws IOException {
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1;
            private BufferedImage buf = ImageIO.read(img);
     
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buf, 0, 0, null);
            }
        };
        frame.setContentPane(panel);
        return panel;
    }
*/
	
}
