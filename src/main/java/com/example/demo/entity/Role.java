package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long roleId;
	
	@Column(unique = true)
	public String roleName;
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Long getId() {
		return roleId;
	}
	public void setId(Long id) {
		this.roleId = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public Role(Long roleId) {
		super();
		this.roleId = roleId;
		
	}
	@Override
	public String toString() {
		return  roleName ;
	}
	
	
	
	
	
	
}
