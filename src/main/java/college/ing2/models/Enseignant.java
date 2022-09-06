package college.ing2.models;

import java.time.LocalDate;

public class Enseignant extends Personne {
	
	private LocalDate datePriseFonction;
	private String indice;
	private Departement departement;
	private Matiere matiere;

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(int id, String nom, String prenom, LocalDate dateNaissance, String telephone, String email, LocalDate datePriseFonction, String indice, Departement departement, Matiere matiere ) {
		super(id, nom, prenom, dateNaissance, telephone, email);
		this.datePriseFonction=datePriseFonction;
		this.indice=indice;
		this.departement=departement;
		this.matiere=matiere;
	}
	
	
	
	public Enseignant(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Enseignant(int id, String nom, String prenom, LocalDate dateNaissance, String telephone, String email, LocalDate datePriseFonction, String indice ) {
		super(id, nom, prenom, dateNaissance, telephone, email);
		this.datePriseFonction=datePriseFonction;
		this.indice=indice;
		
	}

	public Enseignant(String nom, String prenom, LocalDate dateNaissance, String telephone, String email, LocalDate datePriseFonction, String indice, Departement departement, Matiere matiere ) {
		super(nom, prenom, dateNaissance, telephone, email);
		this.datePriseFonction=datePriseFonction;
		this.indice=indice;
		this.departement=departement;
		this.matiere=matiere;
	}

	public LocalDate getDatePriseFonction() {
		return datePriseFonction;
	}

	public void setDatePriseFonction(LocalDate datePriseFonction) {
		this.datePriseFonction = datePriseFonction;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return super.toString()+"Enseignant [datePriseFonction=" + datePriseFonction + ", indice=" + indice + ", departement="
				+ departement + ", matiere=" + matiere + "]";
	}
	
	
	
}
