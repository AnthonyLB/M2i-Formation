package com.softeam.formation.hibernate.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Personne;

public class IndividuDAO {

private EntityManagerFactory entityFactory;
	
	public IndividuDAO(EntityManagerFactory entityFactory) {
		this.entityFactory = entityFactory;
	}
	
	public int ajouter(Personne personne) {
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
						
		tx.begin();
		
		entity.persist(personne);
		
		tx.commit();
		entity.close();
		
		return (int) personne.getId();
	}
}
