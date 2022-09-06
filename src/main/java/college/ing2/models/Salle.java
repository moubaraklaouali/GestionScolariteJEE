package college.ing2.models;

public class Salle {
	
	private int id ;
	private String libelleSalle;
	private int nbPlace;
	public Salle() {
		super();
	}
	public Salle(int id, String libelleSalle, int nbPlace) {
		super();
		this.id = id;
		this.libelleSalle = libelleSalle;
		this.nbPlace = nbPlace;
	}
	public Salle(String libelleSalle, int nbPlace) {
		super();
		this.libelleSalle = libelleSalle;
		this.nbPlace = nbPlace;
	}
	public Salle(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelleSalle() {
		return libelleSalle;
	}
	public void setLibelleSalle(String libelleSalle) {
		this.libelleSalle = libelleSalle;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	@Override
	public String toString() {
		return "Salle [id=" + id + ", libelleSalle=" + libelleSalle + ", nbPlace=" + nbPlace + "]";
	}
	
	

}
