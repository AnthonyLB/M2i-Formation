package fr.acceis.services.services;

import java.sql.SQLException;
import java.util.List;

import fr.acceis.services.model.Professeur;

public interface IProfesseurService {

	List<Professeur> lister()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

}