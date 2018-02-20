package fr.com.calculatrice.modele;

import javax.swing.JLabel;

public class BoutonRacine extends Bouton{

	public BoutonRacine(Calculatrice c, String label) {
		super(c, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice calc = super.getCalculatrice();
		JLabel lab = calc.getAffichage();

		double value2 = Double.parseDouble( lab.getText() == "" ? String.valueOf(0) : lab.getText());
		lab.setText(String.valueOf(Math.sqrt(value2)));
		calc.setRazNombre(true);
	}

}
