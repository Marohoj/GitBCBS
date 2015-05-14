package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCon;
import db.Users;

public class AdminMethod {
	
	private static DBCon dbcon;

	public static void showUsers() {
		
		System.out.println("Metode for visnig af brugere");
		
	}
	
	public static void createUser() throws SQLException {
		
		dbcon = new DBCon();
		
		ResultSet rs = dbcon.createUser.executeQuery();

		try {
			
			rs.moveToInsertRow();
			rs.updateString     (1, "Alex");
			rs.insertRow();

			rs.beforeFirst();			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Metode for ny bruger");
		
	}
	
	public static void deleteUser() {
		
		System.out.println("Metode for slet bruger");
		
	}
	
}
