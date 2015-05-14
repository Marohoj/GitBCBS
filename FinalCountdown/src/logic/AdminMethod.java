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
			
	public static void nyUser(Users newUser){
			
			try {
				dbcon.createUser.setString(1, "lol");
				dbcon.createUser.setString(2, "lol");
				dbcon.createUser.setString(3, "lol");
				dbcon.createUser.setString(4, "lol");
				dbcon.createUser.setString(5, "lol");
				
				dbcon.createUser.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Metode for ny bruger");
		
	}
	
	public static void deleteUser() {
		
		System.out.println("Metode for slet bruger");
		
	}
	
}
