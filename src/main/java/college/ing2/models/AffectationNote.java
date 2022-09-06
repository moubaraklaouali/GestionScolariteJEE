package college.ing2.models;

public class AffectationNote {
	private int id;
	private int note;
	private Matiere matiere;
	private Etudiant etudiant;
	public AffectationNote() {
		super();
	}
	public AffectationNote(int note, Matiere matiere, Etudiant etudiant) {
		super();
		this.note = note;
		this.matiere = matiere;
		this.etudiant = etudiant;
	}
	public AffectationNote(int id, int note, Matiere matiere, Etudiant etudiant) {
		super();
		this.id = id;
		this.note = note;
		this.matiere = matiere;
		this.etudiant = etudiant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "AffectationNote [id=" + id + ", note=" + note + ", matiere=" + matiere + ", etudiant=" + etudiant + "]";
	}
	
	

}
