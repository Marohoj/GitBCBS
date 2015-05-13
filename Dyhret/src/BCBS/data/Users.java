package BCBS.data;

public class Users {

	private String initials;
	private String firstname;
	private String lastname;
	private String password;
	private String balance;

	public Users(String initials, String password, String balance) {

		this.initials = initials;
		//this.firstname = first_name;
		//this.lastname = last_name;
		this.password = password;
		this.balance = balance;		
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
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
