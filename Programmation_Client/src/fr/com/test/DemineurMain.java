package fr.com.test;

import fr.com.demineur.modele.Demineur;

public class DemineurMain {

	public static void main(String[] args) {
		int largeur = 50;
		int hauteur = 30;
		int bombes = 10;
		new Demineur(largeur, hauteur, bombes);
		boolean a = true;
		boolean b = false;
		b &= a;
		System.out.println(b);
	}
}
