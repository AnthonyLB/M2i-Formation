package fr.acceis.services.services.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import fr.acceis.services.model.Professeur;
import fr.acceis.services.model.Salle;
import fr.acceis.services.services.ISalleService;

public class SalleServiceHibernate implements ISalleService {

	public List<Salle> lister() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Salle> query = criteriaBuilder.createQuery(Salle.class);
		Root<Salle> root = query.from(Salle.class);
		query.select(root);
		List<Salle> salles = session.createQuery(query).getResultList();
		
		return salles;
	}
	
}
