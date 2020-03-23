package com.esipe.ms.model;

import java.util.List;

public class User {

	private String email;
	private String firstname;
	private String lastname;
	private int age;
	private CharSequence password;
	private List<String> authorities;
	
	public CharSequence getPassword() {
		return password;
	}
	public void setPassword(CharSequence password) {
		this.password = password;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
