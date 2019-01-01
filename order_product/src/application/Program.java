package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Registering client
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		// Registering the order		
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		OrderStatus orderStatus = OrderStatus.valueOf(status);
		
		Order order = new Order(new Date(), orderStatus, client);
		
		System.out.print("How many items will be added to this order? ");
		int numberOfItems = sc.nextInt();		
		
		for(int i = 1; i <= numberOfItems; i++) {
			
			sc.nextLine();
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		
		System.out.println(order);
		
		sc.close();
	}

}
