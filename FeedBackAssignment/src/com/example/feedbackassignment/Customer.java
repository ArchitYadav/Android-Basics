package com.example.feedbackassignment;

public class Customer 
{
	String name,email,password,city;

	public Customer(String name, String email, String password, String city) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "name=" + name + ", email=" + email + ", password="
				+ password + ", city=" + city;
	}
	
	
}
