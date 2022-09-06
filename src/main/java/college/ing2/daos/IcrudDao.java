package college.ing2.daos;

import java.util.List;

public interface IcrudDao<Table> {
	// Recupérer toutes les lignes de la table
		List<Table> getAll();
		
		//REcuperer une ligne de la table
		Table findById(int id);
		
		//insertion de donnéees
		boolean save(Table t);
		
		//suppression de donnéees
		boolean delete(int id);
		
		//mise à jour de données
		boolean update(Table t);
}
