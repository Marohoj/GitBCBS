package gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import db.DBCon;

public class LoginScreen extends JPanel {
	
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JLabel label_1;
	private JLabel lblPing;
	private JButton btnLogin;
	private JButton btnAfslut;
	
	private DBCon dbcon;

	/**
	 * Create the Login Panel.
	 */
	public LoginScreen() {
		
		dbcon = new DBCon();
		
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 800, 600);

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(247, 312, 200, 26);
		add(tfUsername);

		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(247, 360, 200, 26);
		add(tfPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/img/approve.png")));
		
		//________________________________________
		btnLogin.setBounds(247, 414, 101, 23);
		add(btnLogin);

		btnAfslut = new JButton("Afslut");
		btnAfslut.setBounds(358, 414, 109, 23);
		add(btnAfslut);

		label_1 = new JLabel("");
		label_1.setBackground(Color.WHITE);
		label_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/img/BCBS_LOGO.jpg")));
		label_1.setBounds(160, 11, 366, 290);
		add(label_1);
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JPasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnAfslut() {
		return btnAfslut;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
		btnAfslut.addActionListener(l);
	}
}
