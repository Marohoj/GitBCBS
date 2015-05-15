package logic;

import gui.Screen;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCon;
import db.Users;

public class AdminMethod {
	
	private static DBCon dbcon;
	private static Screen screen;

	public static void showUsers() {
		
		System.out.println("Metode for visnig af brugere");
		
	}
			
	public void createUser(Users newUser){
	
		String firstname = screen.getNyBruger().getUserFirst().getText();
		String lastname = screen.getNyBruger().getUserLast().getText();
		String initials = screen.getNyBruger().getUserInit().getText();
		String password = screen.getNyBruger().getUserPass().getText();
		
		try {
			dbcon.createUser.setString(1, firstname);
			dbcon.createUser.setString(2, lastname);
			dbcon.createUser.setString(3, initials);
			dbcon.createUser.setString(4, password);
			dbcon.createUser.setDouble(5, 1.0);
			
			dbcon.createUser.executeUpdate();
			
			System.out.println("Done");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(Users delUser){
				
		String firstname = screen.getSletBruger().getUserFirst().getText();
		String lastname = screen.getSletBruger().getUserLast().getText();
		String initials = screen.getSletBruger().getUserInit().getText();
		String password = screen.getSletBruger().getUserPass().getText();
		
		try {
			dbcon.deleteUser.setString(1, firstname);
			dbcon.deleteUser.setString(2, lastname);
			dbcon.deleteUser.setString(3, initials);
			dbcon.deleteUser.setString(4, password);
			dbcon.deleteUser.setDouble(5, 1.0);
			
			dbcon.deleteUser.executeUpdate();
			
			System.out.println(screen.getSletBruger().getUserInit().getText());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
