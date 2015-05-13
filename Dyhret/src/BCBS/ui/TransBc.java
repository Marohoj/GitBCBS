package BCBS.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransBc extends JPanel {

	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnTransBc;
	
	private JTextField tf_bruger;
	private JTextField tf_antalbc;
	
	private JLabel lblBruger;
	private JLabel lblSaldo;
	private JLabel lblAntalBc;
	private JLabel lblDetErMulig;
	private JLabel lblHvorMangeBc;
	
	public TransBc() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);
		
		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);
		
		tf_antalbc = new JTextField();
		tf_antalbc.setBounds(199, 272, 199, 23);
		add(tf_antalbc);
		tf_antalbc.setColumns(10);
		
		tf_bruger = new JTextField();
		tf_bruger.setColumns(10);
		tf_bruger.setBounds(199, 188, 199, 23);
		add(tf_bruger);
		
		btnTransBc = new JButton("Overf\u00F8r BC");
		btnTransBc.setBounds(252, 389, 89, 23);
		add(btnTransBc);
		
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

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnTransBc() {
		return btnTransBc;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnTransBc.addActionListener(l);
	}
}
