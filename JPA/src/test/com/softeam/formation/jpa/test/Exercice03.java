package com.softeam.formation.jpa.test;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.softeam.formation.hibernate.metier.dao.ProjetDAO;
import com.softeam.formation.hibernate.metier.dao.ReunionDAO;
import com.softeam.formation.hibernate.metier.dao.SalleDAO;
import com.softeam.formation.hibernate.metier.modele.Projet;
import com.softeam.formation.hibernate.metier.modele.Reunion;
import com.softeam.formation.hibernate.metier.modele.Salle;

public class Exercice03 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		
		//Creation de projet, salle et reunion;
		Projet projet1 = new Projet("Hibernate_pour_tous");
		Projet projet2 = new Projet("Angular_pour_personne");
		Salle salle1 = new Salle("Amphitheatre", 50);
		Salle salle2 = new Salle("Bureau_Director", 5);
		Reunion reunion1 = new Reunion("Finance", new Date(), new Date(), salle1, projet1);
		Reunion reunion2 = new Reunion("RH", new Date(), new Date(), salle2, projet2);
		
		ProjetDAO projetDAO = new ProjetDAO(entityFactory);
		SalleDAO salleDAO = new SalleDAO(entityFactory);		
		ReunionDAO reunionDAO = new ReunionDAO(entityFactory);
		
		projetDAO.ajouter(projet1);
		projetDAO.ajouter(projet2);
		salleDAO.ajouter(salle1);
		salleDAO.ajouter(salle2);
		reunionDAO.ajouter(reunion1);
		reunionDAO.ajouter(reunion2);
		
		System.out.println(projetDAO.lire(35).toString());
		System.out.println(salleDAO.lire(37).toString());
		System.out.println(reunionDAO.lire(39).toString());
		
		entityFactory.close();
	}
}
