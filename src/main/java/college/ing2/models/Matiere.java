package college.ing2.models;

public class Matiere {
	private int id;
	private String libelleMatiere;
	private String codeMatiere;
	private Salle salle;
	public Matiere() {
		super();
	}
	public Matiere(int id, String libelleMatiere, String codeMatiere, Salle salle) {
		super();
		this.id = id;
		this.libelleMatiere = libelleMatiere;
		this.codeMatiere = codeMatiere;
		this.salle = salle;
	}
	
	
	public Matiere(int id) {
		super();
		this.id = id;
	}
	public Matiere(int id, String libelleMatiere, String codeMatiere) {
		super();
		this.id = id;
		this.libelleMatiere = libelleMatiere;
		this.codeMatiere = codeMatiere;
	}
	public Matiere(String libelleMatiere, String codeMatiere, Salle salle) {
		super();
		this.libelleMatiere = libelleMatiere;
		this.codeMatiere = codeMatiere;
		this.salle = salle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelleMatiere() {
		return libelleMatiere;
	}
	public void setLibelleMatiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}
	public String getCodeMatiere() {
		return codeMatiere;
	}
	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelleMatiere=" + libelleMatiere + ", codeMatiere=" + codeMatiere + ", salle="
				+ salle + "]";
	}
	
	

}
