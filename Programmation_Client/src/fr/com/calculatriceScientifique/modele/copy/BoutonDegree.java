package fr.com.calculatriceScientifique.modele.copy;

public class BoutonDegree extends Bouton {

	private String label;
	public BoutonDegree(Calculatrice c, String label) {
		super(c, label);
		this.label = label;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Calculatrice c = super.getCalculatrice();
		if(label == "deg") c.setRadian(false);
		else c.setRadian(true);
	}

}
