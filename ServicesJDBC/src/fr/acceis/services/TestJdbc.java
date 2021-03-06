package fr.acceis.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.acceis.services.factory.AbstractServiceFactory;
import fr.acceis.services.factory.HibernateServiceFactory;
import fr.acceis.services.model.Cours;
import fr.acceis.services.model.Cursus;
import fr.acceis.services.model.Etudiant;
import fr.acceis.services.model.Matiere;
import fr.acceis.services.model.Professeur;
import fr.acceis.services.model.Salle;
import fr.acceis.services.services.CoursService;
import fr.acceis.services.services.CursusService;
import fr.acceis.services.services.EtudiantService;
import fr.acceis.services.services.ICoursService;
import fr.acceis.services.services.ICursusService;
import fr.acceis.services.services.IEtudiantService;
import fr.acceis.services.services.IMatiereService;
import fr.acceis.services.services.IProfesseurService;
import fr.acceis.services.services.ISalleService;
import fr.acceis.services.services.MatiereService;
import fr.acceis.services.services.ProfesseurService;
import fr.acceis.services.services.SalleService;
import fr.acceis.services.services.hibernate.CoursServiceHibernate;
import fr.acceis.services.services.hibernate.CursusServiceHibernate;
import fr.acceis.services.services.hibernate.EtudiantServiceHibernate;
import fr.acceis.services.services.hibernate.ProfesseurServiceHibernate;
import fr.acceis.services.services.hibernate.SalleServiceHibernate;

public class TestJdbc {
	
	static AbstractServiceFactory serviceFactory = new HibernateServiceFactory();
	static IEtudiantService etudiantService = serviceFactory.getEtudiantService();
	static ICoursService coursService = serviceFactory.getCourService();
	static ICursusService cursusService = serviceFactory.getCursusService();
	static IProfesseurService professeurService= serviceFactory.getProfesseurService();
	static IMatiereService matiereService = serviceFactory.getMatiereService();
	static ISalleService salleService = serviceFactory.getSalleService();
	
	public static void main(String[] args) throws Exception {
		
		listerEtudiants();
		listerProfesseurs();
		listerSalles();
		cursusEtudiant("21002127");
		salleCours(67);
		listerCoursSalle("i57");
		listerEtudiantsCours(67);
		listerProfesseursCursus(10);
		listerProfesseursMatiere(2);
		listerProfsEtudiant("21002127");
		//		emploiDuTempsSalle("i52");
		//		emploiDuTempsEtudiant("21002128");
		//		emploiDuTempsProfesseur(55);
	}

	//	Liste les étudiants
	private static void listerEtudiants() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//Jdbc
//		List<Etudiant> listeEtudiants = new EtudiantService().lister();

		List<Etudiant> listeEtudiants = etudiantService.lister();
		
		System.out.println("* Liste des étudiants :");
		for (Etudiant etudiant : listeEtudiants) {
			String prenom = etudiant.getPrenom();
			String nom = etudiant.getNom();
			String numeroEtudiant = etudiant.getNumeroEtudiant();
			System.out.println(prenom + " " + nom + " (" + numeroEtudiant + ")");
		}

		System.out.println("* Fin de la liste des étudiants :");
		System.out.println();
	}

	//	Liste les professeurs
	private static void listerProfesseurs() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		List<Professeur> listeProfesseurs = new ProfesseurService().lister();
		List<Professeur> listeProfesseurs = professeurService.lister();

		System.out.println("* Liste des professeurs :");
		for (Professeur professeur : listeProfesseurs) {
			String prenom = professeur.getPrenom();
			String nom = professeur.getNom();
			System.out.println("Pr. " + prenom + " " + nom);
		}
		System.out.println("* Fin de la liste des professeurs :");
		System.out.println();

	}

	//	Liste les salles
	private static void listerSalles() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		List<Salle> listeSalles = new SalleService().lister();
		List<Salle> listeSalles = salleService.lister();
		
		System.out.println("* Liste des salles :");
		for (Salle salle : listeSalles) {
			String nom = salle.getNom();
			System.out.println("Salle " + nom);
		}
		System.out.println("* Fin de la liste des salles :");
		System.out.println();
	}

	//	Affiche le nom du cursus d'un étudiant
	private static void cursusEtudiant(String numeroEtudiant) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
