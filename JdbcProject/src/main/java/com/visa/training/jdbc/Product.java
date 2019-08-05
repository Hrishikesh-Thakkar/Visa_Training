package com.visa.training.jdbc;

public class Product {
	int id;
	int qoh;
	float price;
	String name;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int qoh, float price, String name) {
		super();
		this.qoh = qoh;
		this.price = price;
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", qoh=" + qoh + ", price=" + price + ", name=" + name + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
