package logic;

import javax.swing.table.AbstractTableModel;

import db.DBCon;

public class ModelTabel extends AbstractTableModel {

	private DBCon dbcon;
		
	public ModelTabel(){
		
		dbcon = new DBCon();
	}
	
	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		//return 4;
		
		return dbcon.getUser().size();
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Firstname";
		case 1:
			return "Lastname";
		case 2:
			return "Initials";
		case 3: 
			return "Password";
		case 4: 
			return "Balance";
		}
		return null;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		//dbcon.getUser().get(rowIndex);

		switch (columnIndex) {

		case 0:
			return dbcon.getUser().get(rowIndex).getFirstName();
		case 1:
			return dbcon.getUser().get(rowIndex).getLastName();
		case 2:
			return dbcon.getUser().get(rowIndex).getInitials();
		case 3: 
			return dbcon.getUser().get(rowIndex).getPassword();
		case 4: 
			return dbcon.getUser().get(rowIndex).getBalance();
		}
		//return null;
		
		return getValueAt(rowIndex, columnIndex);
	}
}