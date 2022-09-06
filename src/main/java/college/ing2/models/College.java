package college.ing2.models;

public class College {
	private int id;
	private String nomCollege;
	private String siteWeb;
	public College() {
		super();
	}
	public College(int id, String nomCollege, String siteWeb) {
		super();
		this.id = id;
		this.nomCollege = nomCollege;
		this.siteWeb = siteWeb;
	}
	
	
	public College(int id) {
		super();
		this.id = id;
	}
	public College(String nomCollege, String siteWeb) {
		super();
		this.nomCollege = nomCollege;
		this.siteWeb = siteWeb;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomCollege() {
		return nomCollege;
	}
	public void setNomCollege(String nomCollege) {
		this.nomCollege = nomCollege;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", nomCollege=" + nomCollege + ", siteWeb=" + siteWeb + "]";
	}
	

}
