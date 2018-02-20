package fr.acceis.services.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Cours")
public class Cours {

	@Id
	private long id;
	
	@ManyToOne
	private Matiere matiere;
	
	@OneToOne (mappedBy = "cours")
	private Creneau creneau;
	
	@ManyToMany
	@JoinTable(
			name="cours_professeur",
			joinColumns=@JoinColumn(name="cours_id"),
			inverseJoinColumns=@JoinColumn(name="professeurs_id")
	)
	private Collection<Professeur> professeurs;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#getMatiere()
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#setMatiere(fr.acceis.services.model.Matiere)
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#getProfesseurs()
	 */
	public Collection<Professeur> getProfesseurs() {
		return professeurs;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#setProfesseurs(java.util.Collection)
	 */
	public void setProfesseurs(Collection<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#getCreneau()
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICours#setCreneau(fr.acceis.services.model.Creneau)
	 */
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	
}
