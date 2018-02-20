package fr.acceis.services.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Salle")
public class Salle{

	@Id
	private long id;
	
	private String nom;
	
	@OneToMany(mappedBy="salle")
	private Collection<Creneau> creneaux;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Collection<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
}
