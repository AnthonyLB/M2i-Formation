package fr.com.calculatrice.modele;

public class BoutonClear extends Bouton{

	public BoutonClear(Calculatrice c, String label) {
		super(c, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.getCalculatrice().getAffichage().setText("0");
		super.getCalculatrice().setRazNombre(false);
		super.getCalculatrice().setRazOperation(false);
	}

	
}
