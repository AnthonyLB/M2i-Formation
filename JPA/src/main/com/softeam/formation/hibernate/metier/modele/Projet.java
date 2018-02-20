package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJET")
public class Projet {

	@Id @GeneratedValue
	private Integer id;
	
	private String nom;
	
	// Hibernate a besoin d'un constructeur vide pour entity.find
	public Projet() {}
	
	public Projet(String nom) {
		this.nom=nom;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return ("########## Projet : <id> = " + this.id + " , <nom> = " + this.nom);
	}
}
