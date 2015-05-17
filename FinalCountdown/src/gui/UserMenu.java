package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import db.Users;

import java.awt.event.ActionListener;
import java.awt.Color;

public class UserMenu extends JPanel {
	
	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnTransfer;
	private JLabel lblBruger;
	

	private JLabel lblSaldo;
	
	private Users users;

	/**
	 * Create the panel.
	 */
	public UserMenu() {
		setBackground(new Color(240, 240, 240));
		
		//users = new Users(initials, password, balance);
		
		setBounds(100,100,544,326);
		setLayout(null);
		
		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);
		
		btnDeposit = new JButton("Inds\u00E6t BC");
		btnDeposit.setBounds(20, 140, 89, 23);
		add(btnDeposit);
		
		btnWithdraw = new JButton("H\u00E6v BC");
		btnWithdraw.setBounds(20, 180, 89, 23);
		add(btnWithdraw);
		
		btnTransfer = new JButton("Overf\u00F8r BC");
		btnTransfer.setBounds(20, 220, 89, 23);
		add(btnTransfer);
		
		lblBruger = new JLabel("Du er logget ind som: " + "users.getInitials()");
		lblBruger.setBounds(20, 11, 179, 23);
		add(lblBruger);
		
		lblSaldo = new JLabel("Saldo: " + "users.getBalance()");
		lblSaldo.setBounds(20, 40, 89, 23);
		add(lblSaldo);
		setBounds(153, 104, 255, 19);
	}

	public JButton getBtnLogUd() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
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
	
	public JLabel getLblBruger() {
		return lblBruger;
	}

	public JLabel getLblSaldo() {
		return lblSaldo;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnDeposit.addActionListener(l);
		btnWithdraw.addActionListener(l);
		btnTransfer.addActionListener(l);
	}
}
