package fr.com.calculatrice.modele;

import javax.swing.JLabel;

public class BoutonNombre extends Bouton {

	private String label;
	
	public BoutonNombre(Calculatrice c, String label) {
		super(c, label);
		this.label = label;
	}

	@Override
	public void execute() {
		Calculatrice calc = super.getCalculatrice();
		if(calc.isRazNombre()) {			
			calc.getAffichage().setText(label);
			calc.setRazNombre(false);
		}else {
			JLabel lab = calc.getAffichage();
			String firstPart = lab.getText();
			String text = firstPart+label;
			if( text.startsWith("0") && !text.startsWith("0.")) {
				text = text.substring(1);
			}
			lab.setText(text);
		}
	}

}
