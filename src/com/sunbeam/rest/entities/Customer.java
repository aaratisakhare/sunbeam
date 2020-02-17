package com.sunbeam.rest.entities;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String address;
	private String mobile;
	private String email;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String password, String address, String mobile, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, password=%s, address=%s, mobile=%s, email=%s]", id, name,
				password, address, mobile, email);
	}
}
