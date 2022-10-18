package com.example.demo.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(unique = true, nullable = false)
	private String userEmail;
	
	@Column(nullable = false)
	private String userPassword;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userGender;
	
	private String userAge;
	
	private Long userPhoneNumber;
	
	private String userAddress;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name ="users_role", 
			joinColumns = @JoinColumn(
					name= "user_id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id"))
	//private Collection<Role> userRole;
	 private Set<Role> userRole = new HashSet<>();
	
	public void addRole(Role role) {
        this.userRole.add(role);
	}

	
	
	public Set<Role> getUserRole() {
		return userRole;
	}



	public void setUserRole(Set<Role> userRole) {
		this.userRole = userRole;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(String userEmail, String userPassword, String userFirstName, String userLastName,
			String userGender, String userAge, Long userPhoneNumber, String userAddress, Collection<Role> roles) {
		super();
		//this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userPhoneNumber = userPhoneNumber;
		this.userAddress = userAddress;
		this.userRole = userRole;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	
	

	public Collection<Role> getRoles() {
		return userRole;
	}

	public void setRoles(Collection<Role> roles) {
		this.userRole = userRole;
	}
	
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userGender=" + userGender
				+ ", userAge=" + userAge + ", userPhoneNumber=" + userPhoneNumber + ", userAddress=" + userAddress
				+ ", userRole=" + userRole + "]";
	}
	

	

}
