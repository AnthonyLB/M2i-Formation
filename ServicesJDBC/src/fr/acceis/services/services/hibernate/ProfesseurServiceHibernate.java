package fr.acceis.services.services.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import fr.acceis.services.model.Professeur;
import fr.acceis.services.services.IProfesseurService;

public class ProfesseurServiceHibernate implements IProfesseurService {

	public List<Professeur> lister() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Professeur> query = criteriaBuilder.createQuery(Professeur.class);
		Root<Professeur> root = query.from(Professeur.class);
		query.select(root);
		List<Professeur> professeurs = session.createQuery(query).getResultList();
		
		return professeurs;
	}
}
