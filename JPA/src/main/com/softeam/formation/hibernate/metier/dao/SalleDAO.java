package com.softeam.formation.hibernate.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Salle;

public class SalleDAO {
	
	private EntityManagerFactory entityFactory;
	
	public SalleDAO(EntityManagerFactory entityFactory) {
		this.entityFactory = entityFactory;
	}
	
	public int ajouter(Salle salle) {
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
						
		tx.begin();
		
		entity.persist(salle);
		
		tx.commit();
		entity.close();
		
		return salle.getId();
	}
	
	public Salle lire(int salleId) {
		EntityManager entity = entityFactory.createEntityManager();
		return entity.find(Salle.class, salleId);
	}
}
