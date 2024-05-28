package com.wipro.jdbc.model;

public class Product {
	Integer product_id;
	String product_name;
	Integer price;
	
	public Product(){
		
	}
	public Product(Integer product_id, String product_name, Integer price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}
	public int getId() {
		return product_id;
	}
	public void setId(Integer product_id) {
		this.product_id = product_id;
	}
	public String getname() {
		return product_name;
	}
	public void setname(String product_name) {
		this.product_name = product_name;
	}
	public int getprice() {
		return price;
	}
	public void setprice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [ Product Id = " +product_id + ", Product Name = " +product_name+", Price = "+price+" ]";
	}
}
