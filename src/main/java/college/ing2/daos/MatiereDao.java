package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Matiere;
import college.ing2.models.Salle;
import college.ing2.utils.BdConnection;

public class MatiereDao implements IcrudDao <Matiere> {
	
	//Variables de connexion
	Connection connection = null ;
	
	//Variable contenant le resultat de la requete
	ResultSet resultSet =null ;
	
	//Variable executant les requetes sql
	Statement statement = null;
	PreparedStatement prepareStatement = null ;
	//constructeurs
	public MatiereDao() {
		//initialiser la connexion à,la base
	 connection = BdConnection.getConnection();
	 
	}

	@Override
	public List<Matiere> getAll() {
		List<Matiere> matiereList = null;
		Matiere matiere = null;
		
		try {
			
			matiereList = new ArrayList<Matiere>();
			String sql ="SELECT id_matiere, libelle_matiere, code_matiere, id_salle, "
					+ "libelle_salle, nb_place FROM matiere, salle WHERE id_salle=salle_id";
					
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				matiere = new Matiere();
				matiere.setId(resultSet.getInt("id_matiere"));
				matiere.setLibelleMatiere(resultSet.getString("libelle_matiere"));
				matiere.setCodeMatiere(resultSet.getString("code_matiere"));
				matiere.setSalle(new Salle(
						resultSet.getInt("id_salle"),
						resultSet.getString("libelle_salle"),
						resultSet.getInt("nb_place")
						));
				matiereList.add(matiere);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return matiereList;
	}

	@Override
	public Matiere findById(int id) {
		Matiere matiere = null;
		
		try {
			
			
			String sql ="SELECT id_matiere, libelle_matiere, code_matiere, id_salle, "
					+ "libelle_salle, nb_place FROM matiere, salle WHERE id_salle=salle_id and"
					+ " id_matiere="+id;
					
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				matiere = new Matiere();
				matiere.setId(resultSet.getInt("id_matiere"));
				matiere.setLibelleMatiere(resultSet.getString("libelle_matiere"));
				matiere.setCodeMatiere(resultSet.getString("code_matiere"));
				matiere.setSalle(new Salle(
						resultSet.getInt("id_salle"),
						resultSet.getString("libelle_salle"),
						resultSet.getInt("nb_place")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return matiere;
	}

	@Override
	public boolean save(Matiere t) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO matiere(libelle_matiere, code_matiere, salle_id) "
					+ " value("
					+"'"+t.getLibelleMatiere()+"',"
							+"'"+t.getCodeMatiere()+"',"
								+"'"+t.getSalle().getId()+"'"
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
			String sql = "DELETE FROM matiere WHERE id_matiere="+id;
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
	public boolean update(Matiere t) {
		boolean isUpdated= false;
		try {
			String sql = "UPDATE matiere SET"
					+ " libelle_matiere = '"+t.getLibelleMatiere()+"',"
					+ " code_matiere = '"+t.getCodeMatiere()+"',"
					+ "salle_id = '"+t.getSalle().getId()+"'"
					+ " WHERE id_matiere = "+t.getId();
			//Mise a jour du etudiant
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.executeUpdate();
			isUpdated= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	
	}
	
	public Float moyenne(int id) {
		Float m; m=(float) 0;
		try {
			String sql =" SELECT AVG(note) as moyen FROM matiere, affectation_note WHERE affectation_note.matiere_id=id_matiere AND id_matiere="+id+" GROUP BY id_matiere";	
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				m=resultSet.getFloat("moyen");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	
		
	}

}
