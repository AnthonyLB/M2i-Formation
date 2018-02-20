package fr.acceis.services.services;

import java.sql.SQLException;
import java.util.List;

import fr.acceis.services.model.Salle;

public interface ISalleService {

	List<Salle> lister() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

}