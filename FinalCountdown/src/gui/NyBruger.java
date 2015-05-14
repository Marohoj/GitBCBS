package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NyBruger extends JPanel {

	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnOpret;

	private JTextField userInit;
	private JTextField userFirst;
	private JTextField userLast;
	private JTextField userPass;
	
	private JLabel	lblBruger;
	private JLabel	lblSaldo;	
	private JLabel lblInitialer;
	private JLabel lblFornavn;
	private JLabel lblEfternavn;
	private JLabel lblPassword;
	private JLabel lblFormular;
	
	public NyBruger() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		btnOpret = new JButton("Opret Bruger");
		btnOpret.setBounds(252, 389, 103, 23);
		add(btnOpret);
		
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
		
		lblInitialer = new JLabel("Initialer:");
		lblInitialer.setBounds(182, 187, 85, 14);
		add(lblInitialer);
		
		lblFornavn = new JLabel("Fornavn:");
		lblFornavn.setBounds(182, 221, 85, 14);
		add(lblFornavn);
		
		lblEfternavn = new JLabel("Efternavn:");
		lblEfternavn.setBounds(182, 255, 85, 14);
		add(lblEfternavn);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(182, 289, 85, 14);
		add(lblPassword);
		
		lblFormular = new JLabel("Udfyld nedenst\u00E5ende formular for at oprette en ny bruger i systemet");
		lblFormular.setBounds(147, 146, 357, 14);
		add(lblFormular);

	}

	public JButton getBtnLogud() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnOpret() {
		return btnOpret;
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
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnOpret.addActionListener(l);
		userFirst.addActionListener(l);
		userLast.addActionListener(l);
		userInit.addActionListener(l);
		userPass.addActionListener(l);
	}

}
