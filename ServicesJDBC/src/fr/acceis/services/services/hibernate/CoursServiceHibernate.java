package fr.acceis.services.services.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import fr.acceis.services.model.Cours;
import fr.acceis.services.model.Creneau;
import fr.acceis.services.model.Salle;
import fr.acceis.services.services.ICoursService;

public class CoursServiceHibernate implements ICoursService {

	public Cours chercherParId(long idCours) {
		Session session = HibernateUtil.getSession();
		return session.load(Cours.class, idCours);		
	}
	
	public List<Cours> listerParSalle(String nomSalle){
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Salle> query = criteriaBuilder.createQuery(Salle.class);
		Root<Salle> root = query.from(Salle.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("nom"), nomSalle));
		Salle salle = session.createQuery(query).uniqueResult();
		List<Cours> listeCours =new ArrayList<Cours>();
		for(Creneau it : salle.getCreneaux()) {
			listeCours.add(it.getCours());
		}
		return listeCours;		
	}
}
