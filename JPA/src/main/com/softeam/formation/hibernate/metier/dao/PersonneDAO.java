package com.softeam.formation.hibernate.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.Personne;

public class PersonneDAO {

	private EntityManagerFactory entityFactory;
	
	public PersonneDAO(EntityManagerFactory entityFactory) {
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
	
	public Personne lire(int personneId) {
		EntityManager entity = entityFactory.createEntityManager();		
		return entity.find(Personne.class, personneId);
	}
	
	public void modifier(Personne personne) {
		EntityManager entity = entityFactory.createEntityManager();
		EntityTransaction tx = entity.getTransaction();		
		tx.begin();
		entity.merge(personne);
		tx.commit();
		entity.close();
	}
	
	public void supprimer(Personne personne) {
		EntityManager entity = entityFactory.createEntityManager();
		EntityTransaction tx = entity.getTransaction();		
		tx.begin();		
		entity.remove(entity.merge(personne));
		tx.commit();
		entity.close();
	}
}
