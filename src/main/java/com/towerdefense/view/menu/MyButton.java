package com.towerdefense.view.menu;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyButton extends JButton{
    
    public MyButton(String txt, String icon, String iconHover){
        super(txt);
        setForeground(Color.WHITE);

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);

        setIcon(new ImageIcon(icon));
        setRolloverIcon(new ImageIcon(iconHover));
    }
}
