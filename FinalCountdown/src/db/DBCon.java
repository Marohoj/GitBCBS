package db;

import gui.NyBruger;
import gui.Screen;
import gui.SletBruger;

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
	private static String sqlUser = cf.getUsername();
	private static String sqlPassword = cf.getPassword();
	private static String sqlDriver = "com.mysql.jdbc.Driver";

	//Statements til dannelse af database
	private PreparedStatement selectAllUsers = null;
	private PreparedStatement selectAdmin = null;
	
	//Statements for Admin	
	public PreparedStatement createUser = null;
	public PreparedStatement deleteUser = null;
	private PreparedStatement updateExchange = null;
	private PreparedStatement richOverview = null;
	
	//Statements for Users
	private PreparedStatement poorOverview = null;
	private PreparedStatement selectCredit = null;
	private PreparedStatement indstBc = null;
	private PreparedStatement hvBc = null;
	private PreparedStatement transBc = null;
	
	private Screen screen;
	private NyBruger nybruger;
	private SletBruger sletbruger;
	
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
			selectCredit = conn.prepareStatement("SELECT balance FROM users WHERE initials = ?;");
			createUser = conn.prepareStatement("INSERT INTO Users (first_name, last_name, initials, password, balance) VALUES (?, ?, ?, ?, 1);");
			deleteUser = conn.prepareStatement("DELETE FROM Users WHERE first_name = ?, last_name = ?, initials = ?, password = ?;");
			updateExchange = conn.prepareStatement ("UPDATE Admin SET currency = ?");
			richOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance DESC");
			poorOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance ASC");
			
			indstBc = conn.prepareStatement("UPDATE Users SET balance = ? WHERE initials = ?");
			hvBc = conn.prepareStatement("UPDATE Users SET balance WHERE initials = ?");
			transBc = conn.prepareStatement("UPDATE Users SET balance = ? WHERE initials = ?");
		} 

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Users> getUsers(){
		List<Users> ul = null;
		ResultSet resultSet = null;
		try {
			resultSet = selectAllUsers.executeQuery();
			ul = new ArrayList<Users>();
			while (resultSet.next()) {

				ul.add(new Users(resultSet.getString("first_name"), 
						resultSet.getString("last_name"),
						resultSet.getString("initials"),
						resultSet.getString("password"), 
						resultSet.getDouble("balance")));
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
				
				al.add(new Admin(resultSet.getString("initials"),
						resultSet.getString("password"),
						resultSet.getString("name"),
						resultSet.getDouble("currency")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}

}

