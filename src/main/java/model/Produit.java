package model;

public class Produit {
	int numero;
	String designation;
	int quantite;
	
	public Produit() {
		
	}
	
	
	
	public Produit(int numero, String designation, int quantite) {
		super();
		this.numero = numero;
		this.designation = designation;
		this.quantite = quantite;
	}



	public Produit(String designation, int quantite) {
		super();
		this.designation = designation;
		this.quantite = quantite;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	
}
