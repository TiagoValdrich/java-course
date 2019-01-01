package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orderItems = new ArrayList<>();
	private Client client;
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order(Date moment, OrderStatus status, List<OrderItem> orderItems, Client client) {
		this.moment = moment;
		this.status = status;
		this.orderItems = orderItems;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	public Double total() {
		
		double sum = 0.0;
		
		for (OrderItem item : orderItems) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(this.getMoment()));
		sb.append("\nOrder status: ");
		sb.append(this.getStatus());
		sb.append("\nClient: " + this.getClient());
		sb.append("\nOrder items:\n");
		
		for(OrderItem item : this.getOrderItems()) {
			
			sb.append(item.getProduct().getName() + ", ");
			sb.append(item.getProduct().getPrice() + ", ");
			sb.append("Quantity: " + item.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
			
		}
		
		sb.append("Total price: $" + String.format("%.2f", this.total()));
		return sb.toString();
		
	}
}
