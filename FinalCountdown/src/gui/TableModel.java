package gui;

import javax.swing.table.AbstractTableModel;

import db.DBCon;

public class TableModel extends AbstractTableModel {

	private DBCon dbcon;

	public void TableModel1() {
		dbcon = new DBCon();

	}

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return 4;
		//return dbcon.getUsers().size();
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Fristname";
		case 1:
			return "Lastname";
		case 2:
			return "Initials";
		case 3: 
			return "Password";
		}
		return null;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		dbcon.getUsers().get(rowIndex);

		switch (columnIndex) {

		case 0:
			return dbcon.getUsers().get(rowIndex).getFirstName();
		case 1:
			return dbcon.getUsers().get(rowIndex).getLastName();
		case 2:
			return dbcon.getUsers().get(rowIndex).getInitials();
		case 3: 
			return dbcon.getUsers().get(rowIndex).getPassword();
		}
		return getValueAt(rowIndex, columnIndex);
	}

}