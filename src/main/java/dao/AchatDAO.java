package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Achat;

public class AchatDAO {
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
	
	public ArrayList<Achat> ListerAchat() throws SQLException, InstantiationException, IllegalAccessException {
		Connection connect;
    	connect = connectDB();
    	
    	ArrayList<Achat> achats = new ArrayList<Achat>();
    	String sql = "select * from achat";
    	
    	PreparedStatement statement = connect.prepareStatement(sql);
    	ResultSet result = statement.executeQuery();
    	
    	while(result.next()) {
    		String designation = result.getString("designation");
    		int quantite = result.getInt("quantite");
    		String date = result.getString("date");
    		
    		Achat achat = new Achat(designation, quantite, date);
    		achats.add(achat);
    	}
    	statement.close();
    	result.close();
		
		return achats;
		
	}

	public void ajouterAchat(Achat achat) throws InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Connection connect;
    	connect = connectDB();
    	
    	String sql = "insert into achat(designation,quantite,date) values (?,?,?)";
    	PreparedStatement statement = connect.prepareStatement(sql);
    	statement.setString(1, achat.getDesignation());
    	statement.setInt(2, achat.getQuantite());
    	statement.setString(3, achat.getDate());
    	
    	statement.execute();
    	
    	statement.close();
	}
	
	
}
