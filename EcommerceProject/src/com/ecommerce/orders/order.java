package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1; // Static variable to track next orderId
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;

    // Constructor
    public Order(Customer customer, List<Product> products) {
        this.orderId = nextOrderId++; // Assign current orderId and increment for next order
        this.customer = customer;
        this.products = new ArrayList<>(products); // Create a new list to avoid reference issues
        calculateOrderTotal();
    }

    // Method to calculate order total
    private void calculateOrderTotal() {
        orderTotal = 0;
        for (Product product : products) {
            orderTotal += product.getProductPrice();
        }
    }

    // Method to generate order summary
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order placed successfully.").append("\n");
        summary.append("Order ID: " + orderId).append("\n");
        summary.append("Customer: ").append(customer.getCustomerName()).append("\n");
        summary.append("Products:\n");
        for (Product product : products) {
            summary.append("- ").append(product.getProductName()).append(": $").append(product.getProductPrice()).append("\n");
        }
        summary.append("Order Total: $").append(orderTotal).append("\n");
        return summary.toString();
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}

