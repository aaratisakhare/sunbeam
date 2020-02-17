package com.sunbeam.rest.entities;

public class Item {
	private int id;
	private String category;
	private String name;
	private String info;
	private double price;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(int id, String category, String name, String info, double price) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.info = info;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Item [id=%s, category=%s, name=%s, info=%s, price=%s]", id, category, name, info, price);
	}
}
