package db;

public class Admin {
	
	
	private String initials;
	private String password;
	private String name;
	private Double currency;
		
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
