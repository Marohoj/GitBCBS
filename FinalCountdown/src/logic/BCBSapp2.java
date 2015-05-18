package logic;

import gui.CreateScreen;
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
	private Users currentUser;
	private Admin currentAdmin;
	private ModelTabel table;

	public BCBSapp2(){
		
		//instansierer objekter
		screen = new Screen();
		dbcon = new DBCon();
		table = new ModelTabel();

		screen.setVisible(true);;
	}

	public void run(){

		screen.show(Screen.LOGIN);

		screen.getLogin().addActionListener(new LoginActionListener());
		screen.getUserMenu().addActionListener(new UserMenuActionListener());
		screen.getAdminMenu().addActionListener(new AdminMenuActionListener());

		screen.getDepositScreen().addActionListener(new DepositActionListener());
		screen.getWithdrawScreen().addActionListener(new WithdrawActionListener());
		screen.getTransferScreen().addActionListener(new TransActionListener());
		
		screen.getCreateScreen().addActionListener(new CreateActionListener());
		screen.getDeleteScreen().addActionListener(new DeleteActionListener());
		screen.getViewScreen().addActionListener(new ViewActionListener());
	}

	public boolean auth(){
		boolean UserAuth = false;

		String initials = screen.getLogin().getTfUsername().getText();
		String password = screen.getLogin().getTfPassword().getText();

		for (Users users: dbcon.getUser()){

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
				currentAdmin = admin;
				AdminAuth = true;
			}

		}

		return AdminAuth;
	}
	
	private class LoginActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getLogin().getBtnLogin()){

				if (auth()) {
					screen.getUserMenu().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
					screen.getUserMenu().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
					screen.show(Screen.USERMENU);
				}

				else if (ad_auth()) {
					screen.getAdminMenu().getLblUser().setText("User: " + screen.getLogin().getTfUsername().getText());
					screen.getAdminMenu().getLblCurrentEx().setText("Current Exchangerate: " + currentAdmin.getCurrency());			
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

			if (e.getSource() == screen.getAdminMenu().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}
			
			else if (e.getSource() == screen.getAdminMenu().getBtnExchange()){
				
				Double cur = new Double(screen.getAdminMenu().getTfExchange().getText());
				String text = screen.getAdminMenu().getTfExchange().getText();	
				
				double currency = cur.parseDouble(text);
							
				dbcon.updateExchange(currency);
				
				screen.getAdminMenu().getTfExchange().setText("");
				screen.getAdminMenu().getLblCurrentEx().setText("Current Exchangerate: " + currency);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnViewUsers()){	
				inJTable();
				screen.show(Screen.VIEW);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnCreateUser()){
				screen.show(Screen.CREATE);
			}

			else if (e.getSource() == screen.getAdminMenu().getBtnDeleteUser()){
				screen.show(Screen.DELETE);
			}
		}
	}
	
	public void inJTable(){
		
		screen.getViewScreen().getTbUser().setModel(table);
		screen.getViewScreen().getTbUser().setRowHeight(25);
		screen.getViewScreen().getTbUser().setColumnSelectionAllowed(true);
		screen.getViewScreen().getTbUser().setCellSelectionEnabled(true);
		
	}

	private class UserMenuActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getUserMenu().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);				
			}

			else if (e.getSource() == screen.getUserMenu().getBtnDeposit()){
				screen.getDepositScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getDepositScreen().getLblBalance().setText("Credit: " + currentUser.getBalance() + " BC");
				screen.show(Screen.DEPOSIT);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnWithdraw()){
				screen.getWithdrawScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getWithdrawScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.WITHDRAW);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnTransfer()){
				screen.getTransferScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getTransferScreen().getLblBalance().setText("Credit: " + currentUser.getBalance() + " BC");
				screen.show(Screen.TRANSFER);
			}

		}

	}
	
	private class DepositActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getDepositScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getDepositScreen().getBtnHome()){
				screen.getDepositScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getDepositScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getDepositScreen().getBtnDeposit()){
				
				Double bal = new Double(screen.getDepositScreen().getTfAmount().getText());
				String text = screen.getDepositScreen().getTfAmount().getText();
				
				double balance = (currentUser.getBalance() + bal.parseDouble(text));
					
				String initials = getCurrentUser().getInitials();
				
				dbcon.depositUser(balance, initials);
				
				screen.getDepositScreen().getLblBalance().setText("Balance: " + balance + " BC");
				screen.getDepositScreen().getTfAmount().setText("");				
			}

		}

	}

	private class WithdrawActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getWithdrawScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getWithdrawScreen().getBtnHome()){
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getWithdrawScreen().getBtnWithdraw()){
								
				Double bal = new Double(screen.getWithdrawScreen().getTfAmount().getText());
				String text = screen.getWithdrawScreen().getTfAmount().getText();
				
				double balance = (currentUser.getBalance() - bal.parseDouble(text));
				
				String initials = getCurrentUser().getInitials();
			
				dbcon.withdrawUser(balance, initials);
				
				screen.getWithdrawScreen().getLblBalance().setText("Balance: " + balance + " BC");
				screen.getWithdrawScreen().getTfAmount().setText("");
			}
			
		}
		
	}

	private class TransActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getTransferScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getTransferScreen().getBtnHome()){
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getTransferScreen().getBtnTransfer()){
							
				Double bal = new Double(screen.getTransferScreen().getTfAmount().getText());
				String text = screen.getTransferScreen().getTfAmount().getText();
				
				double balance = bal.parseDouble(text);
				
				String initials = screen.getTransferScreen().getTfTransUser().getText();
			
			    dbcon.transferUser(balance, initials);
				
			}

		}
		
	}

	private class ViewActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getViewScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getViewScreen().getBtnHome()){
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getViewScreen().getBtnOverview()){
				//screen.getViewScreen().getTbUser().
			}
			
		}
		
	}

	public class CreateActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getCreateScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getCreateScreen().getBtnHome()){
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getCreateScreen().getBtnCreate()){
				
				String firstname = screen.getCreateScreen().getUserFirst().getText();
				String lastname = screen.getCreateScreen().getUserLast().getText();
				String initials = screen.getCreateScreen().getUserInit().getText();
				String password = screen.getCreateScreen().getUserPass().getText();
	
				dbcon.createUser(firstname, lastname, initials, password);
			
			}
		
		}
		
	}

	public class DeleteActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if (e.getSource() == screen.getDeleteScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			else if (e.getSource() == screen.getDeleteScreen().getBtnHome()){
				screen.show(Screen.ADMINMENU);
			}

			else if (e.getSource() == screen.getDeleteScreen().getBtnDelete()){
				
				String firstname = screen.getDeleteScreen().getUserFirst().getText();
				String lastname = screen.getDeleteScreen().getUserLast().getText();
				String initials = screen.getDeleteScreen().getUserInit().getText();
				String password = screen.getDeleteScreen().getUserPass().getText();
			
				dbcon.deleteUser(firstname, lastname, initials, password);
			}
			
		}
	
	}
	
	public Users getCurrentUser() {
		return currentUser;
	} 
	
}
	