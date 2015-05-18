package db;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class Admin //extends AbstractTableModel
{
	private Statement stmt;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	private String initials;
	private String password;
	private String name;
	private Double currency;
	
	DBCon connect = new DBCon ();
	
	public Admin(String initials, String password, String name, Double currency){
		
		this.initials = initials;
		this.password = password;
		this.name = name;	
		this.currency = currency;
	}

	public String getInitials() {
		return initials;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public Double getCurrency() {
		return currency;
	}

}
