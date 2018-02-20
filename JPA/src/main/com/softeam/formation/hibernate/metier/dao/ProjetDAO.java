package com.softeam.formation.hibernate.metier.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.softeam.formation.hibernate.metier.modele.Projet;

public class ProjetDAO {

	private EntityManagerFactory entityFactory;
	
	public ProjetDAO(EntityManagerFactory entityFactory) {
		this.entityFactory = entityFactory;
	}
	
	public int ajouter(Projet projet) {
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
						
		tx.begin();
		
		entity.persist(projet);
		
		tx.commit();
		entity.close();
		
		return projet.getId();
	}
	
	public Projet lire(int projectId) {
		EntityManager entity = entityFactory.createEntityManager();
		return entity.find(Projet.class, projectId);
	}
}
