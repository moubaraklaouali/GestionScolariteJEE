package college.ing2.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import college.ing2.models.Departement;
import college.ing2.models.Enseignant;
import college.ing2.models.Matiere;

public class TestEnseignant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnseignantDao enseignantDao =new EnseignantDao();
		List<Enseignant> listeEnseignantDao = new ArrayList<Enseignant>();
		
//		Departement departement = new Departement(1);
//		Matiere matiere = new Matiere(6);
//		Enseignant ens = new Enseignant(5,"Kailou","Issaka",LocalDate.parse("2022-09-12"),"7483290","MFDKKD@GMAIL.COM",LocalDate.parse("2022-09-12"),"456RF",departement,matiere);
//		enseignantDao.update(ens);
////		enseignantDao.delete(3);
		
		listeEnseignantDao=enseignantDao.getAll();
		for(Enseignant mr : listeEnseignantDao)
			{
				System.out.println(mr.toString()+ "\n");
			}
//		System.out.println(enseignantDao.findById(1));

	}

}
