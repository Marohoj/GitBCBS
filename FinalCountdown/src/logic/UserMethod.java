package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.IndstBc;
import gui.Screen;

public class UserMethod {
	
	private static Screen screen;

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
	
	
	
	
	public static void deposit() {
		
		screen = new Screen();
		
			screen.getIndstBc().getTfAmount().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				String value = screen.getIndstBc().getTfAmount().getText();
				screen.getIndstBc().getLblTest().setText(value);
			}
		});
		
		//String value = screen.getIndstBc().getTfAmount().getText();
		//screen.getIndstBc().setTfAmount(value);
		
		//System.out.println("Indsætter " + value + " BC");
		
	}
	
	public static void withdraw() {
		
		System.out.println("Metode for hæve");
	}
	
	public static void transfer() {
			
		System.out.println("Metode for overføre");
	}

}
