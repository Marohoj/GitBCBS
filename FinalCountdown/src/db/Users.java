package db;

public class Users {

	private String initials;
	private String first_name;
	private String last_name;
	private String password;
	private Double balance;

	public Users(String first_name, String last_name, String initials, String password, Double balance) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.initials = initials;
		this.password = password;
		this.balance = balance;		
	}

	public String getFirstName() {
		return first_name;
	}

	public String getLastName() {
		return last_name;
	}
	
	public String getInitials() {
		return initials;
	}

	public String getPassword() {
		return password;
	}

	public Double getBalance() {
		return balance;
	}

}
