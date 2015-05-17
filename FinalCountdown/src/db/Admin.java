package db;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class Admin {

	DBCon conncetion = new DBCon();
	
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	private String initials;
	private String password;
	private String name;
	private Double currency;
		
	public ResultSetTableModel(String url, String username, String password, String query)
	throws SQLException{
		
		statement = connection.DBCon.CreateStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
	}
	
	
	
	
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
