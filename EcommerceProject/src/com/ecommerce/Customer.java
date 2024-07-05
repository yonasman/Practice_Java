package com.ecommerce;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.orders.Order;

public class Customer {

	private int customerId;
	private String customerName;
	private double total = 0;
	// variable to store shopped products
	List<Product> customerProducts = new ArrayList<>(); 
	List<Order> orders;

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.orders = new ArrayList<>();
	}
	
	// getters and setters
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	
	// add product method
	public void addProduct(Product product) {
		customerProducts.add(product);
	}
	// remove product method
	public void removeProduct(Product product) {
		customerProducts.remove(product);
	}
	
	// calculating total
	public double totalPrice() {
		total = 0;
		System.out.println("inside total");

		for(Product product:customerProducts) {
			System.out.println(product.getProductPrice());
			System.out.println(product);
			total += product.getProductPrice();
		}
		return total;
	}
	// get customer products
	public List<Product> getCustomerProducts() {
		return customerProducts;
	}
	
}

