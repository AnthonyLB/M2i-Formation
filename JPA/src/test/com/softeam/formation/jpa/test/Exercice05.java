package com.softeam.formation.jpa.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.softeam.formation.hibernate.metier.dao.GeneralDAO;
import com.softeam.formation.hibernate.metier.modele.Coordonnee;
import com.softeam.formation.hibernate.metier.modele.Individu;

public class Exercice05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("hibernate");
		
		Individu individu1 = new Individu();
		Individu individu2 = new Individu();
		
		Set<Coordonnee> coord1 = new HashSet<Coordonnee>();
		
		coord1.add(new Coordonnee("0615489562","bla@gmail.com",individu1));
		coord1.add(new Coordonnee("0648152346", "bloblo@hotmail.com",individu1));
		
		individu1.setCoordonnes(coord1);		
//		individu2.setCoordonnes(coord1);
		
		GeneralDAO<Individu> individuDAO = new GeneralDAO<Individu>(entityFactory, Individu.class);
		GeneralDAO<Coordonnee> coordDAO = new GeneralDAO<Coordonnee>(entityFactory, Coordonnee.class);
		individuDAO.ajouter(individu1);
//		individuDAO.ajouter(individu2);
		
		Iterator<Coordonnee> it = coord1.iterator();
		while(it.hasNext()) {
			Coordonnee coordTemp = it.next();
			coordDAO.ajouter(coordTemp);
		}
		
		//Modification en ajoutant une adresse
		Coordonnee coordModif = new Coordonnee("061543245", "historic@pro.com", individu1);
		coord1.add(coordModif);
		coordDAO.ajouter(coordModif);
		
		//Modification d'une adresse d'une personne
		Coordonnee[] coordArray = new Coordonnee[3];
		coord1.toArray(coordArray);
		coordArray[0].setEmail("123456@gmail.com");
		coordDAO.modifier(coordArray[0]);
		
		//Supprimer une adresse d'une personne
		coordDAO.supprimer(coordArray[1]);
		
		entityFactory.close();
	}

}
