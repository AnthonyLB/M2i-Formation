package com.softeam.formation.hibernate.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Reunion;

public class ReunionDAO {

	private EntityManagerFactory entityFactory;
	
	public ReunionDAO(EntityManagerFactory entityFactory) {
		this.entityFactory = entityFactory;
	}
	
	public int ajouter(Reunion reunion) {
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
						
		tx.begin();
		
		entity.persist(reunion);
		
		tx.commit();
		entity.close();
		
		return reunion.getId();
	}
	
	public Reunion lire(int reunionId) {
		EntityManager entity = entityFactory.createEntityManager();
		return entity.find(Reunion.class, reunionId);
	}
}
