package fr.com.calculatriceScientifique.modele.copy;

import javax.swing.JLabel;

public class Calculatrice {
	
	private String touche;
	private double memoire;
	private JLabel affichage;	
	private JLabel affichageArriere;
	private boolean razOperation = false;
	private boolean razNombre = false;
	private boolean isRadian = false;
	private IOperation operation;
	
	public Calculatrice(JLabel affichage, JLabel affichageArriere) {
		this.affichage = affichage;
		this.affichageArriere = affichageArriere;
	}

	public String getTouche() {
		return touche;
	}

	public void setTouche(String touche) {
		this.touche = touche;
	}

	public double getMemoire() {
		return memoire;
	}

	public void setMemoire(double memoire) {
		this.memoire = memoire;
	}

	public JLabel getAffichage() {
		return affichage;
	}

	public void setAffichage(JLabel affichage) {
		this.affichage = affichage;
	}

	public boolean isRazOperation() {
		return razOperation;
	}

	public void setRazOperation(boolean raz) {
		this.razOperation = raz;
	}

	public boolean isRazNombre() {
		return razNombre;
	}

	public void setRazNombre(boolean razNombre) {
		this.razNombre = razNombre;
	}

	public IOperation getOperation() {
		return operation;
	}

	public void setOperation(IOperation operation) {
		this.operation = operation;
	}

	public JLabel getAffichageArriere() {
		return affichageArriere;
	}

	public void setAffichageArriere(JLabel affichageArriere) {
		this.affichageArriere = affichageArriere;
	}

	public boolean isRadian() {
		return isRadian;
	}

	public void setRadian(boolean isRadian) {
		this.isRadian = isRadian;
	}
	
}
