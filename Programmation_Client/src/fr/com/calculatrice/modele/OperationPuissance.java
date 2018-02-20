package fr.com.calculatrice.modele;

public class OperationPuissance implements IOperation {

	@Override
	public double calculer(double a, double b) {
		// TODO Auto-generated method stub
		return Math.pow(a, b);
	}

}
