package model;

public class Achat {
	String designation;
	int quantite;
	String date;
	public Achat(String designation, int quantite, String date) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.date = date;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
