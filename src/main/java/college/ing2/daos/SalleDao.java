package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import college.ing2.models.Salle;
import college.ing2.utils.BdConnection;

public class SalleDao implements IcrudDao<Salle> {
	
	//Variables de connexion
			Connection connection = null ;
			
			//Variable contenant le resultat de la requete
			ResultSet resultSet =null ;
			
			//Variable executant les requetes sql
			Statement statement = null;
			PreparedStatement prepareStatement = null ;
			//constructeurs
			public SalleDao() {
				//initialiser la connexion à,la base
			 connection = BdConnection.getConnection();
			 
			}

	@Override
	public List<Salle> getAll() {
	//// Variable contenant la liste des salle
				List<Salle> salleList = null;
				Salle salle = null ;
				try {
					//Initialiser la liste des clients
					salleList = new ArrayList<Salle>() ;
					
					//Executer la requete SQL
					statement = connection.createStatement();
					String sql = "SELECT * FROM  salle";
					resultSet = statement.executeQuery(sql);
					// Parcours des données SQL
					
					while (resultSet.next()) {
						//initialiser l'objet salle
						salle =new Salle();
						
						//appel aux setters de etudiant
						salle.setId(resultSet.getInt("id_salle"));
						salle.setLibelleSalle(resultSet.getString("libelle_salle"));
						salle.setNbPlace(resultSet.getInt("nb_place"));
						salleList.add(salle);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		return salleList;
	}

	@Override
	public Salle findById(int id) {
		List<Salle> salleList = null;
		Salle salle = null ;
	try {
		
		salle =new Salle();
		//Executer la requete SQL
		statement = connection.createStatement();
		String sql = "SELECT * FROM  salle where id_salle="+id;
		resultSet = statement.executeQuery(sql);
		// Parcours des données SQL
		
		if (resultSet.next()) {
			salle.setId(resultSet.getInt("id_salle"));
			salle.setLibelleSalle(resultSet.getString("libelle_salle"));
			salle.setNbPlace(resultSet.getInt("nb_place"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return salle;
	}

	@Override
	public boolean save(Salle t) {
		boolean isInsert = false;
		try {
			String sql="Insert into salle(libelle_salle,nb_place)"
					+ " value("
						+"'"+t.getLibelleSalle()+"',"
									+"'"+t.getNbPlace()+"'"
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
			String sql = "DELETE FROM salle WHERE id_salle="+id;
			//Suppression du etudiant
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean update(Salle t) {
		boolean isUpdated= false;
		try {
			String sql = "UPDATE salle SET"
					+ " libelle_salle = '"+t.getLibelleSalle()+"',"
					+ "nb_place = '"+t.getNbPlace()+"'"
					+ " WHERE id_salle = "+t.getId();
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
