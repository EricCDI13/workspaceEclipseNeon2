/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.AdministrateurDTO;
import fr.imie.model.EtablissementDTO;
import fr.imie.persistence.IAdministrateurDAO;
import fr.imie.persistence.IEtablissementDAO;

/**
 * @author imiedev
 *
 */
public class AcademicBusiness implements IAcademicBusiness {

	private IEtablissementDAO etablissementDAO;
	private IAdministrateurDAO administrateurDAO;

	public AcademicBusiness(IEtablissementDAO etablissementDAO,IAdministrateurDAO iAdministrateurDAO) {
		super();
		this.etablissementDAO = etablissementDAO;
		this.administrateurDAO = iAdministrateurDAO;
	}

	/* (non-Javadoc)
	 * @see fr.imie.business.IBusiness#listAllEtablissement()
	 */
	@Override
	public List<EtablissementDTO> listAllEtablissement() {
		return etablissementDAO.listAllEtablissement();
	}

	@Override
	public EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO) {
		return etablissementDAO.createEtablissement(etablissementDTO);
	}

	@Override
	public void deleteEtablissement(EtablissementDTO etablissementDTOToDelete) {
		etablissementDAO.deleteEtablissement(etablissementDTOToDelete);
		
	}

	@Override
	public EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate) {
		return etablissementDAO.updateEtablissement(etablissementDTOToUpdate);
		
	}

	@Override
	public List<AdministrateurDTO> listAllAdministrateur() {
		return administrateurDAO.listAllAdministrateur();
	}

	@Override
	public AdministrateurDTO createAdministrateur(AdministrateurDTO AdministrateurDTO) {
		return administrateurDAO.createAdministrateur(AdministrateurDTO);
	}

	@Override
	public void deleteAdministrateur(AdministrateurDTO AdministrateurDTOToDelete) {
		administrateurDAO.deleteAdministrateur(AdministrateurDTOToDelete);
		
	}

	@Override
	public AdministrateurDTO updateAdministrateur(AdministrateurDTO AdministrateurDTOToUpdate) {
		return administrateurDAO.updateAdministrateur(AdministrateurDTOToUpdate);
		
	}
	
	
}
