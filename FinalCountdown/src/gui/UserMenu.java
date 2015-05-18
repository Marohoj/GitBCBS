package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Color;

public class UserMenu extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnTransfer;
	
	private JLabel lblUser;
	private JLabel lblBalance;

	/**
	 * Create the panel.
	 */
	public UserMenu() {
		setBackground(new Color(240, 240, 240));	
		setBounds(100,100,350,131);
		setLayout(null);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(20, 140, 89, 23);
		add(btnDeposit);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(20, 180, 89, 23);
		add(btnWithdraw);
		
		btnTransfer = new JButton("Transaction");
		btnTransfer.setBounds(20, 220, 89, 23);
		add(btnTransfer);
		
		lblUser = new JLabel("User: ");
		lblUser.setBounds(20, 11, 179, 23);
		add(lblUser);
		
		lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(20, 40, 89, 40);
		add(lblBalance);
		setBounds(153, 104, 255, 19);
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
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnDeposit.addActionListener(l);
		btnWithdraw.addActionListener(l);
		btnTransfer.addActionListener(l);
	}
}
