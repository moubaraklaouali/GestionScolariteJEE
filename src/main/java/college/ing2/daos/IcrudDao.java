package college.ing2.daos;

import java.util.List;

public interface IcrudDao<Table> {
	// Recup�rer toutes les lignes de la table
		List<Table> getAll();
		
		//REcuperer une ligne de la table
		Table findById(int id);
		
		//insertion de donn�ees
		boolean save(Table t);
		
		//suppression de donn�ees
		boolean delete(int id);
		
		//mise � jour de donn�es
		boolean update(Table t);
}
