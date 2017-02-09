/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.model.AdministrateurDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public interface IAcademicBusiness {
	
	public abstract List<EtablissementDTO> listAllEtablissement();
	public abstract EtablissementDTO createEtablissement(EtablissementDTO etablissementDTO);
	public abstract void deleteEtablissement(EtablissementDTO etablissementDTOToDelete);
	public abstract EtablissementDTO updateEtablissement(EtablissementDTO etablissementDTOToUpdate);
	
	public abstract List<AdministrateurDTO> listAllAdministrateur();
	public abstract AdministrateurDTO createAdministrateur(AdministrateurDTO AdministrateurDTO);
	public abstract void deleteAdministrateur(AdministrateurDTO AdministrateurDTOToDelete);
	public abstract AdministrateurDTO updateAdministrateur(AdministrateurDTO AdministrateurDTOToUpdate);

}
