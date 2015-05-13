package BCBS.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HvBc extends JPanel {
	
	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnHvBc;
	private JLabel lblBruger;
	private JLabel lblSaldo;
	private JLabel lblAntalBc;
	private JTextField textField;
	private JLabel lblDetErMulig;

	public HvBc() {

		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);
		
		textField = new JTextField();
		textField.setBounds(199, 300, 199, 23);
		add(textField);
		textField.setColumns(10);
		
		btnHvBc = new JButton("H\u00E6v BC");
		btnHvBc.setBounds(252, 389, 89, 23);
		add(btnHvBc);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		lblAntalBc = new JLabel("Hvor mange BC \u00F8nsker du at h\u00E6ve?");
		lblAntalBc.setBounds(199, 167, 227, 14);
		add(lblAntalBc);
		
		lblDetErMulig = new JLabel("Det er mulig at h\u00E6ve: " + "" + "BC");
		lblDetErMulig.setBounds(199, 222, 188, 14);
		add(lblDetErMulig);
	}

	public JButton getBtnLogud() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnHvBc() {
		return btnHvBc;
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnHvBc.addActionListener(l);
	}

}
