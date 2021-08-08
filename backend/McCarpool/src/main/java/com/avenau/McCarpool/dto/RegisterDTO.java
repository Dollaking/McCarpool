package com.avenau.McCarpool.dto;

public class RegisterDTO {
	
	private String username;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterDTO(String username, String password, String confirmPassword, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "RegisterDTO [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
