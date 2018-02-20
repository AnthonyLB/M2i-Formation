package fr.com.calculatrice.modele;

import javax.swing.JLabel;

public class BoutonVirgule extends Bouton {

	private String label;
	
	public BoutonVirgule(Calculatrice c, String label) {
		// TODO Auto-generated constructor stub
		super(c, label);
		this.label = label;		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice calc = super.getCalculatrice();
		
		JLabel lab = calc.getAffichage();
		if( ! lab.getText().contains(".")) {
			calc.getAffichage().setText(lab.getText() + label);
		}
	}

}
