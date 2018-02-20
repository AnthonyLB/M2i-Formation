package fr.com.calculatriceScientifique.modele.copy;

import javax.swing.JLabel;

public class BoutonEffacer extends Bouton {

	public BoutonEffacer(Calculatrice c, String label) {
		super(c, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice calc = super.getCalculatrice();
		JLabel lab = calc.getAffichage();
		String newValue = lab.getText();
		if(newValue.length()>1) {
			lab.setText( newValue.substring(0, newValue.length() -1 ));
		}
	}

}
