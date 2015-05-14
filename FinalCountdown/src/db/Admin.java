package db;

public class Admin {
	
	
	private String initials;
	private String password;
	private String name;
		
	public Admin(String initials, String password, String name){
		
		
		this.initials = initials;
		this.password = password;
		this.name = name;	
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

}
