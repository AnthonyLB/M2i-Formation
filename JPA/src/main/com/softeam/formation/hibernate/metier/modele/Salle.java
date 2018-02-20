package com.softeam.formation.hibernate.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Salle {

	@Id	@GeneratedValue
	private Integer id;
	
	private String nom;
	private int nbPlaces;
	
	public Salle() {
	}
	
	public Salle(String nom, int nbPlaces) {
		this.nom = nom;
		this.nbPlaces= nbPlaces;
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
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	public String toString() {
		return ("########## Salle : <id> = " + this.id + " , <nom> = " + this.nom + " , <nbPlaces> = " + this.nbPlaces);
	}
}
