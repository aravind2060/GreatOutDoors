package com.capgemini.greatoutdoors.dto;

public class UserDTO {

	private String userId;
	private String password;
	private String phoneNumber;
	private String email;
	private String role;
	private AddressDTO address;
	
	
	public UserDTO(String userId, String password, String phoneNumber, String email, String role, AddressDTO address) {
		super();
		this.userId = userId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.role = role;
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	
	
	
	
	
}
