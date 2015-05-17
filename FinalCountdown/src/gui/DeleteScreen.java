package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteScreen extends JPanel {

	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnDelete;

	private JTextField userInit;
	private JTextField userFirst;
	private JTextField userLast;
	private JTextField userPass;
	
	private JLabel	lblBruger;
	private JLabel	lblSaldo;	
	private JLabel lblInitials;
	private JLabel lblFirstname;
	private JLabel lblLastname;
	private JLabel lblPassword;
	private JLabel lblFormular;
	
	public DeleteScreen() {

		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		btnDelete = new JButton("Delete user");
		btnDelete.setBounds(252, 389, 103, 23);
		add(btnDelete);
		
		userInit = new JTextField();
		userInit.setBounds(277, 183, 155, 23);
		add(userInit);
		userInit.setColumns(10);
		
		userFirst = new JTextField();
		userFirst.setColumns(10);
		userFirst.setBounds(277, 217, 155, 23);
		add(userFirst);
		
		userLast = new JTextField();
		userLast.setColumns(10);
		userLast.setBounds(277, 251, 155, 23);
		add(userLast);
		
		userPass = new JTextField();
		userPass.setColumns(10);
		userPass.setBounds(277, 285, 155, 23);
		add(userPass);
		
		lblInitials = new JLabel("Initials:");
		lblInitials.setBounds(182, 187, 85, 14);
		add(lblInitials);
		
		lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(182, 221, 85, 14);
		add(lblFirstname);
		
		lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(182, 255, 85, 14);
		add(lblLastname);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(182, 289, 85, 14);
		add(lblPassword);
		
		lblFormular = new JLabel("Fill out the formular below to delte a user from the system");
		lblFormular.setBounds(147, 146, 357, 14);
		add(lblFormular);

	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JTextField getUserInit() {
		return userInit;
	}

	public JTextField getUserFirst() {
		return userFirst;
	}

	public JTextField getUserLast() {
		return userLast;
	}

	public JTextField getUserPass() {
		return userPass;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnDelete.addActionListener(l);
		userInit.addActionListener(l);
		userFirst.addActionListener(l);
		userLast.addActionListener(l);
		userPass.addActionListener(l);
	}

}
