package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.IndstBc;
import gui.Screen;

public class UserMethod {
	
	private static Screen screen;


	
	
	
	
	public static void deposit() {
		
		screen = new Screen();
		
			screen.getIndstBc().getTfAmount().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				String value = screen.getIndstBc().getTfAmount().getText();
				screen.getIndstBc().getLblTest().setText("Test " + value);
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
