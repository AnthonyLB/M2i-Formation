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
@Table(name = "Matiere")
public class Matiere {
	
	@Id
	private long id;
	
	private String nom;
	
	@ManyToMany
	@JoinTable(
			name="cursus_matiere",
			joinColumns=@JoinColumn(name="matieres_id"),
			inverseJoinColumns=@JoinColumn(name="cursus_id")
	)
	private Collection<Cursus> cursus;
	
	@OneToMany(mappedBy = "matiere")
	private Collection<Cours> cours;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#getNom()
	 */
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#setNom(java.lang.String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#getCours()
	 */
	public Collection<Cours> getCours() {
		return cours;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#setCours(java.util.Collection)
	 */
	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#getCursus()
	 */
	public Collection<Cursus> getCursus() {
		return cursus;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IMatiere#setCursus(java.util.Collection)
	 */
	public void setCursus(Collection<Cursus> cursus) {
		this.cursus = cursus;
	}
	
}
