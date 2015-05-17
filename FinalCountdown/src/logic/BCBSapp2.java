package logic;

import gui.NyBruger;
import gui.Screen;
import gui.TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import db.Admin;
import db.DBCon;
import db.Users;

public class BCBSapp2 {

	private Screen screen;
	private DBCon dbcon;
	private Users currentUser;
	private Users users;
	private TableModel table;
	private AdminMethod adminmethod;
	private UserMethod usermethod;

	public BCBSapp2(){
		//instansierer objekter

		screen = new Screen();
		dbcon = new DBCon();
		table = new TableModel();

		screen.setVisible(true);
	}

	public void run(){

		dbcon.DBCon();
		screen.show(Screen.LOGIN);

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getUserMenu().addActionListener(new UserMenuActionListener());
		screen.getAdminMenu().addActionListener(new AdminMenuActionListener());

		screen.getDepositScreen().addActionListener(new DepositActionListener());
		screen.getWithdrawScreen().addActionListener(new HvActionListener());
		screen.getTransferScreen().addActionListener(new TransActionListener());
		
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
				currentUser = users;
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
					screen.getUserMenu().getLblBruger().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
					screen.getUserMenu().getLblSaldo().setText("Credit: " + currentUser.getBalance() + " BC");
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

			else if (e.getSource() == screen.getUserMenu().getBtnDeposit()){
				screen.show(Screen.DEPOSIT);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnWithdraw()){
				screen.show(Screen.WITHDRAW);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnTransfer()){
				screen.show(Screen.TRANSFER);
			}

		}

	}
	
	private class DepositActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getDepositScreen().getBtnLogUd()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
				
			}

			else if (e.getSource() == screen.getDepositScreen().getBtnHjem()){
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getDepositScreen().getBtnDeposit()){
				
				
				Double balance = getCurrentUser().getBalance() + screen.getDepositScreen().getTfAmount().getText();
				String initials = getCurrentUser().getInitials();
				
				dbcon.depositUser(balance, initials);
			}

		}

	}

	private class HvActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getWithdrawScreen().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getWithdrawScreen().getBtnHjem()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getWithdrawScreen().getBtnWithdraw()){
				
				Double balance = getCurrentUser().getBalance() - screen.getWithdrawScreen().getTfAmount().getText();
				String initials = getCurrentUser().getInitials();
			
				dbcon.withdrawUser(balance, initials);
			}
			
		}
		
	}

	private class TransActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getTransferScreen().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getTransferScreen().getBtnHjem()){
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getTransferScreen().getBtnTransfer()){
				
				Double balance = screen.getTransferScreen().getTfAmount().getText();
				String initials = screen.getTransferScreen().getTfTransUser().getText();
				
				dbcon.transferUser(balance, initials);
				
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
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getVisBruger().getBtnVis()){
				
				table.TableModel1();
				screen.show(Screen.VIS);
			}
			
		}
		
	}

	public class CreateActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getNyBruger().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getNyBruger().getBtnHjem()){
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getNyBruger().getBtnOpret()){
				
				String firstname = screen.getNyBruger().getUserFirst().getText();
				String lastname = screen.getNyBruger().getUserLast().getText();
				String initials = screen.getNyBruger().getUserInit().getText();
				String password = screen.getNyBruger().getUserPass().getText();
	
				dbcon.createUser(firstname, lastname, initials, password);
			
			}
		
		}
		
	}

	public class DeleteActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getSletBruger().getBtnLogud()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getSletBruger().getBtnHjem()){;
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getSletBruger().getBtnSlet()){
				
				String firstname = screen.getSletBruger().getUserFirst().getText();
				String lastname = screen.getSletBruger().getUserLast().getText();
				String initials = screen.getSletBruger().getUserInit().getText();
				String password = screen.getSletBruger().getUserPass().getText();
			
				dbcon.deleteUser(firstname, lastname, initials, password);
			}
			
		}
	
	}
	
	public Users getCurrentUser() {
		return currentUser;
	} 
	
}

	
	
	
	
	
	
	