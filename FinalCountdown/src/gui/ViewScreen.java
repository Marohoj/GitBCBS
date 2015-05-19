package gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewScreen extends JPanel {
	
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnOverviewRich;
	private JButton btnOverviewPoor;
	
	private JTable tbUser;
	private JScrollPane scrollPane;
		
	public ViewScreen() {
		setBackground(Color.WHITE);
		
		setBounds(100,100,600,500);
		setLayout(null);

		btnLogout = new JButton("Log out");
		btnLogout.setBounds(475, 11, 89, 23);
		add(btnLogout);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 74, 103, 23);
		add(btnHome);
		
		btnOverviewRich = new JButton("Order by the richest user");
		btnOverviewRich.setBounds(106, 415, 159, 23);
		add(btnOverviewRich);
		
		btnOverviewPoor = new JButton("Order by the poorest user");
		btnOverviewPoor.setBounds(324, 415, 159, 23);
		add(btnOverviewPoor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 127, 548, 246);
		add(scrollPane);
		
		tbUser = new JTable();
		scrollPane.setViewportView(tbUser);
		
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
	public JButton getBtnOverviewRich() {
		return btnOverviewRich;
	}
	
	public JButton getBtnOverviewPoor() {
		return btnOverviewPoor;
	}
		
	public JTable getTbUser(){
		return tbUser;
	}

	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnHome.addActionListener(l);
		btnOverviewRich.addActionListener(l);
		btnOverviewPoor.addActionListener(l);
	}
}
