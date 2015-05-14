package db;

import gui.NyBruger;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Users;

public class DBCon {

	private static Configurations cf = new Configurations();	
	// private static String sqlUrl = "jdbc:mysql://localhost:3306/bcbs";

	private static String sqlUrl = "jdbc:mysql://" + cf.getHost() + ":" + cf.getPort() + "/" + cf.getDBname();
	private static String sqlUser = "root";
	private static String sqlPassword = "MySQL123";
	private static String sqlDriver = "com.mysql.jdbc.Driver";

	private PreparedStatement selectAllUsers = null;
	private PreparedStatement selectAdmin = null;
	public PreparedStatement createUser = null;
	private PreparedStatement deleteUser = null;
	private PreparedStatement updateExchange = null;
	private PreparedStatement richOverview = null;
	private PreparedStatement poorOverview = null;
	
	private PreparedStatement indstBc = null;
	private PreparedStatement hvBc = null;
	private PreparedStatement transBc = null;
	
	private NyBruger nybruger;
	
	ResultSet resultSet = null;
	Statement statement = null;	
	Connection conn = null;;
	
	public void DBCon(){

		try { 
			Class.forName(sqlDriver);
			conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
			statement = conn.createStatement();
			selectAllUsers = conn.prepareStatement("SELECT * FROM Users");
			selectAdmin = conn.prepareStatement("SELECT * FROM Admin");
			createUser = conn.prepareStatement("INSERT INTO Users (first_name, last_name, initials, password, balance) VALUES (?, ?, ?, ?, ?);");
			deleteUser = conn.prepareStatement("DELETE FROM Users WHERE first_name = ?, last_name = ?, initials = ?, password = ?");
			updateExchange = conn.prepareStatement ("");
			richOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance DESC");
			poorOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance ASC");
			
			indstBc = conn.prepareStatement("UPDATE Users SET balance = balance + ? WHERE initials = ?");
			hvBc = conn.prepareStatement("UPDATE Users SET balance WHERE initials = ?");
			transBc = conn.prepareStatement("UPDATE Users SET balance = balance + ? WHERE initials = ?");
			
		} 

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void createUser(Users newUser){
		
		nybruger = new NyBruger();
		
		try {
			createUser.setString(1, nybruger.getUserFirst().getText());
			createUser.setString(2, nybruger.getUserLast().getText());
			createUser.setString(3, nybruger.getUserInt().getText());
			createUser.setString(4, nybruger.getUserPass().getText());
			createUser.setString(5, "100 BC");
			
			createUser.executeUpdate();
			
			System.out.println("Done");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public List<Users> getUsers(){
		List<Users> ul = null;
		ResultSet resultSet = null;
		try {
			resultSet = selectAllUsers.executeQuery();
			ul = new ArrayList<Users>();
			while (resultSet.next()) {

				ul.add(new Users(resultSet.getString("initials"),
						resultSet.getString("first_name"), 
						resultSet.getString("last_name"),
						resultSet.getString("password"), 
						resultSet.getString("balance")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ul;	
	}
	
	public List<Admin> getAdmin(){
		List<Admin> al = null;
		ResultSet resultSet = null;
		try {
			resultSet = selectAdmin.executeQuery();
			al = new ArrayList<Admin>();
			while (resultSet.next()) {
				
				al.add(new Admin(resultSet.getString("name"),
						resultSet.getString("password"),
						resultSet.getString("balance")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}

}

