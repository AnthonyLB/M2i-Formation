package com.softeam.formation.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.softeam.formation.hibernate.metier.modele.Adresse;

public class Exercice02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
				
		Adresse adresse = new Adresse();
		adresse.setCodePostal("35000");
		adresse.setLigne1("BOBY MACFISH");
		adresse.setLigne2("");
		adresse.setLigne3("");
		adresse.setVille("RENNES");
		
		tx.begin();
		
		entity.persist(adresse);
		
		tx.commit();
	}

}
