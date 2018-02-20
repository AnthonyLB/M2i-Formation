package fr.com.calculatriceScientifique.modele.copy;

import javax.swing.JLabel;

public class BoutonEgal extends Bouton{

	public BoutonEgal(Calculatrice c, String label) {
		super(c, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice calc = super.getCalculatrice();
//		if(!calc.isRaz()) {
			JLabel lab = calc.getAffichage();

			double value1 = calc.getMemoire();
			double value2 = Double.parseDouble(lab.getText());
			lab.setText(String.valueOf(calc.getOperation().calculer(value1, value2)));
			calc.setRazNombre(true);
			calc.setRazOperation(false);
//			calc.setRaz(true);
//		}	
	}

}
