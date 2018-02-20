package com.softeam.formation.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.softeam.formation.hibernate.metier.modele.MetierSuper;
import com.softeam.formation.hibernate.metier.modele.Reunion;

import java.util.List;

public class Exercice10 {

	public static void main(String[] args) {
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = entityFactory.createEntityManager();
		
		String queryString ="select c from Reunion c where c.titre = 'RH'";
		Query query = manager.createQuery(queryString);
		List<Reunion> listeResultat = query.getResultList();
		
		Print<Reunion> affiche = new Print<Reunion>();
		affiche.afficherResultat(listeResultat);
		
		manager.close();
		entityFactory.close();
		
	}
	
	public static class Print<T extends MetierSuper>{ 
		public void afficherResultat( List<T> listeResultat) {
			if(listeResultat != null) {
				for(T it: listeResultat) {
					System.out.println(it.toString());
				}
			}else System.out.println("Résultat vide");
		}
	}
}
