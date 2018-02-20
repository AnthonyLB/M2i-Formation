package fr.acceis.forum.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.acceis.forum.model.FilDiscussion;
import fr.acceis.forum.model.Post;

public class PostService {
	
	public List<Post> getPosts(long idDiscussion){
		System.out.println("PostService : " + idDiscussion);
		Session session = HibernateUtil.getSession();
		FilDiscussion topic = session.load(FilDiscussion.class, idDiscussion);
		
		return topic.getPosts();		
	}
	
	public void ajouterPost(Post post) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(post);
		tx.commit();
	}
}
