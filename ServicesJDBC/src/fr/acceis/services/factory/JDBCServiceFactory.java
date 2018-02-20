package fr.acceis.services.factory;

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

public class JDBCServiceFactory extends AbstractServiceFactory {

	@Override
	public IEtudiantService getEtudiantService() {
		return new EtudiantService();
	}

	@Override
	public ICoursService getCourService() {
		// TODO Auto-generated method stub
		return new CoursService();
	}

	@Override
	public ICursusService getCursusService() {
		// TODO Auto-generated method stub
		return new CursusService();
	}

	@Override
	public IProfesseurService getProfesseurService() {
		// TODO Auto-generated method stub
		return new ProfesseurService();
	}

	@Override
	public IMatiereService getMatiereService() {
		// TODO Auto-generated method stub
		return new MatiereService();
	}

	@Override
	public ISalleService getSalleService() {
		// TODO Auto-generated method stub
		return new SalleService();
	}

}
