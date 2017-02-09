package fr.imie.model;

import java.time.LocalDate;

public class AdministrateurDTO {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private Boolean isGeneral;
	private Boolean isActive;
	private LocalDate dateNaissance;

	public AdministrateurDTO() {
		
	}
	
	public AdministrateurDTO(String nom, String prenom, String email, Boolean isGeneral, Boolean isActive) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.isGeneral = isGeneral;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsGeneral() {
		return isGeneral;
	}

	public void setIsGeneral(Boolean isGeneral) {
		this.isGeneral = isGeneral;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
