package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDAO {
	
	public AdminDAO() {
		
	}
	
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

	public Admin checkLogin(String username,String password) throws InstantiationException, IllegalAccessException, SQLException {
		Connection connect;
    	connect = connectDB();
    	
    	String sql = "select * from admin where username=? and password=?";
    	
    	PreparedStatement statement = connect.prepareStatement(sql);
    	
    	statement.setString(1, username);
    	statement.setString(2, password);
    	
    	Admin admin = new Admin();
    	
    	ResultSet result = statement.executeQuery();
    	while(result.next()) {
    		String nomUtilisateur = result.getString("username");
    		String motDePasse = result.getString("password");
    		
    		admin.setUsername(nomUtilisateur);
    		admin.setPassword(motDePasse);
    	}
    	
    	return admin;
	}
}
