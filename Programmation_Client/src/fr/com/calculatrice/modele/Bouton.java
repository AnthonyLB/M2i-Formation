package fr.com.calculatrice.modele;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Bouton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calculatrice calculatrice;
	
	public Bouton(Calculatrice c, String label) {
		this.calculatrice = c;
		Font police = new Font("Arial", Font.BOLD, 15);
		this.setFont(police);
		this.setText(label);
		addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execute();
			}
			
		});
	}
	
	public abstract void execute();

	public Calculatrice getCalculatrice() {
		return calculatrice;
	}

	public void setCalculatrice(Calculatrice calculatrice) {
		this.calculatrice = calculatrice;
	}
	
}
