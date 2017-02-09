package fr.imie.persistence;

import java.util.List;

import fr.imie.model.AdministrateurDTO;

public interface IAdministrateurDAO {

	public abstract List<AdministrateurDTO> listAllAdministrateur();
	public abstract AdministrateurDTO createAdministrateur(AdministrateurDTO AdministrateurDTO);
	public abstract void deleteAdministrateur(AdministrateurDTO AdministrateurDTOToDelete);
	public abstract AdministrateurDTO updateAdministrateur(AdministrateurDTO AdministrateurDTOToUpdate);
	
}
