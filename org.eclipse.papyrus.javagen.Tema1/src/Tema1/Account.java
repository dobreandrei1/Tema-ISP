package Tema1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Account {
	
	public String username;
	
	public String password;
	
	public PersonalInfo personalinfo;
	
	public List<Order> orders = new ArrayList<>();
	
	public FlightHelper flightHelper;
	
	// proprietate hardcodata deoarece colegul meu
	// se ocupa de partea de logare
	public boolean isLoggedIn = true;
	
	
	public Account(String username, String password , PersonalInfo personalInfo) {
		super();
		this.username = username;
		this.password = password;
		this.personalinfo = personalInfo;
	}
	
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public boolean isValidLogin() {
		return AccountDbMock.accounts.stream()
				.filter(a -> a.username.equals(this.username) 
						&& a.password.equals(this.password))
				.collect(Collectors.toList()).size() == 0 ? true : false;
		
	}
	
	public void login() throws Exception {
		if(this.isValidLogin()) {
			this.isLoggedIn = true;
			this.setFlightHelper(new FlightHelper());
		}
		else {
			this.isLoggedIn = false;
			throw new Exception("invalid credentials");
		}
			
	}
	
	public double getTotalMoneySpent() {
		return orders.stream()
				.mapToDouble(o -> o.totalPrice)
				.reduce(0, (a, b) -> a+b);
	}

	public FlightHelper getFlightHelper() {
		return flightHelper;
	}

	public void setFlightHelper(FlightHelper flightHelper) {
		this.flightHelper = flightHelper;
	}
	
	public boolean addOrder (Order order) {
		if (order.isValid() && isLoggedIn) {
			orders.add(order);
			return true;
		}
		return false;
	}
	
	public boolean addToCart(Ticket ticket) {
		return orders.get(orders.size()-1).addTicketToCart(ticket);
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
};
