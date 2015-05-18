package db;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import db.Users;

public class DBCon {

	private static Configurations cf = new Configurations();	

	//Henter data fra config.json for at oprette forbindelse til database
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
	private PreparedStatement poorOverview = null;
	
	//Statements for Users
	public PreparedStatement selectCredit = null;
	private PreparedStatement deposit = null;
	private PreparedStatement withdraw = null;
	private PreparedStatement transfer = null;
	private PreparedStatement userByName = null;
	private PreparedStatement getCurrency = null;

	ResultSet resultSet = null;
	Statement statement = null;	
	Connection conn = null;

	public DBCon(){

		try { 
			Class.forName(sqlDriver);
			conn = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
			statement = conn.createStatement();

			selectAllUsers = conn.prepareStatement("SELECT * FROM Users");
			selectAdmin = conn.prepareStatement("SELECT * FROM Admin");
			selectCredit = conn.prepareStatement("SELECT balance FROM users WHERE initials = ?");

			createUser = conn.prepareStatement("INSERT INTO Users (first_name, last_name, initials, password, balance) VALUES (?, ?, ?, ?, 1)");
			deleteUser = conn.prepareStatement("DELETE FROM Users WHERE first_name = ? AND last_name = ? AND initials = ? AND password = ?");
			updateExchange = conn.prepareStatement ("UPDATE Admin SET currency = ?");
			richOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance DESC");
			poorOverview = conn.prepareStatement ("SELECT first_name, last_name, initials, balance FROM Users ORDER BY balance ASC");

			deposit = conn.prepareStatement("UPDATE Users SET balance = ? WHERE initials = ?");
			withdraw = conn.prepareStatement("UPDATE Users SET balance = ? WHERE initials = ?");
			transfer = conn.prepareStatement("UPDATE Users SET balance = ? WHERE initials = ?");
			
			userByName = conn.prepareStatement("SELECT * FROM Users WHERE initials = ?");
			getCurrency = conn.prepareStatement("SELECT Currency FROM Admin WHERE initials =  'adm'");
			
		} 

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Users getUserByName (String username){
		
		Users result = null;
				
		try {
			
			userByName.setString(1, username);
			
			resultSet = userByName.executeQuery();
			
			while (resultSet.next()){
				
				result = new Users(resultSet.getString("Initials"), 
						resultSet.getString("first_name"), 
						resultSet.getString("last_name"),
						resultSet.getString("password"), 
						resultSet.getDouble("balance"),
						getCurrency());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	public void depositUser(Double balance, String initials){

		try {
			deposit.setDouble(1, balance);
			deposit.setString(2, initials);
			deposit.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void withdrawUser(Double balance, String initials){

		try {
			withdraw.setDouble(1, balance);
			withdraw.setString(2, initials);
			withdraw.executeUpdate();

			System.out.println("Done");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void transferUser(Double balance, String initials){

		try {
			transfer.setDouble(1, balance);
			transfer.setString(2, initials);
			transfer.executeUpdate();

			System.out.println("Done");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateExchange(Double currency){
		
		try {
			updateExchange.setDouble(1, currency);
			updateExchange.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}

	public void createUser(String firstname, String lastname, String initials, String password){

		try {
			createUser.setString(1, firstname);
			createUser.setString(2, lastname);
			createUser.setString(3, initials);
			createUser.setString(4, password);
			createUser.executeUpdate();

			JOptionPane.showMessageDialog(null, "The user is now in the system!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please fill out the formular");
		}

	}

	public void deleteUser(String firstname, String lastname, String initials, String password){

		try {
			deleteUser.setString(1, firstname);
			deleteUser.setString(2, lastname);
			deleteUser.setString(3, initials);
			deleteUser.setString(4, password);
			deleteUser.executeUpdate();

			JOptionPane.showMessageDialog(null, "The user is deleted from the system!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void overview(){
			
		try {
			richOverview.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double getCurrency() throws SQLException{
		
		double ex = 0;
		resultSet = getCurrency.executeQuery();
		
		while (resultSet.next()){
			
			ex = resultSet.getDouble("Currency");
		}
		
		return ex;
	}
	
	public List<Users> getUser(){
		List<Users> ul = null;
		ResultSet resultSet;
		try {
			resultSet = selectAllUsers.executeQuery();
			ul = new ArrayList<Users>();
			while (resultSet.next()) {
				ul.add(new Users(resultSet.getString("first_name"), 
						resultSet.getString("last_name"),
						resultSet.getString("initials"),
						resultSet.getString("password"), 
						resultSet.getDouble("balance"),
						getCurrency()));
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

