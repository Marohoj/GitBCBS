package db;

public class Users {

	private String initials;
	private String first_name;
	private String last_name;
	private String password;
	private Double balance;
	private double currency;

	public Users(String first_name, String last_name, String initials, String password, Double balance, double currency) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.initials = initials;
		this.password = password;
		this.balance = balance;		
		this.currency = currency;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String first_name){
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name){
		this.last_name = last_name;
	}
	
	public String getInitials() {
		return initials;
	}
	
	public void setInitials(String initials){
		this.initials = initials;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}

}
