package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import db.DBCon;
import db.Users;

public class VisBruger extends JPanel {
	
	private JButton btnLogud;
	private JButton btnHjem;
	private JButton btnVis;
	private JButton btnOversigt;
	
	private JTextField tfSearch;
	
	private JLabel	lblBruger;
	private JLabel	lblSaldo;
	private JLabel lblSearch;
	private JTable tbUser;
	
	private Users users;
	
	public VisBruger() {
		
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
		
		btnVis = new JButton("Vis Brugere");
		btnVis.setBounds(234, 389, 103, 23);
		add(btnVis);	
		
		btnOversigt = new JButton("Vis fattigste/rigeste");
		btnOversigt.setBounds(463, 100, 127, 23);
		add(btnOversigt);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(186, 340, 197, 20);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		lblSearch = new JLabel("S\u00F8g:");
		lblSearch.setBounds(153, 343, 41, 14);
		add(lblSearch);	
		
		tbUser = new JTable(new TableModel());
		tbUser.setFillsViewportHeight(true);
		tbUser.setBounds(138, 298, 309, -197);	
		add(tbUser);
	}
	

	public JButton getBtnLogud() {
		return btnLogud;
	}

	public JButton getBtnHjem() {
		return btnHjem;
	}

	public JButton getBtnVis() {
		return btnVis;
	}
	
	public JButton getBtnOversigt() {
		return btnOversigt;
	}
	
	public JTextField getTfSearch() {
		return tfSearch;
	}
	
	public JTable getTbUser(){
		return tbUser;
	}

	public void addActionListener(ActionListener l) {
		btnLogud.addActionListener(l);
		btnHjem.addActionListener(l);
		btnVis.addActionListener(l);
		btnOversigt.addActionListener(l);
	}
}
