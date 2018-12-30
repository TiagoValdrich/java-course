package entities;

public class Product {

	private String name;
	private double price;
	private int quantity;
	
	// Sobrecarga
	public Product() {
		
	}
	
	public Product(String name, double price, int quantity) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public Product(String name, double price) {
		
		this.name = name;
		this.price = price;
		
	}
	
	public double totalValueInStock() {
		
		return this.quantity * this.price;
		
	}
	
	public void addProducts(int quantity) {
		
		this.quantity += quantity;
		
	}
	
	public void removeProducts(int quantity) {
		
		this.quantity -= quantity;
		
	}
	
	public String toString() {
		
		return this.name + ", $" + String.format("%.2f", this.price) + ", " + this.quantity + " units, Total: $" + String.format("%.2f", this.totalValueInStock());
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public double getPrice() {
		
		return this.price;
		
	}
	
	public void setPrice(double price) {
		
		this.price = price;
		
	}
	
	public int getQuantity() {
		
		return this.quantity;
		
	}
}
