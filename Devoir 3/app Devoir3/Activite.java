public class Activite {
	private String nom;
	private String typeDechet;
	private int note;
	
	public Activite(String nom, String typeDechet, int note) {
		this.nom = nom;
		this.typeDechet = typeDechet;
		this.note = note;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return typeDechet;
	}
	public void setType(String typeDechet) {
		this.typeDechet = typeDechet;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	
}
