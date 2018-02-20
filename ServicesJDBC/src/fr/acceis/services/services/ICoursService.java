package fr.acceis.services.services;

import java.sql.SQLException;
import java.util.List;

import fr.acceis.services.model.Cours;

public interface ICoursService {

	/* (non-Javadoc)
	 * @see fr.acceis.services.services.IEtudiantService#chercherParId(long)
	 */
	Cours chercherParId(long idCours)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	/* (non-Javadoc)
	 * @see fr.acceis.services.services.IEtudiantService#listerParSalle(java.lang.String)
	 */
	List<Cours> listerParSalle(String nomSalle)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

}