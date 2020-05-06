package Tema1;


public class Ticket {

	public ClassType classType;

	public int seatNumber;
	
	public double price;
	
	
	public Ticket(ClassType classType, int seatNumber, double price) {
		super();
		this.classType = classType;
		this.seatNumber = seatNumber;
		this.price = price;
	}

	// constructor care faciliteaza crearea unei instante de bilet
	// pentru testare, cand ne intereseaza doar pretul acestuia
	public Ticket(double price) {
		super();
		this.price = price;
	}
	
	
	
};
