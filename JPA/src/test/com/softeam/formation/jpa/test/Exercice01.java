package com.softeam.formation.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger(Exercice01.class);
		
		logger.info("Creation des <EntityManager> et <EntityManager>");
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager entity = entityFactory.createEntityManager();		
		EntityTransaction tx = entity.getTransaction();
		
		logger.info("Debut de la transaction et creation de la requete");
		tx.begin();		
		
		// code a exécuter dans la transaction, comme createNativeQuery
		Query q = entity.createNativeQuery("INSERT INTO test VALUES('Une_ecoutille_souvre')");
		q.executeUpdate();

		tx.commit();		   
	}

}
