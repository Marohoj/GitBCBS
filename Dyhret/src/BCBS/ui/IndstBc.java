package BCBS.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IndstBc extends JPanel {

	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnIndst;
	private JLabel lblBruger;
	private JLabel lblSaldo;
	private JLabel lblAntalBc;
	private JTextField textField;
	private JLabel label;
	
	public IndstBc() {
		
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
		
		textField = new JTextField();
		textField.setBounds(199, 300, 199, 23);
		add(textField);
		textField.setColumns(10);
		
		btnIndst = new JButton("Inds\u00E6t BC");
		btnIndst.setBounds(252, 389, 89, 23);
		add(btnIndst);
		
		lblAntalBc = new JLabel("Hvor mange BC \u00F8nsker du at overf\u00F8re?");
		lblAntalBc.setBounds(199, 167, 254, 14);
		add(lblAntalBc);
		
		label = new JLabel("Saldo:");
		label.setBounds(199, 202, 103, 23);
		add(label);
		
	}
	
	public JButton getBtnLogUd() {
		return btnLogud;
	}
	
	public JButton getBtnHjem() {
		return btnHjem;
	}
	
	public JButton getBtnIndst() {
		return btnIndst;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnIndst.addActionListener(l);
	}
	
}
