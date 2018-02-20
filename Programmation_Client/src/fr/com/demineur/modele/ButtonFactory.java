package fr.com.demineur.modele;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public interface ButtonFactory {

	public static JButton createButton(int x, int y, int taille, Color color) {		
		JButton buton = new JButton();
		buton.setBounds(x, y, taille,taille);
		buton.setBackground(color);
		return buton;
	}
}
