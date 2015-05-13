package db;

public class Admin {
	
	private String initials;
	private String password;
	private String balance;
	
	public Admin(String initials, String password, String balance){
		
		this.initials = initials;
		this.password = password;
		this.balance = balance;		
	}

	public String getInitials() {
		return initials;
	}

	public String getPassword() {
		return password;
	}

	public String getBalance() {
		return balance;
	}

}
