package com.softeam.formation.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.dao.GeneralDAO;
import com.softeam.formation.hibernate.metier.modele.Reunion;

public class Exercice09 {

	public static void main(String[] args) {
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		
		GeneralDAO<Reunion> reunionDAO = new GeneralDAO<Reunion>(entityFactory, Reunion.class);
		System.out.println("########### Initialisation");
		
		Reunion reunion = reunionDAO.lire(40);
		
		System.out.println("############ " + reunion.getTitre());
		reunionDAO.persist(reunion);
		
		reunion.setTitre("RH");
		System.out.println("############ " + reunion.toString());
		reunionDAO.flush();
		
		reunionDAO.close();
	}
}
