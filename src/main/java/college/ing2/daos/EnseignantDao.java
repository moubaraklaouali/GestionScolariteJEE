package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Departement;
import college.ing2.models.Enseignant;
import college.ing2.models.Matiere;
import college.ing2.utils.BdConnection;

public class EnseignantDao implements IcrudDao<Enseignant> {
	

	//Variables de connexion
	Connection connection = null ;
	
	//Variable contenant le resultat de la requete
	ResultSet resultSet =null ;
	
	//Variable executant les requetes sql
	Statement statement = null;
	PreparedStatement prepareStatement = null ;
	//constructeurs
	public EnseignantDao() {
		//initialiser la connexion à,la base
	 connection = BdConnection.getConnection();
	 
	}

	@Override
	public List<Enseignant> getAll() {
		List<Enseignant>enseignantList = null;
		Enseignant enseignant = null;
		
		try {
			
			enseignantList = new ArrayList<Enseignant>();
			String sql ="SELECT `id_enseignant`, `nom_enseignant`, `prenom_enseignant`, `date_naissance_enseignant`, `telephone_enseignant`, `email_enseignant`, `date_prise_fonction`, `indice`, `id_departement`, `libelle_departement`, `code_departement`, `id_matiere`, `libelle_matiere`, `code_matiere` FROM departement, enseignant, matiere WHERE enseignant.departement_id=departement.id_departement and enseignant.matiere_id=matiere.id_matiere";
					
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				enseignant = new Enseignant();
				enseignant.setId(resultSet.getInt("id_enseignant"));
				enseignant.setNom(resultSet.getString("nom_enseignant"));
				enseignant.setPrenom(resultSet.getString("prenom_enseignant"));
				enseignant.setDateNaissance(LocalDate.parse(resultSet.getString("date_naissance_enseignant")));
				enseignant.setEmail(resultSet.getString("email_enseignant"));
				enseignant.setTelephone(resultSet.getString("telephone_enseignant"));
				enseignant.setIndice(resultSet.getString("indice"));
				enseignant.setDatePriseFonction(LocalDate.parse(resultSet.getString("date_prise_fonction")));
				enseignant.setDepartement(new Departement(
						resultSet.getInt("id_departement"),
						resultSet.getString("libelle_departement"),
						resultSet.getString("code_departement")
						));
				enseignant.setMatiere(new Matiere(
							resultSet.getInt("id_matiere"),
							resultSet.getString("libelle_matiere"),
							resultSet.getString("code_matiere")
							));
				enseignantList.add(enseignant);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return enseignantList;
	}

	@Override
	public Enseignant findById(int id) {
Enseignant enseignant = null;
		
		try {
			
			
			String sql ="SELECT `id_enseignant`, `nom_enseignant`, `prenom_enseignant`, `date_naissance_enseignant`, `telephone_enseignant`, "
					+ "`email_enseignant`, `date_prise_fonction`, `indice`, `id_departement`, "
					+ "`libelle_departement`, `code_departement`, `id_matiere`, `libelle_matiere`, `code_matiere` FROM departement, enseignant, matiere "
					+ "WHERE enseignant.departement_id=departement.id_departement and enseignant.matiere_id=matiere.id_matiere and id_enseignant="+id;
					
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				enseignant = new Enseignant();
				enseignant.setId(resultSet.getInt("id_enseignant"));
				enseignant.setNom(resultSet.getString("nom_enseignant"));
				enseignant.setPrenom(resultSet.getString("prenom_enseignant"));
				enseignant.setDateNaissance(LocalDate.parse(resultSet.getString("date_naissance_enseignant")));
				enseignant.setEmail(resultSet.getString("email_enseignant"));
				enseignant.setTelephone(resultSet.getString("telephone_enseignant"));
				enseignant.setIndice(resultSet.getString("indice"));
				enseignant.setDatePriseFonction(LocalDate.parse(resultSet.getString("date_prise_fonction")));
				enseignant.setDepartement(new Departement(
						resultSet.getInt("id_departement"),
						resultSet.getString("libelle_departement"),
						resultSet.getString("code_departement")
						));
				enseignant.setMatiere(new Matiere(
							resultSet.getInt("id_matiere"),
							resultSet.getString("libelle_matiere"),
							resultSet.getString("code_matiere")
							));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return enseignant;
	}

	@Override
	public boolean save(Enseignant t) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO enseignant( `nom_enseignant`, `prenom_enseignant`, `date_naissance_enseignant`, `telephone_enseignant`, `email_enseignant`, `date_prise_fonction`, `indice`, `departement_id`, `matiere_id`) "
					+ " value("
					+"'"+t.getNom()+"',"
							+"'"+t.getPrenom()+"',"
									+"'"+t.getDateNaissance()+"',"
											+"'"+t.getTelephone()+"',"
													+"'"+t.getEmail()+"',"
															+"'"+t.getDatePriseFonction()+"',"
																	+"'"+t.getIndice()+"',"
																			+"'"+t.getDepartement().getId()+"',"
																					+"'"+t.getMatiere().getId()+"'"
				+ ")";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean isDeleted = false;
		try {
			String sql = "DELETE FROM enseignant WHERE id_enseignant="+id;
			//Suppression du matiere
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean update(Enseignant t) {
		boolean isUpdated= false;
		try {
			String sql = "UPDATE enseignant SET"
					+ " nom_enseignant = '"+t.getNom()+"',"
					+ " prenom_enseignant = '"+t.getPrenom()+"',"
					+ " date_naissance_enseignant = '"+t.getDateNaissance()+"',"
					+ " telephone_enseignant = '"+t.getTelephone()+"',"
					+ " email_enseignant = '"+t.getEmail()+"',"
					+ " date_prise_fonction = '"+t.getDatePriseFonction()+"',"
					+ " indice = '"+t.getIndice()+"',"
					+ " departement_id = '"+t.getDepartement().getId()+"',"
					+ "matiere_id = '"+t.getMatiere().getId()+"'"
					+ " WHERE id_enseignant = "+t.getId();
			//Mise a jour du etudiant
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isUpdated= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

}
