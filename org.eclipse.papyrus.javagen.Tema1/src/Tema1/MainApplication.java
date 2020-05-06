package Tema1;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
	
	public static List<Account> accounts = new ArrayList<Account>();
	
	

	public static void main(String[] args) {		
		
		List<Ticket> bilete = new ArrayList<>();
		
		bilete.add(new Ticket(ClassType.Business, 1, 0.99));
		
		bilete.add(new Ticket(ClassType.Economy, 2, 0.92));		
		
		 
		MainApplication.accounts.add(new Account("Admin", "Admin"));
		
		System.out.println((new Account("prea", "Asa").isValidLogin()));
		
		System.out.println(Provider.getInstance().provideFlights());
		
		
	}
	
	
	

}
