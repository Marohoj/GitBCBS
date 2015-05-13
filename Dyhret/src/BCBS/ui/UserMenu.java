package BCBS.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import BCBS.data.Users;

import java.awt.Color;

public class UserMenu extends JPanel {
	
	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnIndstBc;
	private JButton btnHvBc;
	private JButton btnOverfrBc;
	private JLabel lblBruger;
	private JLabel lblSaldo;
	
	private Users users;

	/**
	 * Create the panel.
	 */
	public UserMenu() {
		setBackground(new Color(240, 240, 240));
		
		//users = new Users(initials, password, balance);
		
		setBounds(100,100,544,326);
		setLayout(null);
		
		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);
		
		btnIndstBc = new JButton("Inds\u00E6t BC");
		btnIndstBc.setBounds(20, 140, 89, 23);
		add(btnIndstBc);
		
		btnHvBc = new JButton("H\u00E6v BC");
		btnHvBc.setBounds(20, 180, 89, 23);
		add(btnHvBc);
		
		btnOverfrBc = new JButton("Overf\u00F8r BC");
		btnOverfrBc.setBounds(20, 220, 89, 23);
		add(btnOverfrBc);
		
		lblBruger = new JLabel("Du er logget ind som: " + "users.getInitials()");
		lblBruger.setBounds(20, 11, 179, 23);
		add(lblBruger);
		
		lblSaldo = new JLabel("Saldo: " + "users.getBalance()");
		lblSaldo.setBounds(20, 40, 89, 23);
		add(lblSaldo);
		setBounds(153, 104, 255, 19);

	}

	public JButton getBtnLogUd() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnIndstBc() {
		return btnIndstBc;
	}

	public JButton getBtnHvBc() {
		return btnHvBc;
	}

	public JButton getBtnOverfrBc() {
		return btnOverfrBc;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnIndstBc.addActionListener(l);
		btnHvBc.addActionListener(l);
		btnOverfrBc.addActionListener(l);
	}
}
