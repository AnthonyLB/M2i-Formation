package fr.acceis.services.factory;

import fr.acceis.services.services.ICoursService;
import fr.acceis.services.services.ICursusService;
import fr.acceis.services.services.IEtudiantService;
import fr.acceis.services.services.IMatiereService;
import fr.acceis.services.services.IProfesseurService;
import fr.acceis.services.services.ISalleService;

public abstract class AbstractServiceFactory {
	public abstract IEtudiantService getEtudiantService();
	public abstract ICoursService getCourService();
	public abstract ICursusService getCursusService();
	public abstract IProfesseurService getProfesseurService();
	public abstract IMatiereService getMatiereService();
	public abstract ISalleService getSalleService();
}
