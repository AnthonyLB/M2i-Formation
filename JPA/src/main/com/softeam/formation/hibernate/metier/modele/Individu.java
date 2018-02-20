package com.softeam.formation.hibernate.metier.modele;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Individu extends MetierSuper {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy="individu")
	private Set<Coordonnee> coordonnees;

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Coordonnee> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnes(Set<Coordonnee> coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	
}
