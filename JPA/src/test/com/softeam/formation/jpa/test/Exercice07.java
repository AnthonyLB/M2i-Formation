package com.softeam.formation.jpa.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.dao.GeneralDAO;
import com.softeam.formation.hibernate.metier.modele.Personne;
import com.softeam.formation.hibernate.metier.modele.Reunion;

public class Exercice07 {

	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		Set<Personne> personnes = new HashSet<Personne>();
		Set<Reunion> reunions = new HashSet<Reunion>();
		
		Reunion reu1 = new Reunion();
		reu1.setTitre("Finance");
		Personne per1 = new Personne();
		
		personnes.add(per1);
		reunions.add(reu1);
		
		per1.setReunions(reunions);
		reu1.setPersonnes(personnes);
		
		GeneralDAO<Personne> personneDAO = new GeneralDAO<Personne>(entityFactory, Personne.class);
		GeneralDAO<Reunion> reunionDAO = new GeneralDAO<Reunion>(entityFactory, Reunion.class);
		
		personneDAO.ajouter(per1);
		reunionDAO.ajouter(reu1);
		
		entityFactory.close();
	}
}
