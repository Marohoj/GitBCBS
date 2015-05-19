package logic;

import gui.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import db.Admin;
import db.DBCon;
import db.Users;

public class BCBSapp2 {

	//Declare attributes
	private Screen screen;
	private DBCon dbcon;
	private Users currentUser;
	private Admin currentAdmin;
	private ModelTabel table;
	private Pattern passwordPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z]).{6,8})");
	private Pattern initialsPattern = Pattern.compile("(?=.*[@.]).{1,20}");

	public BCBSapp2(){

		//instantiates objects
		screen = new Screen();
		dbcon = new DBCon();
		table = new ModelTabel();

		screen.setVisible(true);
	}

	/**
	 * This method sets the first panel to be shown when the program is running
	 * and activates all of the ActionListeners for the different panels
	 */
	public void run(){

		//Gets the panel LoginScreen from the the cardlayout
		screen.show(Screen.LOGIN);

		//Handles all the actionevents  for the class LoginScreen 
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

	/**
	 * Method for authenticating User access
	 * @return
	 */
	public boolean auth(){
		//Sets UserAuth as false as standard
		boolean UserAuth = false;

		//Gets values from textfields
		String initials = screen.getLogin().getTfUsername().getText();
		String password = screen.getLogin().getTfPassword().getText();

		//for-loop that runs through the users in the database
		for (Users users: dbcon.getUser()){

			//Checks whether the typed values are equal to the ones in the database and returns UserAuth = true if so
			if (users.getInitials().equals(initials) && users.getPassword().equals(password)){

				//Sets the variable currentUser to be equal the user that logged in
				currentUser = users;
				UserAuth = true;
			}

		}
		//Returns UserAuth to be true or false
		return UserAuth;
	}

	/**
	 * Method for authenticating Admin access
	 * @return
	 */
	public boolean ad_auth(){
		//Sets AdminAuth as false as standard
		boolean AdminAuth = false;

		//Gets values from textfields
		String initials = screen.getLogin().getTfUsername().getText();
		String password = screen.getLogin().getTfPassword().getText();

		//for-loop that runs through the admin database
		for  (Admin admin : dbcon.getAdmin()){

			//Checks whether the typed values are equal to the ones in the database and returns AdminAuth = true if so
			if (admin.getInitials().equals(initials) && admin.getPassword().equals(password)){

				//Sets the variable currentAdmin to be equal the admin that logged in
				currentAdmin = admin;
				AdminAuth = true;
			}

		}
		//Returns AdminAuth to be true or false
		return AdminAuth;
	}

	//Class that implements the ActionListeners for the panel LoginScreen
	private class LoginActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel LoginScreen
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e) {

			//if BtnLogin is pressed
			if (e.getSource() == screen.getLogin().getBtnLogin()){

				//if auth() returns true
				if (auth()) {

					//Gets information about name, balance and exchangerate from the database for the user logged in
					screen.getUserMenu().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
					screen.getUserMenu().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");			
					screen.getUserMenu().getLblExchange().setText("Exchangerate: " + currentUser.getCurrency() + "DKK/BC");
					//Navigates the user to JPanel
					screen.show(Screen.USERMENU);
				}
				//else if ad_auth() returns true 
				else if (ad_auth()) {

					//Gets information about the current exchangerate
					screen.getAdminMenu().getLblCurrentEx().setText("Current Exchangerate: " + currentAdmin.getCurrency());	
					//Navigates the user to JPanel
					screen.show(Screen.ADMINMENU);
				}
				//if neither auth or ad_auth returns true then show message
				else {
					JOptionPane.showMessageDialog(screen, "Wrong username/password. Please try again.");
				}

			}
			//if BtnAfslut is clicked
			else if (e.getSource() == screen.getLogin().getBtnAfslut()){
				//close program
				System.exit(0);
			}

		}

	}
	
	//Class that implements the ActionListeners for the panel AdminMenu
	private class AdminMenuActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel AdminMenu
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed (ActionEvent e ){

			//if BtnLogout is clicked
			if (e.getSource() == screen.getAdminMenu().getBtnLogout()){
				//resets the textfields in LoginScreen
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				//Navigates user to JPanel
				screen.show(Screen.LOGIN);
			}

			//if BtnExchange is clicked
			else if (e.getSource() == screen.getAdminMenu().getBtnExchange()){

				//tries to execute parseDouble
				try {
					//Parses double from textfield to a string
					Double currency = Double.parseDouble(screen.getAdminMenu().getTfExchange().getText());

					//Uses value in prepared statement for method updateExchange
					dbcon.updateExchange(currency);

					//Resets textfield and updates label with exchangerate
					screen.getAdminMenu().getTfExchange().setText("");
					screen.getAdminMenu().getLblCurrentEx().setText("Current Exchangerate: " + currency + "DKK/BC");

					//Catches error if the value typed isn't a double and shows message
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(screen, "Please type a value!");
				}
			}

			//if BtnViewUsers is clicked
			else if (e.getSource() == screen.getAdminMenu().getBtnViewUsers()){	
				//Calls method for JTable over users
				inJTable();
				screen.show(Screen.VIEW);
			}
			//if BtnCreateUser is clicked
			else if (e.getSource() == screen.getAdminMenu().getBtnCreateUser()){
				screen.show(Screen.CREATE);
			}
			//if BtnDeleteUser is clicked
			else if (e.getSource() == screen.getAdminMenu().getBtnDeleteUser()){
				screen.show(Screen.DELETE);
			}
		}
	}

	/**
	 * Method for implementing the JTable in ViewScreen
	 */
	public void inJTable(){

		//Sets the tablemodel to the class ModelTabel
		screen.getViewScreen().getTbUser().setModel(table);
		screen.getViewScreen().getTbUser().setRowHeight(25);
		screen.getViewScreen().getTbUser().setColumnSelectionAllowed(true);
		screen.getViewScreen().getTbUser().setCellSelectionEnabled(true);

	}

	//Class that implements the ActionListeners for the panel UserMenu
	private class UserMenuActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel UserMenu
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e){

			//If BtnLogout clicked
			if (e.getSource() == screen.getUserMenu().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);				
			}
			//If BtnDeposit clicked
			else if (e.getSource() == screen.getUserMenu().getBtnDeposit()){
				//Updates info for JPanel DepositScreen
				screen.getDepositScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getDepositScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.DEPOSIT);
			}
			//If BtnWithdraw clicked
			else if (e.getSource() == screen.getUserMenu().getBtnWithdraw()){
				//Updates info for JPanel WithdrawScreen
				screen.getWithdrawScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getWithdrawScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.WITHDRAW);
			}
			//If BtnTransfer clicked
			else if (e.getSource() == screen.getUserMenu().getBtnTransfer()){
				//Updates info for JPanel TransferScreen
				screen.getTransferScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getTransferScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.TRANSFER);
			}

		}

	}

	//Class that implements the ActionListeners for the panel DepositScreen
	private class DepositActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel DepositScreen
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e){

			//if BtnLogout Clicked
			if (e.getSource() == screen.getDepositScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			//if BtnHome clicked
			else if (e.getSource() == screen.getDepositScreen().getBtnHome()){
				//Updates information about the user
				screen.getDepositScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getDepositScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.USERMENU);
			}

			//if BtnDeposit clicked
			else if (e.getSource() == screen.getDepositScreen().getBtnDeposit()){

				//Parses double from textfield to string
				Double value = Double.parseDouble(screen.getDepositScreen().getTfAmount().getText());

				//Updates balance for the current user
				currentUser.setBalance(currentUser.getBalance() + value);

				//Define values from database for implementing in prepared statement depositUser
				Double balance = currentUser.getBalance();
				String initials = currentUser.getInitials();

				//Executes method depositUser in DBCon
				dbcon.depositUser(balance, initials);

				//Updates user information and resets textfield
				screen.getDepositScreen().getLblBalance().setText("Balance: " + balance + " BC");
				screen.getDepositScreen().getTfAmount().setText("");

			}

		}

	}

	//Class that implements the ActionListeners for the panel WithdrawScreen
	private class WithdrawActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel WithdrawScreen
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e){

			//if BtnLogout clicked
			if (e.getSource() == screen.getWithdrawScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			//if BtnHome clicked
			else if (e.getSource() == screen.getWithdrawScreen().getBtnHome()){

				//Updates user information in labels
				screen.getWithdrawScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getWithdrawScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.USERMENU);
			}

			//if BtnWithdraw clicked
			else if (e.getSource() == screen.getWithdrawScreen().getBtnWithdraw()){

				//Parses double from textfield to string
				Double value = Double.parseDouble(screen.getWithdrawScreen().getTfAmount().getText());

				//Checks whether the value typed is equal or higher than the actual balance
				if (currentUser.getBalance() >= value && value > 0){

					//Updates balance for user
					currentUser.setBalance(currentUser.getBalance() - value);

					//Define values from database for implementing in prepared statement withdrawUser
					Double balance = currentUser.getBalance(); 
					String initials = currentUser.getInitials();

					//Executes method withdrawUser from DBCon
					dbcon.withdrawUser(balance, initials);

					//Updates user information
					screen.getWithdrawScreen().getLblBalance().setText("Balance: " + balance + " BC");
					screen.getWithdrawScreen().getTfAmount().setText("");

					//Shows message if if-statement is not fulfilled
				} else {
					JOptionPane.showMessageDialog(screen, "Insufficient funds!");
				}
			}

		}

	}

	//Class that implements the ActionListeners for the panel TransferScreen
	private class TransActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel TransferScreen
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e){

			//If btnLogout clicked
			if (e.getSource() == screen.getTransferScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}

			//If BtnHome clicked
			else if (e.getSource() == screen.getTransferScreen().getBtnHome()){
				//Updates user information for labels
				screen.getTransferScreen().getLblUser().setText("User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
				screen.getTransferScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");
				screen.show(Screen.USERMENU);
			}

			//If BtnTransfer is clicked
			else if (e.getSource() == screen.getTransferScreen().getBtnTransfer()){

				//Parses double from textfield to string
				double value = Double.parseDouble(screen.getTransferScreen().getTfAmount().getText());

				//Sets the variable transferTo to ..
				Users transferTo = dbcon.getUserByName(screen.getTransferScreen().getTfTransUser().getText());

				//Checks whether the value typed is equal or higher than the actual balance
				if (currentUser.getBalance() >= value && value > 0){

					//Updates balances for the current user and the user transferred to
					currentUser.setBalance(currentUser.getBalance() - value);
					transferTo.setBalance(transferTo.getBalance() + value);

					//Executes method transferUser in DBCon for both current user and the user transferred to
					dbcon.transferUser(currentUser.getBalance(), currentUser.getInitials());
					dbcon.transferUser(transferTo.getBalance(), transferTo.getInitials());

					//Resets textfields
					screen.getTransferScreen().getTfAmount().setText(null);
					screen.getTransferScreen().getTfTransUser().setText(null);

					//Updates balance for current user
					screen.getTransferScreen().getLblBalance().setText("Balance: " + currentUser.getBalance() + " BC");

					//Shows message if if-statement is not fulfilled
				} else {
					JOptionPane.showMessageDialog(screen, "Insufficient funds!");
				}
			}

		}

	}

	//Class that implements the ActionListeners for the panel ViewScreen
	private class ViewActionListener implements ActionListener{

		/**
		 * Method that handels all the action events from the JPanel ViewScreen
		 * Uses method e.getSource to differentiate between the actions
		 */
		public void actionPerformed(ActionEvent e){

			//If BtnLogout clicked
			if (e.getSource() == screen.getViewScreen().getBtnLogout()){
				screen.getLogin().getTfUsername().setText("");
				screen.getLogin().getTfPassword().setText("");
				screen.show(Screen.LOGIN);
			}
			
			//if BtnHome clicked
			else if (e.getSource() == screen.getViewScreen().getBtnHome()){
				screen.show(Screen.ADMINMENU);
			}

			//if Btn Overview clicked
			else if (e.getSource() == screen.getViewScreen().getBtnOverviewRich()){
				//Order the table in descending order (code not done)
				dbcon.overviewRich();
			}
			
			else if (e.getSource() == screen.getViewScreen().getBtnOverviewPoor()){
				//Order the table in ascending order (code not done)
				dbcon.overviewPoor();
			}

		}

	}
	
	//Class that implements the ActionListeners for the panel CreateScreen
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

				//Declare values for the strings needed from the textfields
				String firstname = screen.getCreateScreen().getUserFirst().getText();
				String lastname = screen.getCreateScreen().getUserLast().getText();
				String initials = screen.getCreateScreen().getUserInit().getText();
				String password = screen.getCreateScreen().getUserPass().getText();

				//Validates values for password and initials
				if (passwordValidate(password) && initialsValidate(initials)){
					dbcon.createUser(firstname, lastname, initials, password);

					JOptionPane.showMessageDialog(screen, "The user is now in the system!");

					screen.getCreateScreen().getUserFirst().setText("");
					screen.getCreateScreen().getUserLast().setText("");
					screen.getCreateScreen().getUserInit().setText("");
					screen.getCreateScreen().getUserPass().setText("");

				} else {
					JOptionPane.showMessageDialog(screen, "Please fill out the enitre formular");
				}

			}

		}

	}
	//Class that implements the ActionListeners for the panel DeleteScreen
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

				//Validates values for password and initials 
				if (passwordValidate(password) && initialsValidate(initials)){
					dbcon.deleteUser(firstname, lastname, initials, password);

					screen.getDeleteScreen().getUserFirst().setText("");
					screen.getDeleteScreen().getUserLast().setText("");
					screen.getDeleteScreen().getUserInit().setText("");
					screen.getDeleteScreen().getUserPass().setText("");
				} else {
					JOptionPane.showMessageDialog(screen, "Please fill out the enitre formular");
				}

			}

		}

	}

	/**
	 * Method for validating the values typed when creating or deleting a user
	 * @param password
	 * @return
	 */
	public boolean passwordValidate(String password){
		Matcher match = passwordPattern.matcher(password);
		if(match.matches()){
			return true;
		}
		return false;
	}

	/**
	 * Method for validating the values typed when creating or deleting a user
	 * @param initials
	 * @return
	 */
	public boolean initialsValidate(String initials){
		Matcher match = initialsPattern.matcher(initials);
		if (match.matches()){
			return true;
		}
		return false;
	}

}
