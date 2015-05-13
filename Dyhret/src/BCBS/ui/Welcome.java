package BCBS.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Image;
import java.awt.*;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JLabel label_1;
	private JButton btnLogin;
	private JButton btnAfslut;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(176, 312, 200, 26);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(176, 359, 200, 26);
		contentPane.add(tfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 414, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnAfslut = new JButton("Afslut");
		btnAfslut.setBounds(305, 414, 89, 23);
		contentPane.add(btnAfslut);
		
		label_1 = new JLabel("");
		Image img  = new ImageIcon(this.getClass().getResource("/BCBS.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(100, 11, 366, 290);
		contentPane.add(label_1);
	}
	
	public JButton getBtnStart() {
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
