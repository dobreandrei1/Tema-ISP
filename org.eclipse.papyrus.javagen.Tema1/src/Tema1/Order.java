package Tema1;

import java.util.ArrayList;
import java.util.List;


public class Order {
	
	public double totalPrice;

	public List<Ticket> tickets = new ArrayList<>();
	
	public Order() {
			
		}
		
	
	public Order(List<Ticket> tickets) {
		super();
		this.tickets = tickets;
		
		this.totalPrice = tickets.stream()
				.mapToDouble(t -> t.price)
				.sum();
	}
	
	public boolean isValid() {
		return !tickets.isEmpty();
	}
	
	public boolean addTicketToCart(Ticket ticket) {
		if (!tickets.contains(ticket)) {
			tickets.add(ticket);
			return true;
		} else {
			return false;
		}
	}
	
};
