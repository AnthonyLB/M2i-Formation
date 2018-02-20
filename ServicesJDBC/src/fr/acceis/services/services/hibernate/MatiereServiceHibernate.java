package fr.acceis.services.services.hibernate;

import java.sql.SQLException;

import org.hibernate.Session;

import fr.acceis.services.model.Matiere;
import fr.acceis.services.services.IMatiereService;

public class MatiereServiceHibernate implements IMatiereService {

	public Matiere chercherParId(long idMatiere)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		return session.load(Matiere.class, idMatiere);
	}

}
