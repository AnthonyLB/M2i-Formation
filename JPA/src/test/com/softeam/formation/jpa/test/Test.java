package com.softeam.formation.jpa.test;

public class Test {
	
	public static class Adresse extends Localisation{
		private String ville;
		public String getVille() { return ville;}
	}
	
	public static class Localisation{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adresse a1 = new Adresse();
		Object l1 = new Adresse();
		
		a1.getVille();
		Adresse a2 = (Adresse) l1;
		a2.getVille();
	}
}
