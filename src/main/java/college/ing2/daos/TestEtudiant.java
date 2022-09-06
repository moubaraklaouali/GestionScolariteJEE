package college.ing2.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Etudiant;

public class TestEtudiant {

	public static void main(String[] args) {
		EtudiantDao etudiantDao =new EtudiantDao();
		List<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
		
		//Insertion d'un etudiant
		Etudiant cl = new Etudiant("Sandi","Sandi",LocalDate.parse("2022-09-12"),"98976677","alla@gmail.com",LocalDate.parse("2022-10-10"));
		etudiantDao.save(cl);
//		Suppression etudiant
//		etudiantDao.delete(2);
		System.out.println(etudiantDao.findById(1));
		
		//Afficher la liste des clients
		listeEtudiants = etudiantDao.getAll();
//		
		for(Etudiant etudiant : listeEtudiants)
		{
			System.out.println(etudiant.toString()+ "\n");
		}
	}

}
