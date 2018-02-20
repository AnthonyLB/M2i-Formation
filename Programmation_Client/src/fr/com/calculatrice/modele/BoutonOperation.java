package fr.com.calculatrice.modele;

import javax.swing.JLabel;

public class BoutonOperation extends Bouton{

	IOperation operation;
	
	public BoutonOperation(Calculatrice c, String label, IOperation operation) {
		super(c, label);
		this.operation = operation;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice calc = super.getCalculatrice();
		JLabel lab = calc.getAffichage();
		if(!calc.isRazOperation()) {
			calc.setMemoire(Double.parseDouble(lab.getText()));
			calc.setOperation(operation);
			calc.setRazOperation(true);
			calc.setRazNombre(true);
		}else {
			double a = (calc.getMemoire());
			double b = Double.parseDouble(lab.getText());
			double resultat = calc.getOperation().calculer(a, b);
			calc.setMemoire(resultat);
			calc.setOperation(operation);
			lab.setText(String.valueOf(resultat));
			calc.setRazNombre(true);
		}
	}

}
