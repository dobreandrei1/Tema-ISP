package Tema1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.DateTime;


public class Flight {
	
	
	public List<Ticket> tickets;
	
	public DateTime departureDateTime;
	
	public DateTime arrivalDateTime;
	
	public String planeModel;
	
	public String departureCity;
	
	public String arrivalCity;
	
	public int numberOfSeats;
	

	

	public Flight(DateTime departureDateTime, DateTime arrivalDateTime, String planeModel, String departureCity,
			String arrivalCity, int numberOfSeats) {
		super();
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.planeModel = planeModel;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.numberOfSeats = numberOfSeats;
		this.tickets = new ArrayList<>();
	}


	public double getTotalTicketsMoney() {
		return tickets.stream()
				.map(t -> t.price).reduce(0.0, Double::sum);
				
	}
	
	
	public double getTotalPriceForBussiness() {
		return tickets.stream().filter(t ->t.classType.equals(ClassType.Business))
				.map(t -> t.price).reduce(0.0, Double::sum);
				
	}
	
	public boolean addTicket(Ticket ticket) {
		if (tickets.size() < numberOfSeats) {
			tickets.add(ticket);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasValidSchedule() {
		return arrivalDateTime.isBefore(departureDateTime);
	}
	
};


