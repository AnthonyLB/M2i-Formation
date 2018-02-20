package com.softeam.formation.hibernate.metier.modele;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REUNION")
public class Reunion extends MetierSuper{
	
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne @JoinColumn(name="SALLE_ID")
	private Salle salle;
	@ManyToOne @JoinColumn(name="PROJET_ID")
	private Projet projet;
	
	@ManyToMany
	@JoinTable(name="Filiation", joinColumns=@JoinColumn(name="reunion_id"),
			   inverseJoinColumns=@JoinColumn(name="personne_id"))
	private Set<Personne> personnes;
	
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	
	public Reunion() {}
	
	public Reunion(String titre, Date dateDebut, Date dateFin, Salle salle, Projet projet) {
		this.titre = titre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.salle = salle;
		this.projet = projet;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer reunionId) {
		this.id = reunionId;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}	
	
	public Set<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public String toString() {
		return (" ########## Reunion : <id> = " + this.id + " , <titre> = " + this.titre );
	}
}
