package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;

public class UserMenu extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnTransfer;
	
	private JLabel lblUser;
	private JLabel lblBalance;
	private JLabel lblWelcome;
	private JLabel lblExchange;
	
		public UserMenu() {
		setBackground(Color.WHITE);
		setBounds(100,100,600,500);
		setLayout(null);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 119, 23);
		add(btnHome);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(20, 140, 119, 23);
		add(btnDeposit);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(20, 180, 119, 23);
		add(btnWithdraw);
		
		btnTransfer = new JButton("Transaction");
		btnTransfer.setBounds(20, 220, 119, 23);
		add(btnTransfer);
		
		lblUser = new JLabel("User: ");
		lblUser.setBounds(20, 11, 179, 23);
		add(lblUser);
		
		lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(20, 40, 103, 23);
		add(lblBalance);
		
		lblExchange = new JLabel("Exchangerate: ");
		lblExchange.setBounds(213, 184, 277, 14);
		add(lblExchange);
		
		lblWelcome = new JLabel("Welcome to the BitCoin ATM");
		lblWelcome.setBounds(213, 100, 277, 23);
		add(lblWelcome);
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnDeposit() {
		return btnDeposit;
	}

	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	public JButton getBtnTransfer() {
		return btnTransfer;
	}
	
	public JLabel getLblUser() {
		return lblUser;
	}

	public JLabel getLblBalance() {
		return lblBalance;
	}
		
	public JLabel getLblWelcome() {
		return lblWelcome;
	}

	public JLabel getLblExchange() {
		return lblExchange;
	}

	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnDeposit.addActionListener(l);
		btnWithdraw.addActionListener(l);
		btnTransfer.addActionListener(l);
	}
}
