package fr.acceis.services.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Professeur")
public class Professeur{

	@Id
	private long id;

	private String nom;

	private String prenom;
	
	@ManyToMany
	@JoinTable(
			name="cours_professeur",
			joinColumns=@JoinColumn(name="professeurs_id"),
			inverseJoinColumns=@JoinColumn(name="cours_id")
	)
	private Collection<Cours> cours;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#getNom()
	 */
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#setNom(java.lang.String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#getPrenom()
	 */
	public String getPrenom() {
		return prenom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#setPrenom(java.lang.String)
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#getCours()
	 */
	public Collection<Cours> getCours() {
		return cours;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IProfesseur#setCours(java.util.Collection)
	 */
	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}
	
}
