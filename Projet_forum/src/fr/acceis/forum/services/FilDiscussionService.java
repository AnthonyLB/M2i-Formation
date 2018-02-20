package fr.acceis.forum.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.acceis.forum.model.FilDiscussion;

public class FilDiscussionService {
	
	public List<FilDiscussion> getDiscussions(){
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<FilDiscussion> query = criteriaBuilder.createQuery(FilDiscussion.class);
		Root<FilDiscussion> root = query.from(FilDiscussion.class);
		query.select(root);
		List<FilDiscussion> discussions = session.createQuery(query).getResultList();
		return discussions;		
	}
	
	public void ajouterDiscussion(FilDiscussion discussion) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(discussion);
		tx.commit();
	}
	
	public FilDiscussion getById(long idFil) {
		Session session = HibernateUtil.getSession();
		return session.load(FilDiscussion.class, idFil);		
	}
	public void update(FilDiscussion discussion) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(discussion);
		tx.commit();
	}
}
