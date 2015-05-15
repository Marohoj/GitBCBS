package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import db.DBCon;
import gui.IndstBc;
import gui.Screen;

public class UserMethod {
	
	private static Screen screen;
	private static DBCon dbcon;
	
	public static void deposit() {
		
		screen = new Screen();
		
			screen.getIndstBc().getTfAmount().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				String value = screen.getIndstBc().getTfAmount().getText();
				screen.getIndstBc().getLblTest().setText("Test " + value);
			}
		});
		
	}
	
	public static void withdraw() {
		
		System.out.println("Metode for hæve");
	}
	
	public static void transfer() {
			
		System.out.println("Metode for overføre");
	}


}
