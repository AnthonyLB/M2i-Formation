package fr.com.demineur.modele;

import java.awt.Color;

import javax.swing.JLabel;

public interface LabelFactory {

	public static JLabel createLabel(int value, int x, int y, int taille) {

		String lab = value == 0 ? "" : String.valueOf(value);
		if(value<0) lab = "";
		JLabel label = new JLabel(lab);
		
		switch(value) {
		case 0: label.setForeground(Color.GRAY); break;
		case 1: label.setForeground(Color.BLUE); break;
		case 2: label.setForeground(Color.GREEN); break;
		case 3: label.setForeground(Color.RED); break;
		case 4: label.setForeground(Color.PINK); break;
		case 5: label.setForeground(Color.CYAN); break;
		}
		label.setBounds(x,y,taille,taille);
		
		return label;
	}
}
