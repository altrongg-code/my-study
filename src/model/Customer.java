package model;

public class Customer {
	private String name;
	private int password;
	
	
	public Customer() {}
	
	public Customer(String name, int password) {
		this.name = name;
		this.password = password;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	
}
