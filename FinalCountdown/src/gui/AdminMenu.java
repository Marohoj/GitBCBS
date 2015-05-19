package gui;

import java.awt.event.ActionListener;
import java.awt.*;

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
	private JLabel lblLoginInfo;
	private JLabel lblCurrentEx;
	private JLabel lblExchange;

	public AdminMenu() {
		setBackground(Color.WHITE);

		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);

		btnHome = new JButton("Home");
		btnHome.setBounds(20, 74, 103, 23);
		add(btnHome);

		btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(20, 142, 103, 23);
		add(btnCreateUser);

		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(20, 176, 103, 23);
		add(btnDeleteUser);

		btnViewUsers = new JButton("View Users");
		btnViewUsers.setBounds(20, 108, 103, 23);
		add(btnViewUsers);

		btnExchange = new JButton("Update Exchangerate");
		btnExchange.setBounds(207, 328, 152, 23);
		add(btnExchange);

		tfExchange = new JTextField();
		tfExchange.setBounds(207, 297, 152, 20);
		tfExchange.setColumns(10);
		add(tfExchange);

		lblLoginInfo = new JLabel("You are logged in as Admin");
		lblLoginInfo.setBounds(207, 78, 173, 14);
		add(lblLoginInfo);

		lblExchange = new JLabel("Type in todays exchangerate:");
		lblExchange.setBounds(207, 269, 243, 14);
		add(lblExchange);

		lblCurrentEx = new JLabel("Current exchangerate:");
		lblCurrentEx.setBounds(207, 201, 167, 14);
		add(lblCurrentEx);

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
