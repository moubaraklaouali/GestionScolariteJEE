package college.ing2.models;

public class Departement {
	private int id;
	private String libelleDepartement;
	private String codeDepartement;
	private College college;
	private Enseignant enseignant;
	public Departement() {
		super();
	}
	public Departement(String libelleDepartement, String codeDepartement, College college, Enseignant enseignant) {
		super();
		this.libelleDepartement = libelleDepartement;
		this.codeDepartement = codeDepartement;
		this.college = college;
		this.enseignant = enseignant;
	}
	
	public Departement(int id) {
		super();
		this.id = id;
	}
	public Departement(int id, String libelleDepartement, String codeDepartement) {
		super();
		this.id = id;
		this.libelleDepartement = libelleDepartement;
		this.codeDepartement = codeDepartement;
	}
	public Departement(int id, String libelleDepartement, String codeDepartement, College college,
			Enseignant enseignant) {
		super();
		this.id = id;
		this.libelleDepartement = libelleDepartement;
		this.codeDepartement = codeDepartement;
		this.college = college;
		this.enseignant = enseignant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelleDepartement() {
		return libelleDepartement;
	}
	public void setLibelleDepartement(String libelleDepartement) {
		this.libelleDepartement = libelleDepartement;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	@Override
	public String toString() {
		return "Departement [id=" + id + ", libelleDepartement=" + libelleDepartement + ", codeDepartement="
				+ codeDepartement + ", college=" + college + ", enseignant=" + enseignant + "]";
	}
	
	
	
	

}
