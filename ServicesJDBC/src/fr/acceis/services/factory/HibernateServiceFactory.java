package fr.acceis.services.factory;

import fr.acceis.services.services.ICoursService;
import fr.acceis.services.services.ICursusService;
import fr.acceis.services.services.IEtudiantService;
import fr.acceis.services.services.IMatiereService;
import fr.acceis.services.services.IProfesseurService;
import fr.acceis.services.services.ISalleService;
import fr.acceis.services.services.hibernate.CoursServiceHibernate;
import fr.acceis.services.services.hibernate.CursusServiceHibernate;
import fr.acceis.services.services.hibernate.EtudiantServiceHibernate;
import fr.acceis.services.services.hibernate.MatiereServiceHibernate;
import fr.acceis.services.services.hibernate.ProfesseurServiceHibernate;
import fr.acceis.services.services.hibernate.SalleServiceHibernate;

public class HibernateServiceFactory extends AbstractServiceFactory {

	@Override
	public IEtudiantService getEtudiantService() {
		// TODO Auto-generated method stub
		return new EtudiantServiceHibernate();
	}

	@Override
	public ICoursService getCourService() {
		// TODO Auto-generated method stub
		return new CoursServiceHibernate();
	}

	@Override
	public ICursusService getCursusService() {
		// TODO Auto-generated method stub
		return new CursusServiceHibernate();
	}

	@Override
	public IProfesseurService getProfesseurService() {
		// TODO Auto-generated method stub
		return new ProfesseurServiceHibernate();
	}

	@Override
	public IMatiereService getMatiereService() {
		// TODO Auto-generated method stub
		return new MatiereServiceHibernate();
	}

	@Override
	public ISalleService getSalleService() {
		// TODO Auto-generated method stub
		return new SalleServiceHibernate();
	}

}
