package college.ing2.daos;

import java.util.ArrayList;
import java.util.List;

import college.ing2.models.College;

public class TestCollege {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CollegeDao collegeDao =new CollegeDao();
		List<College> listeColleges = new ArrayList<College>();
		College college = new College("Emig","emig@edu.ne");
		collegeDao.save(college);
		collegeDao.delete(2);
		listeColleges=collegeDao.getAll();
		for(College col : listeColleges)
			{
				System.out.println(col.toString()+ "\n");
			}
		System.out.println(collegeDao.findById(1));

	}

}
