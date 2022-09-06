package college.ing2.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Etudiant;
import college.ing2.utils.BdConnection;


public class EtudiantDao implements IcrudDao<Etudiant> {
	
	//Variables de connexion
		Connection connection = null ;
		
		//Variable contenant le resultat de la requete
		ResultSet resultSet =null ;
		
		//Variable executant les requetes sql
		Statement statement = null;
		PreparedStatement prepareStatement = null ;
		//constructeurs
		public EtudiantDao() {
			//initialiser la connexion à,la base
		 connection = BdConnection.getConnection();
		 
		}

	@Override
	public List<Etudiant> getAll() {
	//// Variable contenant la liste des client
			List<Etudiant> etudiantList = null;
			Etudiant etudiant = null ;
			try {
				//Initialiser la liste des clients
				etudiantList = new ArrayList<Etudiant>() ;
				
				//Executer la requete SQL
				statement = connection.createStatement();
				String sql = "SELECT * FROM  etudiant";
				resultSet = statement.executeQuery(sql);
				// Parcours des données SQL
				
				while (resultSet.next()) {
					//initialiser l'objet client
					etudiant =new Etudiant();
					
					//appel aux setters de etudiant
					etudiant.setId(resultSet.getInt("id_etudiant"));
					etudiant.setNom(resultSet.getString("nom_etudiant"));
					etudiant.setPrenom(resultSet.getString("prenom_etudiant"));
					etudiant.setDateNaissance(LocalDate.parse(resultSet.getString("date_naissance_etudiant")));
					etudiant.setTelephone(resultSet.getString("telephone_etudiant"));
					etudiant.setEmail(resultSet.getString("email_etudiant"));
					etudiant.setDateEntree(LocalDate.parse(resultSet.getString("date_entree")));
					etudiantList.add(etudiant);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return etudiantList;
	}

	@Override
	public Etudiant findById(int id) {
	//// Variable contenant la liste des client
				List<Etudiant> etudiantList = null;
				Etudiant etudiant = null ;
				try {
					
					etudiant =new Etudiant();
					//Executer la requete SQL
					statement = connection.createStatement();
					String sql = "SELECT * FROM  etudiant where id_etudiant="+id;
					resultSet = statement.executeQuery(sql);
					// Parcours des données SQL
					
					if (resultSet.next()) {
						//appel aux setters de etudiant
						etudiant.setId(resultSet.getInt("id_etudiant"));
						etudiant.setNom(resultSet.getString("nom_etudiant"));
						etudiant.setPrenom(resultSet.getString("prenom_etudiant"));
						etudiant.setDateNaissance(LocalDate.parse(resultSet.getString("date_naissance_etudiant")));
						etudiant.setTelephone(resultSet.getString("telephone_etudiant"));
						etudiant.setEmail(resultSet.getString("email_etudiant"));
						etudiant.setDateEntree(LocalDate.parse(resultSet.getString("date_entree")));
						
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		return etudiant;
	}

	@Override
	public boolean save(Etudiant t) {
		boolean isInsert = false;
		try {
			String sql="Insert into etudiant(nom_etudiant,prenom_etudiant,date_naissance_etudiant,telephone_etudiant,email_etudiant,date_entree)"
					+ " value("
						+"'"+t.getNom()+"',"
								+"'"+t.getPrenom()+"',"
										+"'"+t.getDateNaissance()+"',"
												+"'"+t.getTelephone()+"',"
													+"'"+t.getEmail()+"',"
															+"'"+t.getDateEntree()+"'"
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
			String sql = "DELETE FROM etudiant WHERE id_etudiant="+id;
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
	public boolean update(Etudiant t) {
		boolean isUpdated= false;
		try {
			String sql = "UPDATE etudiant SET"
					+ " nom_etudiant = '"+t.getNom()+"',"
					+ "prenom_etudiant = '"+t.getPrenom()+"',"
					+ "date_naissance_etudiant = '"+t.getDateNaissance()+"',"
					+ "telephone_etudiant = '"+t.getTelephone()+"',"
					+ "email_etudiant = '"+t.getEmail()+"',"
					+ "date_entree = '"+t.getDateEntree()+"'"
					+ " WHERE id_etudiant = "+t.getId();
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
