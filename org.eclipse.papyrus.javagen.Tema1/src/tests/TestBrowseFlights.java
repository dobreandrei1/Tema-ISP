package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Tema1.Account;
import Tema1.FlightHelper;
import Tema1.MainApplication;
import Tema1.Order;
import Tema1.Provider;
import Tema1.Ticket;

class TestBrowseFlights {

	// se testeaza functionalitatea search-ului
	// in pagina cu toate zborurile, utilizatorul introducand
	// un text in text-field-ul de search si lista facand update automat
	@Test
	void testTextFilter() {
		Account account = new Account("user", "user");
		account.setFlightHelper(new FlightHelper());
		// exista un singur zbor catre Londra
		assertTrue(account.getFlightHelper().getSearchedFlights("Lond").size() == 1 ? true : false);
		// exista 3 zboruri din/catre Edinburgh
		assertTrue(account.getFlightHelper().getSearchedFlights("Edinb").size() == 3 ? true : false);
		// nu exista niciun zbor din/catre Amsterdam
		assertTrue(account.getFlightHelper().getSearchedFlights("Amsterdam").isEmpty() ? true : false);
	}
	
	// se testeaza selectarea zborurilor sub un anumit buget
	// instanta de FlightHelper verifica ca cel mai ieftin bilet
	// valabil pentru un zbor este sub bugetul setat de user
	@Test
	void testBudgetFilter() {
		Account account = new Account("user", "user");
		account.setFlightHelper(new FlightHelper());
		Provider singleton = Provider.getSingletonInstance();
		singleton.flights.get(0).tickets.add(new Ticket(20));
		singleton.flights.get(0).tickets.add(new Ticket(30));
		singleton.flights.get(1).tickets.add(new Ticket(35));
		singleton.flights.get(2).tickets.add(new Ticket(30));
		// exista un zbor care are un bilet cu un pret sub 22(dolari),
		// asadar lista returnata ar trebui sa aiba un singur element,
		// iar acesta sa fie egal cu zborul de mai sus, la care am adaugat 
		// biletul de 20(dolari)
		assertTrue(account.getFlightHelper().getFlightsOnBudget(22).get(0).equals(Provider.getSingletonInstance().provideFlights().get(0)));
		// nu exista un bilet atat de ieftin, asadar lista retunrata trebuie sa fie goala
		assertTrue(account.getFlightHelper().getFlightsOnBudget(19).isEmpty());
		// exista 2 zboruri care au bilete mai ieftine de 31(dolari),
		// mai exact zborurile 1 si 3 de mai sus
		assertTrue(account.getFlightHelper().getFlightsOnBudget(31).size() == 2);
	}
	
	// se testeaza functionalitatile de procesare a unei comenzi
	// si de calculare a sumei totale cheltuie de un client de
	// cand are contul pe platforma noastra
	@Test
	void testOrderPrice() {
		Account account = new Account("user", "user");
		account.setFlightHelper(new FlightHelper());
		Provider singleton = Provider.getSingletonInstance();
		Ticket ticket1 = new Ticket(10);
		Ticket ticket2 = new Ticket(20);
		Ticket ticket3 = new Ticket(30);
		Ticket ticket4 = new Ticket(90);
		singleton.flights.get(0).tickets.add(ticket1);
		singleton.flights.get(1).tickets.add(ticket2);
		singleton.flights.get(2).tickets.add(ticket3);
		singleton.flights.get(3).tickets.add(ticket4);
		// am creat o comanda invalida, care nu contine niciu bilet adaugat
		Order order1 = new Order(new ArrayList<Ticket>());
		// am creat o comanda valida, care are 3 bilete adaugate
		Order order2 = new Order(Arrays.asList(ticket1, ticket2, ticket3));
		// aceasta comanda nu va fi procesata, deoarece este invalida
		assertFalse(account.addOrder(order1));
		// aceasta comanda va fi adaugata cu succes
		assertTrue(account.addOrder(order2));
		// dupa cum observam de mai sus, cele 3 bilete valoreaza impreuna 60
		// din moment ce s-a facut o singura comanda de pe acest cont, suma totala
		// cheltuita trebuie sa fie egala cu 60
		assertTrue(account.getTotalMoneySpent() == 60);
		// mai adaug o comanda care are un singur bilet, de 90 dolari
		Order order4 = new Order(Arrays.asList(ticket4));
		account.addOrder(order4);
		// noua suma cheltuita ar trebui sa fie de 150 dolari
		assertTrue(account.getTotalMoneySpent() == 150);
	}
	
	@Test
	void testAddToCart() {
		Account account = new Account("user", "user");
		account.setFlightHelper(new FlightHelper());
		Provider singleton = Provider.getSingletonInstance();
		Ticket ticket1 = new Ticket(10);
		Ticket ticket2 = new Ticket(20);
		Order order = new Order();
		order.addTicketToCart(ticket1);
		account.addOrder(order);
		// nu se poate adauga in acelasi cart 
		// acelasi bilet de 2 ori (fiecare bilet este asociat unei singure
		// persoane, pentru a cumpara unul trebuie neaparat sa ai cont)
		assertFalse(account.addToCart(ticket1));
		// adaugarea unui alt bilet este permisa, chiar si la acelasi zbor
		// (un loc in acelasi avion dar de un pret diferit)
		assertTrue(account.addToCart(ticket2));
	}

}
