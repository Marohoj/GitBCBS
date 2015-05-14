package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Statement;

import db.Configurations;

public class UserMetode {
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	
	
	
	IndstBc insertBC = new IndstBc();
	private static Configurations cf = new Configurations();

	
	public static void insert() {

			
		try {
			myConn = DriverManager.getConnection("jdbs:mysql:" + cf.getHost() + ":" + cf.getPort() + "/" + cf.getDBname());
			
			myStmt = 
			String sql = "update balance "
					+ "where first_name =" + get.IndstBC   ;
		
		myStmt.executeUpdate(sql);
		
		System.out.println("update complete");
		
		
		}
	}
	

}
