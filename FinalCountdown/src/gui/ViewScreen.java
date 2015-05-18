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

import javax.swing.JScrollPane;

import logic.ModelTabel;

public class ViewScreen extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnView;
	private JButton btnOverview;
	
	private JTextField tfSearch;
	
	private JLabel	lblUser;
	private JLabel lblSearch;
	private JTable tbUser;
	private JScrollPane scrollPane;
		
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
		btnView.setBounds(256, 371, 103, 23);
		add(btnView);
		
		btnOverview = new JButton("Order by the richest user");
		btnOverview.setBounds(233, 405, 159, 23);
		add(btnOverview);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(219, 340, 197, 20);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		lblSearch = new JLabel("Search: ");
		lblSearch.setBounds(168, 343, 41, 14);
		add(lblSearch);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 63, 401, 246);
		add(scrollPane);
		
		tbUser = new JTable();
		scrollPane.setViewportView(tbUser);
		//tbUser.setFillsViewportHeight(true);
		//tbUser.setBounds(200, 250, 300, 300);
		//add(tbUser);
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
		//tbUser.addActionListener(l);
	}
}
