package college.ing2.daos;

import java.util.ArrayList;
import java.util.List;

import college.ing2.models.College;
import college.ing2.models.Departement;
import college.ing2.models.Enseignant;

public class TestDepartement {

	public static void main(String[] args) {
		 DepartementDao departementDao =new DepartementDao();
			List<Departement> listedepartements = new ArrayList<Departement>();
//			Enseignant enseignant = new Enseignant(1);
//	        College college= new College(1);
//			Departement departement= new Departement("Genie Logiciel","GL",college,enseignant);
////			departementDao.save(departement);
//			departementDao.delete(5);
			
			listedepartements=departementDao.getAll();
			for(Departement sal : listedepartements)
				{
					System.out.println(sal.toString()+ "\n");
				}
			System.out.println(departementDao.findById(1));
	        System.out.println(departementDao.moyenne(1));

	}

}
