package fr.acceis.forum.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.acceis.forum.model.Post;
import fr.acceis.forum.model.Utilisateur;

public class UtilisateurService {

	public boolean isAuthentificationOk(String login, String pwd) {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> query = criteriaBuilder.createQuery(Utilisateur.class);
		Root<Utilisateur> root = query.from(Utilisateur.class);
		
		Predicate restrictionUsr = criteriaBuilder.and( criteriaBuilder.equal(root.get("login"),login),
				criteriaBuilder.equal(root.get("password"), pwd));
		query.where(restrictionUsr);
		
		List<Utilisateur> users = session.createQuery(query).getResultList();
		return users.size() == 1;
	}
	
	public void ajouterUtilisateur(Utilisateur user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}
}
