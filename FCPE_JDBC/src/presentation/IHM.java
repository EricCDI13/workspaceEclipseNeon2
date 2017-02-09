/**
 * 
 */
package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.imie.business.IAcademicBusiness;
import fr.imie.model.AdministrateurDTO;
import fr.imie.model.AdresseDTO;
import fr.imie.model.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class IHM {
	private IAcademicBusiness academicBusiness;
	private List<EtablissementDTO> etablissementDTOs = new ArrayList<>();
	private List<AdministrateurDTO> administrateurDTOs = new ArrayList<>();

	//

	public IHM(IAcademicBusiness academicBusiness) {
		super();
		this.academicBusiness = academicBusiness;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		do {

			System.out.format("------\n");
			System.out.format("|MENU|\n");
			System.out.format("------\n");
			System.out.format("1 - établissement\n");
			System.out.format("2 - aDministrateur\n");
			System.out.format("X - arrêter programme\n");

			String nextLine = scanner.nextLine();
			if (nextLine.equals("X")) {
				break;
			}
			Integer menuChoice = Integer.parseInt(nextLine);
			switch (menuChoice) {
			case 1:
				startEtablissement();
				break;
			case 2:
				startAdministrateur();
				break;
			default:
				break;
			}

		} while (true);
		scanner.close();

	}

	public void startEtablissement() {
		String inputString;
		Scanner scanner = new Scanner(System.in);
		do {

			System.out.format("------\n");
			System.out.format("|MENU|\n");
			System.out.format("------\n");
			System.out.format("1 - visualiser tous les etablissements\n");
			System.out.format("2 - créer un etablissements\n");
			System.out.format("3 - supprimer un etablissements\n");
			System.out.format("4 - modifier un etablissements\n");
			System.out.format("X - menu principal\n");
			String nextLine = scanner.nextLine();
			if (nextLine.equals("X")) {
				break;
			}
			Integer menuChoice = Integer.parseInt(nextLine);
			Integer dataChoice;
			switch (menuChoice) {
			case 1:
				displayAllEtablissement(academicBusiness);
				break;
			case 2:
				EtablissementDTO etablissementDTO = new EtablissementDTO();
				AdresseDTO adresseDTO = new AdresseDTO();
				etablissementDTO.setAdresse(adresseDTO);
				System.out.format("création d'un Etablissement\n");
				System.out.format("Nom:");
				inputString = scanner.nextLine();
				etablissementDTO.setNom(inputString);
				System.out.format("Numero de la rue:");
				inputString = scanner.nextLine();
				adresseDTO.setNumero(Integer.parseInt(inputString));
				System.out.format("Nom de la voie:");
				inputString = scanner.nextLine();
				adresseDTO.setNomVoie(inputString);
				System.out.format("Code Postal:");
				inputString = scanner.nextLine();
				adresseDTO.setCP(inputString);
				System.out.format("Ville:");
				inputString = scanner.nextLine();
				adresseDTO.setVille(inputString);
				EtablissementDTO newEtablissementDTO = academicBusiness.createEtablissement(etablissementDTO);
				System.out.format("id:%s | nom:%s | adresse:%s\n", newEtablissementDTO.getId(),
						newEtablissementDTO.getNom(), newEtablissementDTO.getAdresse().getMergedAdress());
				break;
			case 3:
				displayAllEtablissement(academicBusiness);
				System.out.format("Quel ligne voulez vous supprimer?:");
				dataChoice = Integer.parseInt(scanner.nextLine());
				EtablissementDTO etablissementDTOToDelete = etablissementDTOs.get(dataChoice - 1);
				academicBusiness.deleteEtablissement(etablissementDTOToDelete);
				break;
			case 4:
				displayAllEtablissement(academicBusiness);
				System.out.format("Quel ligne voulez vous modifier?:");
				dataChoice = Integer.parseInt(scanner.nextLine());
				EtablissementDTO etablissementDTOToUpdate = etablissementDTOs.get(dataChoice - 1);

				System.out.format("Nom [%s]:", etablissementDTOToUpdate.getNom());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					etablissementDTOToUpdate.setNom(inputString);
				}

				System.out.format("Numero de la rue  [%s]:", etablissementDTOToUpdate.getAdresse().getNumero());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					etablissementDTOToUpdate.getAdresse().setNumero(Integer.parseInt(inputString));
				}

				System.out.format("Nom de la voie [%s]:", etablissementDTOToUpdate.getAdresse().getNomVoie());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					etablissementDTOToUpdate.getAdresse().setNomVoie(inputString);
				}

				System.out.format("Code Postal [%s]:", etablissementDTOToUpdate.getAdresse().getCP());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					etablissementDTOToUpdate.getAdresse().setCP(inputString);
				}

				System.out.format("Ville [%s]:", etablissementDTOToUpdate.getAdresse().getVille());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					etablissementDTOToUpdate.getAdresse().setVille(inputString);
				}
				EtablissementDTO etablissementDTOUpdated = academicBusiness
						.updateEtablissement(etablissementDTOToUpdate);
				System.out.format("id:%s | nom:%s | adresse:%s\n", etablissementDTOUpdated.getId(),
						etablissementDTOUpdated.getNom(), etablissementDTOUpdated.getAdresse().getMergedAdress());

				break;
			default:
				break;
			}

		} while (true);
		scanner.close();
	}

	public void startAdministrateur() {
		String inputString;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.format("------\n");
			System.out.format("|MENU|\n");
			System.out.format("------\n");
			System.out.format("1 - visualiser tous les administrateurs\n");
			System.out.format("2 - créer un administrateurs\n");
			System.out.format("3 - supprimer un administrateurs\n");
			System.out.format("4 - modifier un administrateurs\n");
			System.out.format("X - revenir au menu principal\n");
			String nextLine = scanner.nextLine();
			if (nextLine.equals("X")) {
				break;
			}
			Integer menuChoice = Integer.parseInt(nextLine);
			Integer dataChoice;
			switch (menuChoice) {
			case 1:
				displayAllAdministrateur(academicBusiness);
				break;
			case 2:
				AdministrateurDTO administrateurDTO = new AdministrateurDTO();
				System.out.format("création d'un Administrateur\n");
				System.out.format("Nom:");
				inputString = scanner.nextLine();
				administrateurDTO.setNom(inputString);
				AdministrateurDTO newAdministrateurDTO = academicBusiness.createAdministrateur(administrateurDTO);
				System.out.format("id:%s | nom:%s\n", newAdministrateurDTO.getId(), newAdministrateurDTO.getNom());
				break;
			case 3:
				displayAllAdministrateur(academicBusiness);
				System.out.format("Quel ligne voulez vous supprimer?:");
				dataChoice = Integer.parseInt(scanner.nextLine());
				AdministrateurDTO administrateurDTOToDelete = administrateurDTOs.get(dataChoice - 1);
				academicBusiness.deleteAdministrateur(administrateurDTOToDelete);
				break;
			case 4:
				displayAllAdministrateur(academicBusiness);
				System.out.format("Quel ligne voulez vous modifier?:");
				dataChoice = Integer.parseInt(scanner.nextLine());
				AdministrateurDTO administrateurDTOToUpdate = administrateurDTOs.get(dataChoice - 1);

				System.out.format("Nom [%s]:", administrateurDTOToUpdate.getNom());
				inputString = scanner.nextLine();
				if (inputString.length() > 0) {
					administrateurDTOToUpdate.setNom(inputString);
				}
				AdministrateurDTO administrateurDTOUpdated = academicBusiness
						.updateAdministrateur(administrateurDTOToUpdate);
				System.out.format("id:%s | nom:%s\n", administrateurDTOUpdated.getId(),
						administrateurDTOUpdated.getNom());

				break;
			default:
				break;
			}

		} while (true);
		scanner.close();
	}

	private void displayAllEtablissement(IAcademicBusiness academicBusiness) {
		Integer rowNum = 1;
		this.etablissementDTOs = academicBusiness.listAllEtablissement();
		for (EtablissementDTO etablissementDTO : etablissementDTOs) {
			System.out.format("%s | nom:%s | adresse:%s\n", rowNum++, etablissementDTO.getNom(),
					etablissementDTO.getAdresse().getMergedAdress());
		}

	}

	private void displayAllAdministrateur(IAcademicBusiness academicBusiness) {
		Integer rowNum = 1;
		this.administrateurDTOs = academicBusiness.listAllAdministrateur();
		for (AdministrateurDTO administrateurDTO : administrateurDTOs) {
			System.out.format("%s | nom:%s\n", rowNum++, administrateurDTO.getNom());
		}

	}

}
