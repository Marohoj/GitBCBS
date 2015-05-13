package BCBS.data;

public class Admin {
	
	private String name;
	private String password;
	private String balance;
	
	public Admin(String name, String password, String balance){
		
		this.name = name;
		this.password = password;
		this.balance = balance;		
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getBalance() {
		return balance;
	}

}
