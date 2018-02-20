package fr.acceis.services.services.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import fr.acceis.services.model.Cours;
import fr.acceis.services.model.Cursus;
import fr.acceis.services.model.Etudiant;
import fr.acceis.services.model.Matiere;
import fr.acceis.services.services.IEtudiantService;

public class EtudiantServiceHibernate implements IEtudiantService{

	public List<Etudiant> lister() {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Etudiant> query = criteriaBuilder.createQuery(Etudiant.class);
		Root<Etudiant> root = query.from(Etudiant.class);
		query.select(root);
		List<Etudiant> etudiants = session.createQuery(query).getResultList();
		
		return etudiants;
	}
	
	public Etudiant chercherParNumeroEtudiant(String numeroEtudiant) {
		Session session = HibernateUtil.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		return session.load(Etudiant.class, numeroEtudiant);
	}
	
	public List<Etudiant> listerEtudiantsParIdCours(long idCours){
		Session session = HibernateUtil.getSession();
		Cours cours = session.load(Cours.class, idCours);
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		Matiere matiere = cours.getMatiere();
		Collection<Cursus> cursus = matiere.getCursus();
		for(Cursus it: cursus) {
			for(Etudiant itEtudiant: it.getEtudiants()) {
				etudiants.add(itEtudiant);
			}
		}
		return etudiants;		
	}
}
