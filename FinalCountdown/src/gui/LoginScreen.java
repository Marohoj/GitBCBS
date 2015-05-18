package gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginScreen extends JPanel {
	
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JLabel label_1;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnAfslut;

	public LoginScreen() {
				
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
		
		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/img/approve.png")));
		btnLogin.setBounds(247, 414, 101, 23);
		add(btnLogin);

		btnAfslut = new JButton("");
		btnAfslut.setIcon(new ImageIcon(LoginScreen.class.getResource("/img/exit.png")));
		btnAfslut.setBounds(358, 414, 109, 23);
		add(btnAfslut);

		label_1 = new JLabel("");
		label_1.setBackground(Color.WHITE);
		label_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/img/BCBS_LOGO.jpg")));
		label_1.setBounds(160, 11, 366, 290);
		add(label_1);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(170, 318, 67, 14);
		add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(170, 366, 67, 14);
		add(lblPassword);
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
