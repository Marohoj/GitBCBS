package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositScreen extends JPanel {

	private JButton btnLogud;
	private JButton btnHome;
	private JButton btnDeposit;
	private JLabel lblBruger;
	private JLabel lblSaldo;
	private JLabel lblAntalBc;
	private JTextField tfAmount;
	private JLabel label;
	private JLabel lblTest;
	
	public DepositScreen() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHome = new JButton("Hjem");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(199, 300, 199, 23);
		add(tfAmount);
		tfAmount.setColumns(10);
		
		btnDeposit = new JButton("Inds\u00E6t BC");
		btnDeposit.setBounds(252, 389, 89, 23);
		add(btnDeposit);
		
		lblAntalBc = new JLabel("Hvor mange BC \u00F8nsker du at overf\u00F8re?");
		lblAntalBc.setBounds(199, 167, 254, 14);
		add(lblAntalBc);
		
		label = new JLabel("Saldo:");
		label.setBounds(199, 202, 103, 23);
		add(label);
		
		lblTest = new JLabel("");
		lblTest.setBounds(199, 342, 46, 14);
		add(lblTest);
		
	}
	
	public JButton getBtnLogUd() {
		return btnLogud;
	}
	
	public JButton getBtnHome() {
		return btnHome;
	}
	
	public JButton getBtnDeposit() {
		return btnDeposit;
	}
	
	public JTextField getTfAmount() {
		return tfAmount;
	}
	
	public JLabel getLblTest() {
		return lblTest;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHome.addActionListener(l);
		btnDeposit.addActionListener(l);
	}
	
}