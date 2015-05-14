package db;

public class Users {

	private String initials;
	private String first_name;
	private String last_name;
	private String password;
	private String balance;

	public Users(String initials, String password, String balance) {

		this.initials = initials;
		this.first_name = first_name;
		this.last_name = last_name;
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

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
