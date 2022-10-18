package com.example.demo.dto;

public class UserRegistrationDto {

	
	
	private String userEmail;
	
	private String userPassword;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userGender;
	
	private String userAge;
	
	private Long userPhoneNumber;
	
	private String userAddress;

	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public UserRegistrationDto(String userEmail, String userPassword, String userFirstName,
			String userLastName, String userGender, String userAge, Long userPhoneNumber, String userAddress) {
		super();
		
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
	}

	public UserRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
