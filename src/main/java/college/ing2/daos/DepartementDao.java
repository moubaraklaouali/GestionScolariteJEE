package college.ing2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.College;
import college.ing2.models.Departement;
import college.ing2.models.Enseignant;
import college.ing2.utils.BdConnection;

public class DepartementDao implements IcrudDao<Departement> {
	
	//Variables de connexion
		Connection connection = null ;
		
		//Variable contenant le resultat de la requete
		ResultSet resultSet =null ;
		
		//Variable executant les requetes sql
		Statement statement = null;
		PreparedStatement prepareStatement = null ;
		//constructeurs
		public DepartementDao() {
			//initialiser la connexion à,la base
		 connection = BdConnection.getConnection();
		}
		@Override
		public List<Departement> getAll() {
			List<Departement>departementList = null;
		    Departement departement = null;
		    
		    try {
		        
		        departementList = new ArrayList<Departement>();
		       String sql="SELECT id_departement, libelle_departement,code_departement,  `id_enseignant`, "
		       		+ "`nom_enseignant`, `prenom_enseignant`, `date_naissance_enseignant`, `telephone_enseignant`, "
		       		+ "`email_enseignant`, `date_prise_fonction`, `indice`, `id_college`, `nom_college`, `site_web` "
		       		+ "FROM enseignant, departement, college WHERE id_college=college_id AND id_enseignant=enseignant_id";

		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(sql);
		        while(resultSet.next()) {
		            departement = new Departement();
		            departement.setId(resultSet.getInt("id_departement"));
		            departement.setLibelleDepartement(resultSet.getString("libelle_departement"));
		            departement.setCodeDepartement(resultSet.getString("code_departement"));
		            departement.setEnseignant(new Enseignant(
		                    resultSet.getInt("id_enseignant"),
		                    resultSet.getString("nom_enseignant"),
		                    resultSet.getString("prenom_enseignant"),
		                    LocalDate.parse(resultSet.getString("date_naissance_enseignant")),
		                    resultSet.getString("telephone_enseignant"),
		                    resultSet.getString("email_enseignant"),
		                    LocalDate.parse(resultSet.getString("date_prise_fonction")),
		                    resultSet.getString("indice")
		                    ));
		            departement.setCollege(new College(
		                        resultSet.getInt("id_college"),
		                        resultSet.getString("nom_college"),
		                        resultSet.getString("site_web")
		                        ));
		                departementList.add(departement);
		        }
		    }catch(SQLException e) {
		        e.printStackTrace();
		    }
		    return departementList;
		}
		@Override
		public Departement findById(int id) {
			
		    Departement departement = null;
		    
		    try {
		        
		        
		       String sql="SELECT id_departement, libelle_departement,code_departement,  `id_enseignant`, "
		       		+ "`nom_enseignant`, `prenom_enseignant`, `date_naissance_enseignant`, `telephone_enseignant`, "
		       		+ "`email_enseignant`, `date_prise_fonction`, `indice`, `id_college`, `nom_college`, `site_web` "
		       		+ "FROM enseignant, departement, college WHERE id_college=college_id AND id_enseignant=enseignant_id AND id_departement="+id;

		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(sql);
		        if(resultSet.next()) {
		            departement = new Departement();
		            departement.setId(resultSet.getInt("id_departement"));
		            departement.setLibelleDepartement(resultSet.getString("libelle_departement"));
		            departement.setCodeDepartement(resultSet.getString("code_departement"));
		            departement.setEnseignant(new Enseignant(
		                    resultSet.getInt("id_enseignant"),
		                    resultSet.getString("nom_enseignant"),
		                    resultSet.getString("prenom_enseignant"),
		                    LocalDate.parse(resultSet.getString("date_naissance_enseignant")),
		                    resultSet.getString("telephone_enseignant"),
		                    resultSet.getString("email_enseignant"),
		                    LocalDate.parse(resultSet.getString("date_prise_fonction")),
		                    resultSet.getString("indice")
		                    ));
		            departement.setCollege(new College(
		                        resultSet.getInt("id_college"),
		                        resultSet.getString("nom_college"),
		                        resultSet.getString("site_web")
		                        ));
		                
		        }
		    }catch(SQLException e) {
		        e.printStackTrace();
		    }
		    return departement;
		}
		@Override
		public boolean save(Departement t) {
			boolean flag = false;
			try {
				String sql = "INSERT INTO departement(libelle_departement, code_departement, enseignant_id, college_id) "
						+ " value("
						+"'"+t.getLibelleDepartement()+"',"
								+"'"+t.getCodeDepartement()+"',"
	                                +"'"+t.getEnseignant().getId()+"',"
									    +"'"+t.getCollege().getId()+"'"
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
					String sql = "DELETE FROM departement WHERE id_departement="+id;
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
		public boolean update(Departement t) {
			 boolean isUpdated= false;
				try {
					String sql = "UPDATE departement SET"
							+ " libelle_departement = '"+t.getLibelleDepartement()+"',"
							+ " code_departement = '"+t.getCodeDepartement()+"',"
		                    + " enseignant_id = '"+t.getEnseignant().getId()+"',"
							+ "college_id = '"+t.getCollege().getId()+"'"
							+ " WHERE id_departement = "+t.getId();
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
				String sql =" SELECT AVG(note) as moyen FROM matiere, enseignant, departement, affectation_note, college WHERE matiere.id_matiere=enseignant.matiere_id AND id_departement=departement_id AND matiere.id_matiere=affectation_note.matiere_id AND departement.college_id=id_college AND departement.id_departement="+id+" GROUP BY departement.id_departement";	
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
