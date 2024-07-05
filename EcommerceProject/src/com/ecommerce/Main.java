import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.*;
import com.ecommerce.orders.Order;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// welcoming user
		System.out.println("Hello, Welcome to our shop!");
		System.out.println("Enter your Name: ");
		String customerName = scan.nextLine();
		Customer newCustomer = new Customer(1,customerName);
		ArrayList<Product> productList = new ArrayList<>(){{
			add(new Product(0, "apple", 700));
			add(new Product(1, "hp", 800));
			add(new Product(2, "macintosh", 850));
			add(new Product(3, "lenovo", 500));
			add(new Product(4, "dell", 900));
		}};
	
		System.out.println();
		System.out.println("Here are the list of products we sell: ");
		for(Product product:productList) {
			System.out.println("Product Name: " + product.getProductName() + "," + " Product price: " + product.getProductPrice() + "," + " product Id: "+ product.getProductId());
		}
		System.out.println("How many (product)products do you want purchase: ");
		
		int productCount = scan.nextInt();
		scan.nextLine();
		int productId;
		String productName;
		boolean isProductFound = false;
		
		try {
			do {
				System.out.println("Enter Product Id: ");
				productId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Product Name: ");
				productName = scan.nextLine();
				if(productName.toLowerCase().equals(productList.get(productId).getProductName())) {
					newCustomer.addProduct(productList.get(productId));
					isProductFound = true;
				} else {
					System.out.println("We have no such product. Try another.");
				}

				productCount -= 1;
			} while(productCount > 0);
			
			if(isProductFound) {
				// order summary
				Order newOrder = new Order(newCustomer, newCustomer.getCustomerProducts());
				System.out.println(newOrder.generateOrderSummary());
				System.out.println("Thanks for shopping from us.");
			}
			
		} catch(Exception e) {
			System.out.println("Error" + e.getMessage());
		}
			
			
			
		
	}

}

