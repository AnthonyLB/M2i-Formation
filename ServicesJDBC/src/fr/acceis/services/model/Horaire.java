package fr.acceis.services.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Horaire{

	@Id
	private long id;

	private Date debut;
	
	private Date fin;
	
	@OneToMany(mappedBy="horaire")
	private Collection<Creneau> creneaux;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#getDebut()
	 */
	public Date getDebut() {
		return debut;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#setDebut(java.util.Date)
	 */
	public void setDebut(Date debut) {
		this.debut = debut;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#getFin()
	 */
	public Date getFin() {
		return fin;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#setFin(java.util.Date)
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#getCreneaux()
	 */
	public Collection<Creneau> getCreneaux() {
		return creneaux;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.IHoraire#setCreneaux(java.util.Collection)
	 */
	public void setCreneaux(Collection<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

}
