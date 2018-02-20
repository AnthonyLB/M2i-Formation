package fr.com.calculatriceScientifique.modele.copy;

import javax.swing.JLabel;

public class BoutonFonction extends Bouton {

	private String labelIn;
	private IOperation operation;
	public BoutonFonction(Calculatrice c, String label, String labelIn, IOperation operation) {
		super(c, label);
		this.labelIn = labelIn;
		this.operation = operation;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice c = super.getCalculatrice();
		JLabel lab = c.getAffichage();
		String firstPart = lab.getText();
		String text = firstPart+ labelIn;
		if( text.startsWith("0") && !text.startsWith("0.")) {
			text = text.substring(1);
		}
		if(text.contains("..")) text.replace("..", ".");
		lab.setText(text);
	}
}
