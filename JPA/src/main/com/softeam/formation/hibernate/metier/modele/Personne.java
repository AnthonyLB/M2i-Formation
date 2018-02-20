package com.softeam.formation.hibernate.metier.modele;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Personne extends MetierSuper {

	@Id @GeneratedValue
	private int id;
	
	@Embedded
	private Identite identite;
	
	@ManyToMany(mappedBy="personnes")
	private Set<Reunion> reunions;
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	
	public Set<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(Set<Reunion> reunion) {
		this.reunions = reunion;
	}

	public String toString() {
		return "######## Personne : <nom> = " + identite.getNom() + ", <prenom> = " + identite.getPrenom();
	}
}
