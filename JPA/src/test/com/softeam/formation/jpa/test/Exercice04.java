package com.softeam.formation.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.dao.PersonneDAO;
import com.softeam.formation.hibernate.metier.modele.Identite;
import com.softeam.formation.hibernate.metier.modele.Personne;

public class Exercice04 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		PersonneDAO personneDAO = new PersonneDAO(entityFactory);
		
		Identite identite = new Identite();
		identite.setNom("McFish");
		identite.setPrenom("Bobby");
		Personne personne = new Personne();
		personne.setIdentite(identite);
		
		System.out.println(personne.toString());
		personneDAO.ajouter(personne);
		
		identite.setPrenom("Shirley");
		personne.setIdentite(identite);
		personneDAO.modifier(personne);
		System.out.println(personneDAO.lire((int) personne.getId()).toString());
		personneDAO.supprimer(personne);
		
		entityFactory.close();
		
	}
}
