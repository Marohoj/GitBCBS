package gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawScreen extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnWithdraw;
	private JLabel lblUser;
	private JLabel lblBalance;
	private JLabel lblAmount;
	private JTextField tfAmount;
	private JLabel lblPossible;

	public WithdrawScreen() {
		setBackground(Color.WHITE);
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(199, 258, 199, 23);
		add(tfAmount);
		tfAmount.setColumns(10);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(252, 389, 89, 23);
		add(btnWithdraw);
		
		lblUser = new JLabel("User: ");
		lblUser.setBounds(20, 11, 238, 23);
		add(lblUser);

		lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(20, 40, 103, 23);
		add(lblBalance);
		
		lblAmount = new JLabel("How much do you want withdraw?");
		lblAmount.setBounds(199, 197, 227, 14);
		add(lblAmount);
		
		lblPossible = new JLabel("");
		lblPossible.setBounds(199, 222, 188, 14);
		add(lblPossible);
	}
	
	public JLabel getLblUser() {
		return lblUser;
	}

	public JLabel getLblBalance() {
		return lblBalance;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	public JTextField getTfAmount() {
		return tfAmount;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnWithdraw.addActionListener(l);
	}

}
