package BCBS.data;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {

	private static String sqlUrl = "jdbc:mysql://localhost:3306/bcbs";
	private static String sqlUser = "root";
	private static String sqlPassword = "MySQL123";
	private static String sqlDriver = "com.mysql.jdbc.Driver";

	private PreparedStatement selectAllUsers = null;
	private PreparedStatement selectAdmin = null;
	private PreparedStatement executeUpdate = null;
	private PreparedStatement createUser = null;
	private PreparedStatement deleteUser = null;
	private PreparedStatement updateExchange = null;
	private PreparedStatement richOverview = null;
	private PreparedStatement poorOverview = null;
	
	private PreparedStatement indstBc = null;
	private PreparedStatement hvBc = null;
	private PreparedStatement transBc = null;
	

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
			
			indstBc = conn.prepareStatement("INSERT INTO Users (balance) VALUES = ?");
			hvBc = conn.prepareStatement("INSERT INTO Users (balance) VALUES = ? ");
			transBc = conn.prepareStatement("INSERT INTO Users (balance) VALUES = ?");
			
			
			System.out.println("Connection Successful");		
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
