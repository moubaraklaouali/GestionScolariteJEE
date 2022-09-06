package college.ing2.models;

import java.time.LocalDate;

public class Etudiant extends Personne {
	private LocalDate dateEntree;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Etudiant(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	public Etudiant(int id, String nom, String prenom, LocalDate dateNaissance, String telephone, String email, LocalDate dateEntree) {
		super(id, nom, prenom, dateNaissance, telephone, email);
		this.dateEntree=dateEntree;
	}

	public Etudiant(String nom, String prenom, LocalDate dateNaissance, String telephone, String email, LocalDate dateEntree) {
		super(nom, prenom, dateNaissance, telephone, email);
		this.dateEntree=dateEntree;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Override
	public String toString() {
		return super.toString()+"Etudiant [dateEntree=" + dateEntree + "]";
	}
	
	

	
	
}
