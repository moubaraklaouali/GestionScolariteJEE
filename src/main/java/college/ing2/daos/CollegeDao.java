package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.College;
import college.ing2.utils.BdConnection;

public class CollegeDao implements IcrudDao<College> {
	
	//Variables de connexion
	Connection connection = null ;
	
	//Variable contenant le resultat de la requete
	ResultSet resultSet =null ;
	
	//Variable executant les requetes sql
	Statement statement = null;
	PreparedStatement prepareStatement = null ;
	//constructeurs
	public CollegeDao() {
		//initialiser la connexion à,la base
	 connection = BdConnection.getConnection();
	}

	@Override
	public List<College> getAll() {
	//// Variable contenant la liste des salle
					List<College> collegeList = null;
					College college = null ;
					try {
						//Initialiser la liste des clients
						collegeList = new ArrayList<College>() ;
						
						//Executer la requete SQL
						statement = connection.createStatement();
						String sql = "SELECT * FROM  college";
						resultSet = statement.executeQuery(sql);
						// Parcours des données SQL
						
						while (resultSet.next()) {
							//initialiser l'objet salle
							college =new College();
							
							//appel aux setters de etudiant
							college.setId(resultSet.getInt("id_college"));
							college.setNomCollege(resultSet.getString("nom_college"));
							college.setSiteWeb(resultSet.getString("site_web"));
							collegeList.add(college);
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
			return collegeList;
	}

	@Override
	public College findById(int id) {
		List<College> collegeList = null;
		College college = null ;
	try {
		
		college =new College();
		//Executer la requete SQL
		statement = connection.createStatement();
		String sql = "SELECT * FROM  college where id_college="+id;
		resultSet = statement.executeQuery(sql);
		// Parcours des données SQL
		
		if (resultSet.next()) {
			college.setId(resultSet.getInt("id_college"));
			college.setNomCollege(resultSet.getString("nom_college"));
			college.setSiteWeb(resultSet.getString("site_web"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return college;
	}

	@Override
	public boolean save(College t) {
		boolean isInsert = false;
		try {
			String sql="Insert into college(nom_college,site_web)"
					+ " value("
						+"'"+t.getNomCollege()+"',"
									+"'"+t.getSiteWeb()+"'"
					+ ")";
			//Insertion dans la base de donnees
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isInsert = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isInsert;
	}

	@Override
	public boolean delete(int id) {
		boolean isDeleted = false;
		try {
			String sql = "DELETE FROM college WHERE id_college="+id;
			//Suppression du college
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean update(College t) {
		boolean isUpdated= false;
		try {
			String sql = "UPDATE college SET"
					+ " nom_college = '"+t.getNomCollege()+"',"
					+ "site_web = '"+t.getSiteWeb()+"'"
					+ " WHERE id_college = "+t.getId();
			//Mise a jour du college
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isUpdated= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

}
