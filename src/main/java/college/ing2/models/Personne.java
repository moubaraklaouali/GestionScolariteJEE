package college.ing2.models;

import java.time.LocalDate;

public class Personne {
	
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String telephone;
	private String email;
	
	public Personne() {
		super();
	}
	
	

	public Personne(int id) {
		super();
		this.id = id;
	}



	public Personne(int id, String nom, String prenom, LocalDate dateNaissance, String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
	}

	public Personne(String nom, String prenom, LocalDate dateNaissance, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
	
	

}
