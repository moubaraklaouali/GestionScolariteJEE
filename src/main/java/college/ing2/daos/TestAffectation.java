package college.ing2.daos;

import java.util.ArrayList;
import java.util.List;

import college.ing2.models.AffectationNote;
import college.ing2.models.Etudiant;
import college.ing2.models.Matiere;

public class TestAffectation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AffectationNoteDao affectationNoteDao =new AffectationNoteDao();
		List<AffectationNote> listeAffectationNotes = new ArrayList<AffectationNote>();
		List<Matiere> listematiere = new ArrayList<Matiere>();
//		Etudiant etudiant = new Etudiant(17);
//		Matiere matiere = new Matiere(6);
//		affectationNoteDao.delete(2);
//		AffectationNote affectationNote= new AffectationNote(18,matiere,etudiant);
//		affectationNoteDao.save(affectationNote);
		
		listeAffectationNotes=affectationNoteDao.getAll();
		for(AffectationNote sal : listeAffectationNotes)
			{
				System.out.println(sal.toString()+ "\n");
			}
//		System.out.println(affectationNoteDao.findById(1));
		
		listeAffectationNotes=affectationNoteDao.getAllDetail(1);
		for(AffectationNote sal : listeAffectationNotes)
			{
				System.out.println(sal.toString()+ "\n");
			}
		System.out.println(affectationNoteDao.moyenne(1));
		
		listematiere=affectationNoteDao.nonValide(1);
		
		for (Matiere matiere : listematiere) {
			
			System.out.println(matiere.toString());
		}
		
		

	}

}
