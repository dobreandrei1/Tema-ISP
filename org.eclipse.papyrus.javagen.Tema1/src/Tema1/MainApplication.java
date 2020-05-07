package Tema1;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
	

	public static void main(String[] args) {		
		
		List<Ticket> bilete = new ArrayList<>();
		
		bilete.add(new Ticket(ClassType.Business, 1, 0.99));
		
		bilete.add(new Ticket(ClassType.Economy, 2, 0.92));		
		
		 
		AccountDbMock.accounts.add(new Account("Admin", "Admin"));
		
		System.out.println((new Account("prea", "Asa").isValidLogin()));
		
		System.out.println(Provider.getSingletonInstance().provideFlights());
		
		
	}
	
	
	

}
