package fr.acceis.services.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Creneau")
public class Creneau {

	@Id
	private long id;
	
	@ManyToOne
	private Salle salle;
	
	@ManyToOne
	private Horaire horaire;
	
	@OneToOne
	private Cours cours;

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#getSalle()
	 */
	public Salle getSalle() {
		return salle;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#setSalle(fr.acceis.services.model.Salle)
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#getHoraire()
	 */
	public Horaire getHoraire() {
		return horaire;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#setHoraire(fr.acceis.services.model.Horaire)
	 */
	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#getCours()
	 */
	public Cours getCours() {
		return cours;
	}

	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#setCours(fr.acceis.services.interfaces.ICours)
	 */
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	/* (non-Javadoc)
	 * @see fr.acceis.services.model.ICreneau#toString()
	 */
	public String toString() {
		String result = "En " + getSalle() + "\n";
		result += getHoraire();
		return result;
	}
	
}