//		IEtudiant etudiant = new EtudiantService().chercherParNumeroEtudiant(numeroEtudiant);
		Etudiant etudiant = etudiantService.chercherParNumeroEtudiant(numeroEtudiant);
		if (etudiant != null) {
			String nomCursus = etudiant.getCursus().getNom();
			String prenomEtudiant = etudiant.getPrenom();
			String nomEtudiant = etudiant.getNom();
			String numero = etudiant.getNumeroEtudiant();
			System.out.println(prenomEtudiant + " " + nomEtudiant + " (" + numero + ") est inscrit dans le cursus " +nomCursus);
		}
		System.out.println();

	}

	//	Affiche le nom de la salle dans laquelle a lieu un cours
	private static void salleCours(long idCours) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		ICours cours = new CoursService().chercherParId(idCours);
		Cours cours = coursService.chercherParId(idCours);

		if (cours != null) {
			String nom = cours.getCreneau().getSalle().getNom();
			System.out.println("Le cours " + idCours + " aura lieu en salle " + nom);
		}
		System.out.println();
	}

	//	Affiche le nom des cours ayant lieu dans une salle
	private static void listerCoursSalle(String nomSalle) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		List<Cours> listeCours = new CoursService().listerParSalle(nomSalle);
		List<Cours> listeCours = coursService.listerParSalle(nomSalle);
		
		SimpleDateFormat formater = new SimpleDateFormat("dd\\MM\\yyyy à HH:mm");
		System.out.println("* Les cours suivants ont lieu en salle " + nomSalle + " :\n");

		for (Cours cours : listeCours) {
			String nomMatiere = cours.getMatiere().getNom();
			String prenomProfesseur = cours.getProfesseurs().iterator().next().getPrenom();
			String nomProfesseur = cours.getProfesseurs().iterator().next().getNom();
			Date horaireDebut = cours.getCreneau().getHoraire().getDebut();
			Date horaireFin = cours.getCreneau().getHoraire().getFin();
			System.out.println("------------------------------");
			System.out.println("Cours de " + nomMatiere);
			System.out.println("Assuré par Pr. " + prenomProfesseur + " " + nomProfesseur);
			System.out.println("En salle " + nomSalle);
			System.out.println("Début : " + formater.format(horaireDebut));
			System.out.println("Fin : " + formater.format(horaireFin));
			System.out.println("------------------------------");
		}
		System.out.println("* Fin de la liste des cours");
		System.out.println();

	}





	//	Affiche le nom des étudiants qui assistent à un cours
	private static void listerEtudiantsCours(long idCours) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		List<Etudiant> etudiants = new EtudiantService().listerEtudiantsParIdCours(idCours);
		List<Etudiant> etudiants = etudiantService.listerEtudiantsParIdCours(idCours);
		
		System.out.println("* Les étudiants suivants assisteront au cours " + idCours + " :");
		for (Etudiant etudiant : etudiants) {
			String prenomEtudiant = etudiant.getPrenom();
			String nomEtudiant = etudiant.getNom();
			String numero = etudiant.getNumeroEtudiant();

			System.out.println(prenomEtudiant + " " + nomEtudiant + " (" + numero + ")");
		}
		System.out.println("* Fin de la liste des étudiants");
		System.out.println();
	}

	//	Affiche le nom des professeurss qui enseignent dans un cursus
	private static void listerProfesseursCursus(long idCursus) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		Cursus cursus = new CursusService().chercherParId(idCursus);
		Cursus cursus = cursusService.chercherParId(idCursus);
		Set<Professeur> professeurs = new HashSet<Professeur>();
		
		System.out.println("* Les professeurs suivants enseignent au sein du cursus " + cursus.getNom() + " :");
		for (Matiere matiere : cursus.getMatieres()) {
			for (Cours cours : matiere.getCours()) {
				professeurs.addAll(cours.getProfesseurs());
			}
		}

		for (Professeur professeur : professeurs) {
			String prenomProfesseur = professeur.getPrenom();
			String nomProfesseur = professeur.getNom();
			System.out.println("Pr. " + prenomProfesseur + " " + nomProfesseur);
		}

		System.out.println("* Fin de la liste des professeurs");
		System.out.println();
	}

	//	Affiche le nom des professeurs qui enseignent une matière
	private static void listerProfesseursMatiere(long idMatiere) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Matiere matiere = matiereService.chercherParId(idMatiere);

		String nomMatiere = matiere.getNom();
		System.out.println("* Les professeurs suivants enseignent la matière \"" + nomMatiere + "\" :");
		for (Cours cours : matiere.getCours()) {
			for (Professeur professeur : cours.getProfesseurs()) {
				String prenomProfesseur = professeur.getPrenom();
				String nomProfesseur = professeur.getNom();
				System.out.println("Pr. " + prenomProfesseur + " " + nomProfesseur);
			}
		}
		System.out.println("* Fin de la liste des professeurs");
		System.out.println();
	}

	//	Affiche des profs qui enseignent à un étudiant
	private static void listerProfsEtudiant(String numeroEtudiant) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Etudiant etudiant = etudiantService.chercherParNumeroEtudiant(numeroEtudiant);
		if (etudiant != null) {
			long idCursus = etudiant.getCursus().getId();
			Cursus cursus = new CursusService().chercherParId(idCursus);

			System.out.println("* Les professeurs suivants enseignent à l'étudiant " + etudiant.getPrenom() + " " + etudiant.getNom() + " :");
			for (Matiere matiere : cursus.getMatieres()) {
				for (Cours cours : matiere.getCours()) {
					for (Professeur professeur : cours.getProfesseurs()) {
						String prenomProfesseur = professeur.getPrenom();
						String nomProfesseur = professeur.getNom();
						System.out.println("Pr. " + prenomProfesseur + " " + nomProfesseur);
					}
				}
			}

			System.out.println("* Fin de la liste des professeurs");
			System.out.println();
		}
	}


	//	Affiche l'emploi du temps d'une salle
	private static void emploiDuTempsSalle(String nomSalle) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
		PreparedStatement stmt = connexion.prepareStatement(
				"SELECT matiere.nom as nomMatiere, professeur.nom as nomProfesseur, professeur.prenom as prenomProfesseur, salle.nom as nomSalle, horaire.debut as horaireDebut, horaire.fin as horaireFin FROM horaire "
						+ "INNER JOIN creneau "
						+ "ON creneau.horaire_id = horaire.id "
						+ "INNER JOIN salle "
						+ "ON salle.id = creneau.salle_id "
						+ "INNER JOIN cours "
						+ "ON cours.id = creneau.cours_id "
						+ "INNER JOIN matiere "
						+ "ON matiere.id = cours.matiere_id "
						+ "INNER JOIN cours_professeur "
						+ "ON cours_professeur.cours_id = cours.id "
						+ "INNER JOIN professeur "
						+ "ON professeur.id = cours_professeur.professeurs_id "
						+ "WHERE salle.nom=?"
				);
		stmt.setString(1, nomSalle);

		ResultSet result = stmt.executeQuery();

		SimpleDateFormat formater = new SimpleDateFormat("dd\\MM\\yyyy à HH:mm");
		System.out.println("Emploi du temps de la salle " + nomSalle + " :\n");

		while(result.next()){
			String nomMatiere = result.getString("nomMatiere");
			String prenomProfesseur = result.getString("prenomProfesseur");
			String nomProfesseur = result.getString("nomProfesseur");
			Time horaireDebut = result.getTime("horaireDebut");
			Time horaireFin = result.getTime("horaireFin");
			System.out.println("------------------------------");
			System.out.println("Cours de " + nomMatiere);
			System.out.println("Assuré par Pr. " + prenomProfesseur + " " + nomProfesseur);
			System.out.println("En salle " + nomSalle);
			System.out.println("Début : " + formater.format(horaireDebut));
			System.out.println("Fin : " + formater.format(horaireFin));
			System.out.println("------------------------------");
		}
		System.out.println("Fin de l'emploi du temps");
		System.out.println();

		connexion.close();
	}

	//	Affiche l'emploi du temps d'un étudiant
	private static void emploiDuTempsEtudiant(String numeroEtudiant) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");

		String prenomEtudiant = "";
		String nomEtudiant = "";

		PreparedStatement stmt = connexion.prepareStatement("SELECT nom, prenom, numeroEtudiant FROM etudiant WHERE numeroEtudiant=?");
		stmt.setString(1, numeroEtudiant);
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			nomEtudiant = result.getString("nom");
			prenomEtudiant = result.getString("prenom");
		}

		stmt = connexion.prepareStatement(
				"SELECT matiere.nom as nomMatiere, professeur.nom as nomProfesseur, professeur.prenom as prenomProfesseur, salle.nom as nomSalle, horaire.debut as horaireDebut, horaire.fin as horaireFin, salle.nom as nomSalle FROM horaire "
						+ "INNER JOIN creneau "
						+ "ON creneau.horaire_id = horaire.id "
						+ "INNER JOIN salle "
						+ "ON salle.id = creneau.salle_id "
						+ "INNER JOIN cours "
						+ "ON cours.id = creneau.cours_id "
						+ "INNER JOIN matiere "
						+ "ON matiere.id = cours.matiere_id "
						+ "INNER JOIN cours_professeur "
						+ "ON cours_professeur.cours_id = cours.id "
						+ "INNER JOIN professeur "
						+ "ON professeur.id = cours_professeur.professeurs_id "
						+ "INNER JOIN cursus_matiere "
						+ "ON cursus_matiere.matieres_id = matiere.id "
						+ "INNER JOIN cursus "
						+ "ON cursus.id = cursus_matiere.cursus_id "
						+ "INNER JOIN etudiant "
						+ "ON cursus.id = etudiant.cursus_id "
						+ "WHERE etudiant.numeroEtudiant=?"
				);
		stmt.setString(1, numeroEtudiant);

		result = stmt.executeQuery();

		SimpleDateFormat formater = new SimpleDateFormat("dd\\MM\\yyyy à HH:mm");
		System.out.println("Emploi du temps de l'étudiant " + prenomEtudiant + " " + nomEtudiant + " (" + numeroEtudiant + ") : \n");

		while(result.next()){
			String nomMatiere = result.getString("nomMatiere");
			String nomSalle = result.getString("nomSalle");
			String prenomProfesseur = result.getString("prenomProfesseur");
			String nomProfesseur = result.getString("nomProfesseur");
			Time horaireDebut = result.getTime("horaireDebut");
			Time horaireFin = result.getTime("horaireFin");
			System.out.println("------------------------------");
			System.out.println("Cours de " + nomMatiere);
			System.out.println("Assuré par Pr. " + prenomProfesseur + " " + nomProfesseur);
			System.out.println("En salle " + nomSalle);
			System.out.println("Début : " + formater.format(horaireDebut));
			System.out.println("Fin : " + formater.format(horaireFin));
			System.out.println("------------------------------");
		}

		System.out.println("Fin de l'emploi du temps");
		System.out.println();

		connexion.close();
	}

	//	Affiche l'emploi du temps d'un professeur
	private static void emploiDuTempsProfesseur(long idProfesseur) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");

		String prenomProfesseur = "";
		String nomProfesseur = "";

		PreparedStatement stmt = connexion.prepareStatement("SELECT nom, prenom FROM professeur WHERE id=?");
		stmt.setLong(1, idProfesseur);
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			nomProfesseur = result.getString("nom");
			prenomProfesseur = result.getString("prenom");
		}

		stmt = connexion.prepareStatement(
				"SELECT matiere.nom as nomMatiere, salle.nom as nomSalle, horaire.debut as horaireDebut, horaire.fin as horaireFin, salle.nom as nomSalle FROM horaire "
						+ "INNER JOIN creneau "
						+ "ON creneau.horaire_id = horaire.id "
						+ "INNER JOIN salle "
						+ "ON salle.id = creneau.salle_id "
						+ "INNER JOIN cours "
						+ "ON cours.id = creneau.cours_id "
						+ "INNER JOIN matiere "
						+ "ON matiere.id = cours.matiere_id "
						+ "INNER JOIN cours_professeur "
						+ "ON cours_professeur.cours_id = cours.id "
						+ "INNER JOIN professeur "
						+ "ON professeur.id = cours_professeur.professeurs_id "
						+ "WHERE professeur.id=?"
				);
		stmt.setLong(1, idProfesseur);

		result = stmt.executeQuery();

		SimpleDateFormat formater = new SimpleDateFormat("dd\\MM\\yyyy à HH:mm");
		System.out.println("Emploi du temps du Pr. " + prenomProfesseur + " " + nomProfesseur + ") : \n");

		while(result.next()){
			String nomMatiere = result.getString("nomMatiere");
			String nomSalle = result.getString("nomSalle");
			Time horaireDebut = result.getTime("horaireDebut");
			Time horaireFin = result.getTime("horaireFin");
			System.out.println("------------------------------");
			System.out.println("Cours de " + nomMatiere);
			System.out.println("En salle " + nomSalle);
			System.out.println("Début : " + formater.format(horaireDebut));
			System.out.println("Fin : " + formater.format(horaireFin));
			System.out.println("------------------------------");
		}

		System.out.println("Fin de l'emploi du temps");
		System.out.println();

		connexion.close();
	}

}
