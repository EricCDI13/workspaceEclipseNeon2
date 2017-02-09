package fr.imie.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.model.AdministrateurDTO;

public class AdministrateurDAO implements IAdministrateurDAO {

	private IConnexionManagement connexionManagement;

	public AdministrateurDAO(IConnexionManagement connexionManagement) {
		super();
		this.connexionManagement = connexionManagement;
	}

	private List<AdministrateurDTO> convertToDTO(ResultSet resultSet) throws SQLException {
		List<AdministrateurDTO> dtoList = null;
		if (resultSet.getFetchSize() > 0) {
			dtoList = new ArrayList<>();
			while (resultSet.next()) {
				AdministrateurDTO dto = new AdministrateurDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setNom(resultSet.getString("nom"));
				dto.setPrenom(resultSet.getString("prenom"));
				dto.setEmail(resultSet.getString("email"));
				dto.setIsGeneral(resultSet.getBoolean("isGeneral"));
				dto.setIsActive(resultSet.getBoolean("isActive"));
				Date date = resultSet.getDate("dateNaissance");
				if (date != null) {
					dto.setDateNaissance(date.toLocalDate());
				}
				dtoList.add(dto);
			}
		}
		return dtoList;

	}

	@Override
	public List<AdministrateurDTO> listAllAdministrateur() {

		final String query = "select id,nom,prenom,email,is_general,is_atciv,date_naissance from administrateur";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<AdministrateurDTO> dtoList = null;
		try {
			connection = connexionManagement.initConnexion();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			dtoList = this.convertToDTO(resultSet);
		} catch (SQLException e) {
			System.err.println("Erreur DAO Administrateur listAllAdministrateur");
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}
		return dtoList;
	}

	@Override
	public AdministrateurDTO createAdministrateur(AdministrateurDTO administrateurDTO) {

		final String query = "INSERT INTO administrateur(nom,prenom,email,is_general,is_activ,date_naissance) VALUES (?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		AdministrateurDTO dto = null;

		try {
			connection = connexionManagement.initConnexion();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, administrateurDTO.getNom());
			statement.setString(2, administrateurDTO.getPrenom());
			statement.setString(3, administrateurDTO.getEmail());
			statement.setBoolean(4, administrateurDTO.getIsGeneral());
			statement.setBoolean(5, administrateurDTO.getIsActive());
			statement.setDate(6, Date.valueOf(administrateurDTO.getDateNaissance()));

			resultSet = statement.executeQuery();
			List<AdministrateurDTO> dtoList = this.convertToDTO(resultSet);
			if (dtoList != null && !dtoList.isEmpty()) {
				dto = dtoList.get(0);
			}

		} catch (SQLException e) {
			System.err.println("Erreur DAO Administrateur createAdministrateur");
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}

		return dto;
	}

	@Override
	public void deleteAdministrateur(AdministrateurDTO administrateurDTO) {

		final String query = "delete from administrateur where id=?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = connexionManagement.initConnexion();
			statement = connection.prepareStatement(query);
			statement.setInt(1, administrateurDTO.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Erreur DAO Administrateur deleteAdministrateur");
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, null);
		}

	}

	@Override
	public AdministrateurDTO updateAdministrateur(AdministrateurDTO administrateurDTO) {

		final String query = "UPDATE administrateur set nom=?,prenom=?,email=?,is_general=?,is_activ=?,date_naissance=? where id=?";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		AdministrateurDTO dto = null;

		try {
			connection = connexionManagement.initConnexion();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, administrateurDTO.getNom());
			statement.setString(2, administrateurDTO.getPrenom());
			statement.setString(3, administrateurDTO.getEmail());
			statement.setBoolean(4, administrateurDTO.getIsGeneral());
			statement.setBoolean(5, administrateurDTO.getIsActive());
			statement.setDate(6, Date.valueOf(administrateurDTO.getDateNaissance()));
			// where
			statement.setInt(7, administrateurDTO.getId());

			resultSet = statement.executeQuery();
			List<AdministrateurDTO> dtoList = this.convertToDTO(resultSet);
			if (dtoList != null && !dtoList.isEmpty()) {
				dto = dtoList.get(0);
			}

		} catch (SQLException e) {
			System.err.println("Erreur DAO Administrateur updateAdministrateur");
			e.printStackTrace();
		} finally {
			connexionManagement.closeJDBCResources(connection, statement, resultSet);
		}

		return dto;
	}

}
