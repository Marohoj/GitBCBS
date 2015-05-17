package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import gui.ModelTabel;
import db.DBCon;
import db.Users;

public class ViewScreen extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnView;
	private JButton btnOverview;
	
	private JTextField tfSearch;
	
	private JLabel	lblUser;
	private JLabel lblSearch;
	private JTable tbUser;
		
	public ViewScreen() {
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 100, 89, 23);
		add(btnHome);
		
		lblUser = new JLabel("User :");
		lblUser.setBounds(20, 11, 238, 23);
		add(lblUser);
		
		btnView = new JButton("View Users");
		btnView.setBounds(228, 371, 103, 23);
		add(btnView);	
		
		btnOverview = new JButton("Order by the richest user");
		btnOverview.setBounds(200, 405, 159, 23);
		add(btnOverview);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(186, 340, 197, 20);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		lblSearch = new JLabel("Search: ");
		lblSearch.setBounds(138, 343, 41, 14);
		add(lblSearch);	
		
		tbUser = new JTable(new ModelTabel());
		tbUser.setFillsViewportHeight(true);
		tbUser.setBounds(30, 23, 392, 246);
		add(tbUser);
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnView() {
		return btnView;
	}
	
	public JButton getBtnOverview() {
		return btnOverview;
	}
	
	public JTextField getTfSearch() {
		return tfSearch;
	}
	
	public JTable getTbUser(){
		return tbUser;
	}

	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnView.addActionListener(l);
		btnOverview.addActionListener(l);
	}
}
