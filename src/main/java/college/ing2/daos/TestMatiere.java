package college.ing2.daos;

import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Matiere;
import college.ing2.models.Salle;

public class TestMatiere {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatiereDao matiereDao =new MatiereDao();
//		List<Matiere> listeMatieres = new ArrayList<Matiere>();
//		Salle salle = new Salle(1);
//		Matiere matiere= new Matiere("PC","PCOO1",salle);
//		matiereDao.save(matiere);
//		
//		listeMatieres=matiereDao.getAll();
//		for(Matiere sal : listeMatieres)
//			{
//				System.out.println(sal.toString()+ "\n");
//			}
		System.out.println(matiereDao.moyenne(7));

	}

}
