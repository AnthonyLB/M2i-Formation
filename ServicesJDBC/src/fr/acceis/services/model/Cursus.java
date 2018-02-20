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
@Table(name = "Cursus")
public class Cursus{

	private String nom;
	
	@ManyToMany 
	@JoinTable(
			name="cursus_matiere",
			joinColumns=@JoinColumn(name="cursus_id"),
			inverseJoinColumns=@JoinColumn(name="matieres_id")
	)
	private Collection<Matiere> matieres;
	
	@OneToMany(mappedBy="cursus")
	private Collection<Etudiant> etudiants;
	
	@Id
	private long id;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#getMatieres()
	 */
	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#setMatieres(java.util.Collection)
	 */
	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#getNom()
	 */
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#setNom(java.lang.String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#getEtudiants()
	 */
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICursus#setEtudiants(java.util.Collection)
	 */
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
}
