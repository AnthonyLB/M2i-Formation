package fr.acceis.services.services.hibernate;

import org.hibernate.Session;

import fr.acceis.services.model.Cursus;
import fr.acceis.services.services.ICursusService;

public class CursusServiceHibernate implements ICursusService {
	
	public Cursus chercherParId(long idCursus) {
		Session session = HibernateUtil.getSession();
		Cursus cursus = session.load(Cursus.class, idCursus);				
		return cursus;
	}
}
