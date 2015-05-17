package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferScreen extends JPanel {

	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnTransfer;
	
	private JTextField tfTransUser;
	private JTextField tfAmount;
	
	private JLabel lblUser;
	private JLabel lblBalance;
	private JLabel lblReceiver;
	private JLabel lblPossible;
	private JLabel lblAmount;
	
	public TransferScreen() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(199, 272, 199, 23);
		add(tfAmount);
		tfAmount.setColumns(10);
		
		tfTransUser = new JTextField();
		tfTransUser.setColumns(10);
		tfTransUser.setBounds(199, 188, 199, 23);
		add(tfTransUser);
		
		btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(252, 389, 89, 23);
		add(btnTransfer);
		
		lblUser = new JLabel("");
		lblUser.setBounds(20, 11, 238, 23);
		add(lblUser);

		lblBalance = new JLabel();
		lblBalance.setBounds(20, 40, 103, 23);
		add(lblBalance);
		
		lblReceiver = new JLabel("To User (initials): ");
		lblReceiver.setBounds(199, 247, 69, 14);
		add(lblReceiver);
		
		lblPossible = new JLabel("");
		lblPossible.setBounds(199, 140, 188, 14);
		add(lblPossible);
		
		lblAmount = new JLabel("Hvor much do you want to transfer?");
		lblAmount.setBounds(199, 165, 221, 14);
		add(lblAmount);
				
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

	public JButton getBtnTransfer() {
		return btnTransfer;
	}
	
	public JTextField getTfTransUser() {
		return tfTransUser;
	}

	public JTextField getTfAmount() {
		return tfAmount;
	}

	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnTransfer.addActionListener(l);
	}
}
