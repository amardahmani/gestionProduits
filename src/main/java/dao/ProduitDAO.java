package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Produit;

public class ProduitDAO{
	
	public Connection connectDB() throws InstantiationException, IllegalAccessException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionProduit", "root", "MAC987cvb--");
			System.out.println("Connection avec succes a la base de donnees !");
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver non chargé...");
		} catch (SQLException sqlex) {
			System.out.println("Incapable de connecter a la base de donnees...");
		}
		return connection;

	}
	
	
    
    
    public void ajouterProduit(Produit produit) throws Exception{
    	Connection connect;
    	connect = connectDB();
    	
    	String sql = "INSERT INTO Produit(designation,quantite_stock) values (?,?)";
    	//Preparation de la requête qui va être envoyé à la base de données
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setString(1, produit.getDesignation());
    	statement.setInt(2, produit.getQuantite());
    	//exécuter la requête sql
    	statement.execute();
    	//fermer la connexion
    	statement.close();
    }
    
    public Integer getProduitID(String designation) throws Exception{
    	Connection connect;
    	connect = connectDB();
    	String sql = "SELECT numero_produit from Produit where designation=?";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setString(1, designation);
    	ResultSet result = statement.executeQuery();
    	int numero = result.getInt("numero_produit");
    	statement.close();
    	result.close();
    	
    	return numero;
    	
    }
    
    public ArrayList<Produit> listerProduits() throws Exception {
    	Connection connect;
    	connect = connectDB();
    	ArrayList<Produit> produits = new ArrayList<>();
    	String sql = "SELECT * FROM Produit";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	ResultSet results = statement.executeQuery();
    	
    	while(results.next()) {
    		int numero = results.getInt("numero_produit");
    		String designation = results.getString("designation");
    		int quantite = results.getInt("quantite_stock");
    		
    		Produit produit = new Produit(numero,designation,quantite);
    		produits.add(produit);
    	}
    	
    	statement.close();
    	results.close();
    	
    	return produits;
    }
    
    public Produit getProduit(int id) throws SQLException, InstantiationException, IllegalAccessException{
    	
    	Connection connect;
    	connect = connectDB();
    	Produit produit = new Produit();
    	
    	String sql = "SELECT * from Produit where numero_produit=?";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setInt(1, id);
    	ResultSet result = statement.executeQuery();
    	
    	while(result.next()) {
    		int numero = result.getInt("numero_produit");
    		String designation = result.getString("designation");
    		int quantite = result.getInt("quantite_stock");
    		
    		produit.setNumero(numero);
    		produit.setQuantite(quantite);
    		produit.setDesignation(designation);
    	}
    	
    	return produit;
    }
    
    
    public void supprimerProduit(int numero) throws SQLException, InstantiationException, IllegalAccessException {
    	Connection connect;
    	connect = connectDB();
    	
    	String sql = "delete from Produit where numero_produit = ?";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setInt(1, numero);
    	statement.execute();
    	statement.close();
    	
    }



	public void modifierProduit(Produit produit) throws InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Connection connect;
    	connect = connectDB();
    	
    	String sql = "update Produit set designation=?, quantite_stock = ? where numero_produit=?";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setString(1, produit.getDesignation());
    	statement.setInt(2, produit.getQuantite());
    	statement.setInt(3, produit.getNumero());
    	
    	statement.execute();
    	
    	statement.close();
	}
	
	public void produitAchat(int quantite,String designation) throws InstantiationException, IllegalAccessException, SQLException {
		Connection connect;
    	connect = connectDB();
    	
    	String sql = "update Produit set quantite_stock = quantite_stock+? where designation=?";
    	
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setInt(1, quantite);
    	statement.setString(2, designation);
    	
    	statement.execute();
    	
    	statement.close();
	}
	
	public ArrayList<String> listDesignation() throws InstantiationException, IllegalAccessException, SQLException{
		Connection connect;
    	connect = connectDB();
    	
		ArrayList<String> designations = new ArrayList<String>();
		
		String sql = "select designation from Produit";
		PreparedStatement statement = connect.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			String designation = result.getString("designation");
			designations.add(designation);
		}
		
		statement.close();
		result.close();
		
		return designations;
	}
	
}
