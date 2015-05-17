package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminMenu extends JPanel {

	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnCreateUser;
	private JButton btnDeleteUser;
	private JButton btnViewUsers;
	private JButton btnExchange;
	
	private JTextField tfExchange;
	
	private JLabel	lblUser;
	private JLabel lblLoginInfo;
	private JLabel lblCurrentEx;
	private JLabel lblExchange;
		
	public AdminMenu() {

		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);

		btnHome = new JButton("Home");
		btnHome.setBounds(20, 129, 103, 23);
		add(btnHome);

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(20, 197, 103, 23);
		add(btnCreateUser);

		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(20, 231, 103, 23);
		add(btnDeleteUser);

		btnViewUsers = new JButton("View Users");
		btnViewUsers.setBounds(20, 163, 103, 23);
		add(btnViewUsers);

		btnExchange = new JButton("Update Exchangerate");
		btnExchange.setBounds(204, 368, 152, 23);
		add(btnExchange);
		
		tfExchange = new JTextField();
		tfExchange.setBounds(204, 310, 152, 20);
		tfExchange.setColumns(10);
		add(tfExchange);
		
		lblUser = new JLabel("User: ");
		lblUser.setBounds(20, 11, 238, 23);
		add(lblUser);
		
		lblLoginInfo = new JLabel("You are logged in as Admin. You got all the power. Have fun!");
		lblLoginInfo.setBounds(137, 70, 310, 14);
		add(lblLoginInfo);
		
		lblExchange = new JLabel("Type in todays exchangerate:");
		lblExchange.setBounds(204, 285, 243, 14);
		add(lblExchange);
		
		lblCurrentEx = new JLabel("Current exchangerate:");
		lblCurrentEx.setBounds(204, 201, 167, 14);
		add(lblCurrentEx);	
	}
	
	public JLabel getLblUser(){
		return lblUser;
	}
	
	public JLabel getLblCurrentEx() {
		return lblCurrentEx;
	}

	public JButton getBtnExchange(){
		return btnExchange;
	}
	
	public JButton getBtnViewUsers() {
		return btnViewUsers;
	}
	
	public JButton getBtnCreateUser() {
		return btnCreateUser;
	}
	
	public JButton getBtnDeleteUser() {
		return btnDeleteUser;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnHome() {
		return btnHome;
	}
	
	public JTextField getTfExchange(){
		return tfExchange;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnViewUsers.addActionListener(l);
		btnCreateUser.addActionListener(l);
		btnDeleteUser.addActionListener(l);
		btnExchange.addActionListener(l);
	}
	
}
