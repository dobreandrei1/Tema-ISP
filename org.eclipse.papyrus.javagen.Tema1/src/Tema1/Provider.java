package Tema1;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

/************************************************************/
/**
 * 
 */
public class Provider {
	
	public static List<Flight> flights = new ArrayList<>();
	private static Provider singleton = null;
	
	private Provider() {
		
	}
	
	public static final Provider getSingletonInstance() {
		if (singleton == null) {
			flights.add(new Flight(new DateTime(2020, 1, 20, 15, 30), new DateTime(2020, 1, 20, 17, 30), "boeing", "Bucuresti", "Edinburgh", 100));
			flights.add(new Flight(new DateTime(2020, 1, 20, 16, 30), new DateTime(2020, 1, 20, 18, 30), "boeing", "Bucuresti", "Edinburgh", 100));
			flights.add(new Flight(new DateTime(2020, 1, 20, 17, 30), new DateTime(2020, 1, 20, 19, 30), "boeing", "Bucuresti", "Edinburgh", 100));
			flights.add(new Flight(new DateTime(2020, 1, 21, 15, 30), new DateTime(2020, 1, 21, 17, 30), "boeing", "Bucuresti", "Budapest", 100));
			flights.add(new Flight(new DateTime(2020, 1, 22, 15, 30), new DateTime(2020, 1, 22, 17, 30), "boeing", "Bucuresti", "London", 100));
			singleton = new Provider();
		} 
		return singleton;
	}
	
	public final List<Flight> provideFlights() {
		return flights;
	}
	
};
