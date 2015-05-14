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
			createUser = conn.prepareStatement("INSERT INTO Users (first_name, last_name, initials, password, balance) VALUES (?, ?, ?, ?, ?);");
			deleteUser = conn.prepareStatement("DELETE FROM Users WHERE first_name = '';");
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
		
		screen = new Screen();
		
		String firstname = screen.getNyBruger().getUserFirst().getText();
		String lastname = screen.getNyBruger().getUserLast().getText();
		String initials = screen.getNyBruger().getUserInit().getText();
		String password = screen.getNyBruger().getUserPass().getText();
		
		
		try {
			createUser.setString(1, firstname);
			createUser.setString(2, lastname);
			createUser.setString(3, initials);
			createUser.setString(4, password);
			createUser.setDouble(5, 1.0);
			
			createUser.executeUpdate();
			
			System.out.println("Done");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(Users delUser){
		
		sletbruger = new SletBruger();
		
		String firstname = screen.getSletBruger().getUserFirst().getText();
		String lastname = screen.getSletBruger().getUserLast().getText();
		String initials = screen.getSletBruger().getUserInit().getText();
		String password = screen.getSletBruger().getUserPass().getText();
		
		try {
			deleteUser.setString(1, firstname);
			deleteUser.setString(2, lastname);
			deleteUser.setString(3, initials);
			deleteUser.setString(4, password);
			deleteUser.setDouble(5, 1.0);
			
			deleteUser.executeUpdate();
			
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

