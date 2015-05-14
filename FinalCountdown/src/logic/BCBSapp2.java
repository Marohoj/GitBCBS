package logic;

import gui.NyBruger;
import gui.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import db.Admin;
import db.DBCon;
import db.Users;

public class BCBSapp2 {

	private Screen screen;
	private DBCon dbcon;
	private NyBruger nybruger;

	public BCBSapp2(){
		//instansierer objekter

		screen = new Screen();
		dbcon = new DBCon();

		screen.setVisible(true);
	}

	public void run(){

		dbcon.DBCon();
		screen.show(Screen.LOGIN);

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getUserMenu().addActionListener(new UserMenuActionListener());
		screen.getAdminMenu().addActionListener(new AdminMenuActionListener());

		screen.getIndstBc().addActionListener(new IndstActionListener());
		screen.getHvBc().addActionListener(new HvActionListener());
		screen.getTransBc().addActionListener(new TransActionListener());
		screen.getNyBruger().addActionListener(new CreateActionListener());
		screen.getSletBruger().addActionListener(new DeleteActionListener());
		screen.getVisBruger().addActionListener(new ShowActionListener());
	}

	public boolean auth(){
		boolean UserAuth = false;

		String initials = screen.getLogin().getTfUsername().getText();
		String password = screen.getLogin().getTfPassword().getText();

		for (Users users: dbcon.getUsers()){

			if (users.getInitials().equals(initials) && users.getPassword().equals(password)){

				System.out.println("Welcome to the Bitcoin ATM");

				UserAuth = true;
			}

		}

		return UserAuth;
	}

	public boolean ad_auth(){
		boolean AdminAuth = false;

		String initials = screen.getLogin().getTfUsername().getText();
		String password = screen.getLogin().getTfPassword().getText();

		for  (Admin admin : dbcon.getAdmin()){

			if (admin.getInitials().equals(initials) && admin.getPassword().equals(password)){

				System.out.println("Welcome to the Bitcoin ATM");

				AdminAuth = true;
			}

		}

		return AdminAuth;
	}
	
	private class LoginActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getLogin().getBtnLogin()){

				if (auth()) {
					screen.getUserMenu().getLblBruger().setText("User: " + screen.getLogin().getTfUsername().getText());
					//screen.getUserMenu().getLblSaldo().setText("Credit: " + dbcon.getLogin().getTfPassword().getText());
					screen.show(Screen.USERMENU);
				}

				else if (ad_auth()) {
					screen.getAdminMenu().getLblBruger().setText("User: " + screen.getLogin().getTfUsername().getText());
					screen.show(Screen.ADMINMENU);
				}

				else {
					JOptionPane.showMessageDialog(null, "Forkert Brugernavn/Password. Prøv igen!");
				}

			}

			else if (e.getSource() == screen.getLogin().getBtnAfslut()){
				System.exit(0);
			}

		}

	}

	private class AdminMenuActionListener implements ActionListener{

		public void actionPerformed (ActionEvent e ){

			if (e.getSource() == screen.getAdminMenu().getBtnLogUd()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnVisBrugere()){
				screen.show(Screen.VIS);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnOpretBruger()){
				screen.show(Screen.OPRET);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnSletBruger()){
				screen.show(Screen.SLET);
			}
		}
	}

	private class UserMenuActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getUserMenu().getBtnLogUd()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);				
			}

			else if (e.getSource() == screen.getUserMenu().getBtnIndstBc()){
				screen.show(Screen.INDSTBC);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnHvBc()){
				screen.show(Screen.HVBC);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnOverfrBc()){
				screen.show(Screen.TRANS);
			}

		}

	}

	private class IndstActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getIndstBc().getBtnLogUd()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
				
			}

			else if (e.getSource() == screen.getIndstBc().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getIndstBc().getBtnIndst()){
				UserMethod.deposit();
			}

		}

	}

	private class HvActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getHvBc().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getHvBc().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getHvBc().getBtnHvBc()){
				screen.show(Screen.USERMENU);
			}
			
		}
		
	}

	private class TransActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getTransBc().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getTransBc().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getTransBc().getBtnTransBc()){
				screen.show(Screen.USERMENU);
			}

		}
		
	}

	private class ShowActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getVisBruger().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getVisBruger().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getVisBruger().getBtnVis()){
				screen.show(Screen.ADMINMENU);
			}
			
		}
		
	}

	private class CreateActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getNyBruger().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getNyBruger().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getNyBruger().getBtnOpret()){
				
				Users newuser = null;
				dbcon.createUser(newuser);
				//nybruger.getUserFirst().getText();
				//nybruger.getUserLast().getText();
				//nybruger.getUserInt().getText();
				//nybruger.getUserPass().getText();
			
			}
		
		}
		
	}

	private class DeleteActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getSletBruger().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getSletBruger().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getSletBruger().getBtnSlet()){
				Users deluser = null;
				dbcon.deleteUser(deluser);
			}
			
		}
	
	}
	
}

	
	
	
	
	
	
	