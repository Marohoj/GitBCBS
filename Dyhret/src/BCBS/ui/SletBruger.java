package BCBS.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SletBruger extends JPanel {

	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnSlet;

	private JTextField brugerint;
	private JTextField brugerfor;
	private JTextField brugerefter;
	private JTextField brugerpass;
	
	private JLabel	lblBruger;
	private JLabel	lblSaldo;	
	private JLabel lblInitialer;
	private JLabel lblFornavn;
	private JLabel lblEfternavn;
	private JLabel lblPassword;
	private JLabel lblFormular;
	
	public SletBruger() {

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
		
		btnSlet = new JButton("Slet Bruger");
		btnSlet.setBounds(252, 389, 103, 23);
		add(btnSlet);
		
		brugerint = new JTextField();
		brugerint.setBounds(277, 183, 155, 23);
		add(brugerint);
		brugerint.setColumns(10);
		
		brugerfor = new JTextField();
		brugerfor.setColumns(10);
		brugerfor.setBounds(277, 217, 155, 23);
		add(brugerfor);
		
		brugerefter = new JTextField();
		brugerefter.setColumns(10);
		brugerefter.setBounds(277, 251, 155, 23);
		add(brugerefter);
		
		brugerpass = new JTextField();
		brugerpass.setColumns(10);
		brugerpass.setBounds(277, 285, 155, 23);
		add(brugerpass);
		
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
		
		lblFormular = new JLabel("Udfyld nedenst\u00E5ende formular for at slette en bruger i systemet");
		lblFormular.setBounds(147, 146, 357, 14);
		add(lblFormular);

	}
	
	public JButton getBtnLogud() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnSlet() {
		return btnSlet;
	}

	public JTextField getBrugerint() {
		return brugerint;
	}

	public JTextField getBrugerfor() {
		return brugerfor;
	}

	public JTextField getBrugerefter() {
		return brugerefter;
	}

	public JTextField getBrugerpass() {
		return brugerpass;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnSlet.addActionListener(l);
	}

}
