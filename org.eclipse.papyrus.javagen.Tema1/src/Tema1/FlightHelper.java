package Tema1;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

public class FlightHelper {
	
	public List<Flight> getAvailableFlights() {
		return Provider.getSingletonInstance().provideFlights().stream()
				.filter(f -> f.hasValidSchedule())
				.filter(f -> f.departureDateTime.isBefore(DateTime.now()))
				.collect(Collectors.toList());
	}
	
	public List<Flight> getSortedFlightsByDate() {
		return getAvailableFlights().stream()
				.sorted((f1, f2) -> f1.departureDateTime.isBefore(f2.arrivalDateTime) ? 1 : 0)
				.collect(Collectors.toList());
	}
	
	public List<Flight> getFlightsOnBudget(double budget) {
		return getAvailableFlights().stream()
				.filter(f -> !f.tickets.isEmpty())
				.filter(f -> f.hasValidSchedule())
				.filter(f -> f.tickets.stream().
						mapToDouble(t -> t.price).
						min().
						getAsDouble() < budget)
				.collect(Collectors.toList());
	}
	
	public List<Flight> getSearchedFlights(String query) {
		return getAvailableFlights().stream()
				.filter(f -> f.hasValidSchedule())
				.filter(f -> f.arrivalCity.toLowerCase().contains(query.toLowerCase()) 
						|| f.departureCity.toLowerCase().contains(query.toLowerCase()))
				.collect(Collectors.toList());
	}
}
