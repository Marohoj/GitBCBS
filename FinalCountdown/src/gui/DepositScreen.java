package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositScreen extends JPanel {

	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnDeposit;
	private JLabel lblUser;
	private JLabel lblBalance;
	private JLabel lblAmount;
	private JTextField tfAmount;
	private JLabel label;
	private JLabel lblTest;
	
	public DepositScreen() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		lblUser = new JLabel("User: ");
		lblUser.setBounds(20, 11, 238, 23);
		add(lblUser);

		lblBalance = new JLabel("Balance: ");
		lblBalance.setBounds(20, 40, 103, 23);
		add(lblBalance);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(199, 300, 199, 23);
		add(tfAmount);
		tfAmount.setColumns(10);
		
		btnDeposit = new JButton("Deposit BC");
		btnDeposit.setBounds(252, 389, 89, 23);
		add(btnDeposit);
		
		lblAmount = new JLabel("How many BC do you want to deposit?");
		lblAmount.setBounds(199, 167, 254, 14);
		add(lblAmount);
		
		label = new JLabel("Balance:");
		label.setBounds(199, 202, 103, 23);
		add(label);
		
		lblTest = new JLabel("");
		lblTest.setBounds(199, 342, 46, 14);
		add(lblTest);
		
	}
	
	public JLabel getLblUser() {
		return lblUser;
	}
	
	public JLabel getLblBalance() {
		return lblBalance;
	}

	public JLabel getLblAmount() {
		return lblAmount;
	}

	public JLabel getLblTest() {
		return lblTest;
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
	
	public JTextField getTfAmount() {
		return tfAmount;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnDeposit.addActionListener(l);
	}
	
}
