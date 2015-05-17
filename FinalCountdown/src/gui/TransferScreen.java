package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferScreen extends JPanel {

	private JButton btnLogud;
	private JButton btnHome;
	private JButton btnTransfer;
	
	private JTextField tfTransUser;
	private JTextField tfAmount;
	
	private JLabel lblBruger;
	private JLabel lblSaldo;
	private JLabel lblAntalBc;
	private JLabel lblDetErMulig;
	private JLabel lblHvorMangeBc;
	
	public TransferScreen() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHome = new JButton("Hjem");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(199, 272, 199, 23);
		add(tfAmount);
		tfAmount.setColumns(10);
		
		tfTransUser = new JTextField();
		tfTransUser.setColumns(10);
		tfTransUser.setBounds(199, 188, 199, 23);
		add(tfTransUser);
		
		btnTransfer = new JButton("Overf\u00F8r BC");
		btnTransfer.setBounds(252, 389, 89, 23);
		add(btnTransfer);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		lblAntalBc = new JLabel("Til bruger: ");
		lblAntalBc.setBounds(199, 247, 69, 14);
		add(lblAntalBc);
		
		lblDetErMulig = new JLabel("Det er muligt at overf\u00F8re: BC");
		lblDetErMulig.setBounds(199, 140, 188, 14);
		add(lblDetErMulig);
		
		lblHvorMangeBc = new JLabel("Hvor mange BC \u00F8nsker du at overf\u00F8re?");
		lblHvorMangeBc.setBounds(199, 165, 221, 14);
		add(lblHvorMangeBc);
				
	}
	
	public JButton getBtnLogud() {
		return btnLogud;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnTransfer() {
		return btnTransfer;
	}
	
	public JTextField getTfTransUser() {
		return tfTransUser;
	}

	public JTextField getTfAmount() {
		return tfAmount;
	}

	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHome.addActionListener(l);
		btnTransfer.addActionListener(l);
	}
}
