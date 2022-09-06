package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.AffectationNote;
import college.ing2.models.Etudiant;
import college.ing2.models.Matiere;
import college.ing2.models.Salle;
import college.ing2.utils.BdConnection;

public class AffectationNoteDao implements IcrudDao<AffectationNote> {
	
	//Variables de connexion
		Connection connection = null ;
		
		//Variable contenant le resultat de la requete
		ResultSet resultSet =null ;
		
		//Variable executant les requetes sql
		Statement statement = null;
		PreparedStatement prepareStatement = null ;
		//constructeurs
		public AffectationNoteDao() {
			//initialiser la connexion à,la base
		 connection = BdConnection.getConnection();
		 
		}
		@Override
		public List<AffectationNote> getAll() {
			List<AffectationNote> affectationNoteList = null;
			AffectationNote affectationNote = null;
			
			try {
				
				affectationNoteList = new ArrayList<AffectationNote>();
				String sql ="SELECT id_affectation_note, note, code_matiere, matiere_id, "
						+ "libelle_matiere, code_matiere, etudiant_id, nom_etudiant, prenom_etudiant, "
						+ "date_naissance_etudiant, telephone_etudiant, email_etudiant, date_entree  "
						+ "FROM matiere, affectation_note, etudiant "
						+ "WHERE id_etudiant=etudiant_id and matiere_id=id_matiere";
						
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					affectationNote = new AffectationNote();
					affectationNote.setId(resultSet.getInt("id_affectation_note"));
					affectationNote.setNote(resultSet.getInt("note"));
					affectationNote.setMatiere(new Matiere(
						resultSet.getInt("matiere_id"),
						resultSet.getString("libelle_matiere"),
						resultSet.getString("code_matiere")
							));
					affectationNote.setEtudiant(new Etudiant(
						resultSet.getInt("etudiant_id"),
						resultSet.getString("nom_etudiant"),
						resultSet.getString("prenom_etudiant"),
						LocalDate.parse(resultSet.getString("date_naissance_etudiant")),
						resultSet.getString("telephone_etudiant"),
						resultSet.getString("email_etudiant"),
						LocalDate.parse(resultSet.getString("date_entree"))
					));
							affectationNoteList.add(affectationNote);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return affectationNoteList;
		}
		
		
		public List<AffectationNote> getAllDetail(int id) {
			List<AffectationNote> affectationNoteList = null;
			AffectationNote affectationNote = null;
			
			try {
				
				affectationNoteList = new ArrayList<AffectationNote>();
				String sql ="SELECT id_affectation_note, note, code_matiere, matiere_id, "
						+ "libelle_matiere, code_matiere, etudiant_id, nom_etudiant, prenom_etudiant, "
						+ "date_naissance_etudiant, telephone_etudiant, email_etudiant, date_entree  "
						+ "FROM matiere, affectation_note, etudiant "
						+ "WHERE id_etudiant=etudiant_id and matiere_id=id_matiere and id_etudiant="+id;
						
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					affectationNote = new AffectationNote();
					affectationNote.setId(resultSet.getInt("id_affectation_note"));
					affectationNote.setNote(resultSet.getInt("note"));
					affectationNote.setMatiere(new Matiere(
						resultSet.getInt("matiere_id"),
						resultSet.getString("libelle_matiere"),
						resultSet.getString("code_matiere")
							));
					affectationNote.setEtudiant(new Etudiant(
						resultSet.getInt("etudiant_id"),
						resultSet.getString("nom_etudiant"),
						resultSet.getString("prenom_etudiant"),
						LocalDate.parse(resultSet.getString("date_naissance_etudiant")),
						resultSet.getString("telephone_etudiant"),
						resultSet.getString("email_etudiant"),
						LocalDate.parse(resultSet.getString("date_entree"))
					));
							affectationNoteList.add(affectationNote);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return affectationNoteList;
			
		}
		
		
		@Override
		public AffectationNote findById(int id) {
			
			AffectationNote affectationNote = null;
			
			try {
				
				
				String sql ="SELECT id_affectation_note, note, code_matiere, matiere_id, "
						+ "libelle_matiere, code_matiere, etudiant_id, nom_etudiant, prenom_etudiant, "
						+ "date_naissance_etudiant, telephone_etudiant, email_etudiant, date_entree  "
						+ "FROM matiere, affectation_note, etudiant "
						+ "WHERE id_etudiant=etudiant_id and matiere_id=id_matiere and id_affectation_note="+id;
						
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
					affectationNote = new AffectationNote();
					affectationNote.setId(resultSet.getInt("id_affectation_note"));
					affectationNote.setNote(resultSet.getInt("note"));
					affectationNote.setMatiere(new Matiere(
						resultSet.getInt("matiere_id"),
						resultSet.getString("libelle_matiere"),
						resultSet.getString("code_matiere")
							));
					affectationNote.setEtudiant(new Etudiant(
						resultSet.getInt("etudiant_id"),
						resultSet.getString("nom_etudiant"),
						resultSet.getString("prenom_etudiant"),
						LocalDate.parse(resultSet.getString("date_naissance_etudiant")),
						resultSet.getString("telephone_etudiant"),
						resultSet.getString("email_etudiant"),
						LocalDate.parse(resultSet.getString("date_entree"))
					));
							
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return affectationNote;
		}
		@Override
		public boolean save(AffectationNote t) {
			boolean flag = false;
			try {
				String sql = "INSERT INTO affectation_note(note,matiere_id, etudiant_id) "
						+ " value("
						+"'"+t.getNote()+"',"
								+"'"+t.getMatiere().getId()+"',"
									+"'"+t.getEtudiant().getId()+"'"
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
				String sql = "DELETE FROM affectation_note WHERE id_affectation_note="+id;
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
		public boolean update(AffectationNote t) {
			boolean isUpdated= false;
			try {
				String sql = "UPDATE affectation_note SET"
						+ " note = '"+t.getNote()+"',"
						+ " etudiant_id = '"+t.getEtudiant().getId()+"',"
						+ "matiere_id = '"+t.getMatiere().getId()+"'"
						+ " WHERE id_affectation_note = "+t.getId();
				//Mise a jour du etudiant
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.executeUpdate();
				isUpdated=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isUpdated;
		}
		
		public Float moyenne(int id) {
			Float m; m=(float) 0;
			try {
				String sql ="SELECT AVG(note) as moyen FROM matiere, affectation_note, etudiant "
						+ "WHERE id_etudiant=etudiant_id and matiere_id=id_matiere and id_etudiant="+id+" GROUP BY id_etudiant";	
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
		
		public List<Matiere> nonValide(int id) {
			List<Matiere> matiereList = null;
			Matiere matiere = null;
			
			try {
				
				matiereList = new ArrayList<Matiere>();
				String sql ="SELECT matiere.id_matiere, matiere.libelle_matiere, matiere.code_matiere "
						+ "FROM matiere, enseignant, departement WHERE matiere.id_matiere=enseignant.matiere_id AND id_departement=departement_id AND matiere.id_matiere "
						+ "NOT IN ( SELECT matiere.id_matiere FROM matiere, enseignant, departement, affectation_note, etudiant "
						+ "WHERE id_matiere=enseignant.matiere_id AND id_departement=departement_id AND affectation_note.etudiant_id=etudiant.id_etudiant AND affectation_note.matiere_id=matiere.id_matiere AND affectation_note.etudiant_id="+id+")";
						
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					matiere = new Matiere();
					matiere.setId(resultSet.getInt("id_matiere"));
					matiere.setLibelleMatiere(resultSet.getString("libelle_matiere"));
					matiere.setCodeMatiere(resultSet.getString("code_matiere"));
					matiereList.add(matiere);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return matiereList;
			
		}
		
		
		
		
		

}
