package BCBS.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminMenu extends JPanel {

	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnOpretBruger;
	private JButton btnSletBruger;
	private JButton btnVisBrugere;
	private JButton btnOpdaterVekselkurs;
	
	private JTextField tf_Vekselkurs;
	
	private JLabel	lblBruger;
	private JLabel	lblSaldo;
	private JLabel lblLoginInfo;
	private JLabel lblIndls;
	private JLabel lblVekselkurs;
		
	public AdminMenu() {

		setBounds(100,100,600,500);
		setLayout(null);

		btnLogud = new JButton("Log ud");
		btnLogud.setBounds(475, 11, 89, 23);
		add(btnLogud);

		btnHjem = new JButton("Hjem");
		btnHjem.setBounds(20, 100, 89, 23);
		add(btnHjem);

		btnOpretBruger = new JButton("Opret Bruger");
		btnOpretBruger.setBounds(20, 134, 89, 23);
		add(btnOpretBruger);

		btnSletBruger = new JButton("Slet Bruger");
		btnSletBruger.setBounds(20, 202, 89, 23);
		add(btnSletBruger);

		btnVisBrugere = new JButton("Vis Brugere");
		btnVisBrugere.setBounds(20, 168, 89, 23);
		add(btnVisBrugere);

		btnOpdaterVekselkurs = new JButton("Opdater Vekselkurs");
		btnOpdaterVekselkurs.setBounds(231, 264, 133, 23);
		add(btnOpdaterVekselkurs);
		
		tf_Vekselkurs = new JTextField();
		tf_Vekselkurs.setBounds(219, 203, 152, 20);
		tf_Vekselkurs.setColumns(10);
		add(tf_Vekselkurs);
		
		lblBruger = new JLabel("Du er logget ind som:" + "");
		lblBruger.setBounds(20, 11, 238, 23);
		add(lblBruger);

		lblSaldo = new JLabel("Saldo:" + "");
		lblSaldo.setBounds(20, 40, 103, 23);
		add(lblSaldo);
		
		lblLoginInfo = new JLabel("Du er logget ind som Admin");
		lblLoginInfo.setBounds(231, 104, 139, 14);
		add(lblLoginInfo);
		
		lblIndls = new JLabel("Indl\u00E6s den dagens vekselkurs i feltet herunder");
		lblIndls.setBounds(181, 172, 243, 14);
		add(lblIndls);
		
		lblVekselkurs = new JLabel("Nuv\u00E6rende vekselkurs: ");
		lblVekselkurs.setBounds(231, 138, 133, 14);
		add(lblVekselkurs);	
	}
	
	public JButton getBtnOpdaterVekselkurs(){
		return btnOpdaterVekselkurs;
	}
	
	public JButton getBtnVisBrugere() {
		return btnVisBrugere;
	}
	
	public JButton getBtnOpretBruger() {
		return btnOpretBruger;
	}
	
	public JButton getBtnSletBruger() {
		return btnSletBruger;
	}

	public JButton getBtnLogUd() {
		return btnLogud;
	}
	
	public JButton getBtnHjem() {
		return btnHjem;
	}
	
	public JTextField getTf_Vekselkurs(){
		return tf_Vekselkurs;
	}
	
	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnVisBrugere.addActionListener(l);
		btnOpretBruger.addActionListener(l);
		btnSletBruger.addActionListener(l);
	}

}
