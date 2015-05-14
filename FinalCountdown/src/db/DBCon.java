package db;

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

	private static String sqlUrl = "jdbc:mysql://" + cf.getHost() + ":" + cf.getPort() + "/" + cf.getDBname();
	private static String sqlUser = cf.getUsername();
	private static String sqlPassword = cf.getPassword();
	private static String sqlDriver = "com.mysql.jdbc.Driver";

	private PreparedStatement selectAllUsers = null;
	private PreparedStatement selectAdmin = null;
	private PreparedStatement createUser = null;
	private PreparedStatement deleteUser = null;
	private PreparedStatement updateExchange = null;
	private PreparedStatement richOverview = null;
	private PreparedStatement poorOverview = null;
	
	private PreparedStatement depositBc = null;
	private PreparedStatement withdrawBc = null;
	private PreparedStatement transferBc = null;
	

	ResultSet resultSet = null;
	Statement statement = null;	
	Connection conn = null;

	public void DBCon(){

		try { 
			Class.forName(sqlDriver);
			conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
			statement = conn.createStatement();
			selectAllUsers = conn.prepareStatement("SELECT * FROM Users");
			selectAdmin = conn.prepareStatement("SELECT * FROM Admin");
			createUser = conn.prepareStatement("INSERT INTO Users (Name, Username, Password, Balance) VALUES = ?, ?, ?, ?");
			deleteUser = conn.prepareStatement("DELETE FROM Users WHERE first_name = ?, last_name = ?, initials = ?, password = ?");
			updateExchange = conn.prepareStatement ("");
			richOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance DESC");
			poorOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance ASC");
			
			depositBc = conn.prepareStatement("UPDATE Users SET balance = balance + ? WHERE initials = ?");
			withdrawBc = conn.prepareStatement("UPDATE Users SET balance WHERE initials = ?");
			transferBc = conn.prepareStatement("UPDATE Users SET balance = balance + ? WHERE initials = ?");
			
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

				ul.add(new Users(resultSet.getString("initials"),
						//resultSet.getString("first_name"), 
						//resultSet.getString("last_name"),
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

