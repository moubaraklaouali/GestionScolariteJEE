package college.ing2.daos;

import java.util.ArrayList;
import java.util.List;

import college.ing2.models.Salle;



public class TestSalle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalleDao salleDao =new SalleDao();
		List<Salle> listeSalles = new ArrayList<Salle>();
		Salle salle = new Salle("R1",34);
		salleDao.save(salle);
		salleDao.delete(2);
		listeSalles=salleDao.getAll();
		for(Salle sal : listeSalles)
			{
				System.out.println(sal.toString()+ "\n");
			}
		System.out.println(salleDao.findById(1));

	}

}
