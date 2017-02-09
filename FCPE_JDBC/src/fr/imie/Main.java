package fr.imie;

import fr.imie.business.AcademicBusiness;
import fr.imie.business.IAcademicBusiness;
import fr.imie.persistence.AdministrateurDAO;
import fr.imie.persistence.ConnexionManagement;
import fr.imie.persistence.EtablissementDAO;
import fr.imie.persistence.IAdministrateurDAO;
import fr.imie.persistence.IConnexionManagement;
import fr.imie.persistence.IEtablissementDAO;
import presentation.IHM;

/**
 * @author imiedev
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IConnexionManagement connexionManagement = new ConnexionManagement();
		IEtablissementDAO etablissementDAO  = new EtablissementDAO(connexionManagement);
		IAdministrateurDAO administrateurDAO = new AdministrateurDAO(connexionManagement);
		IAcademicBusiness academicBusiness = new AcademicBusiness(etablissementDAO, administrateurDAO);
		IHM ihm = new IHM(academicBusiness);
		ihm.startEtablissement();
		

	}



}
