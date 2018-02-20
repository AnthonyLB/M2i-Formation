package com.softeam.formation.hibernate.metier.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.softeam.formation.hibernate.metier.modele.MetierSuper;

public class GeneralDAO<T extends MetierSuper> {
	
	private EntityManagerFactory entityFactory;
	private Class<T> genericClass;
	private EntityManager entity;
	private EntityTransaction tx;
	
	public GeneralDAO(EntityManagerFactory entityFactory, Class<T> genericClass) {
		this.entityFactory = entityFactory;
		this.genericClass = genericClass;
		this.entity = entityFactory.createEntityManager();
		this.tx = entity.getTransaction();
		this.tx.begin();
	}
	
	public int ajouter(T object) {
//		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
						
		tx.begin();
		
		entity.persist(object);
		
		tx.commit();
//		entity.close();
		
		return (object).getId();
	}
	
	public T lire(int objectId) {
//		EntityManager entity = entityFactory.createEntityManager();		
		return entity.find( genericClass , objectId);
	}
	
	public void modifier(T object) {
//		EntityManager entity = entityFactory.createEntityManager();
		EntityTransaction tx = entity.getTransaction();		
		tx.begin();
		entity.merge(object);
		tx.commit();
		entity.close();
	}
	
	public void supprimer(T object) {
		EntityManager entity = entityFactory.createEntityManager();
		EntityTransaction tx = entity.getTransaction();		
		tx.begin();		
		entity.remove(entity.merge(object));
		tx.commit();
		entity.close();
	}
	
	public T getReference(int id) {
//		EntityManager entity = entityFactory.createEntityManager();
		T object = entity.getReference(genericClass, id);
		entity.close();
		return object;
	}
	
	public void persist(T object) {
//		EntityManager entity = entityFactory.createEntityManager();
		entity.persist(object);
//		entity.close();
	}
	
	public void flush() {
//		EntityManager entity = entityFactory.createEntityManager();
//		entity.flush();
		tx.commit();
//		entity.close();
	}
	
	public void close() {
		entity.close();
		entityFactory.close();
	}
}
