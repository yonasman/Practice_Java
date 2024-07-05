package com.ecommerce;

import java.util.ArrayList;

public class Product {

	private int productId;
	private String productName;
	private double productPrice;

	public Product(int productId, String productName, double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	
	// setters and getters
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductId() {
		return this.productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductPrice() {
		return this.productPrice;
	}



}

