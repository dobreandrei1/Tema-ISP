// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema1;

/************************************************************/
/**
 * 
 */
public class Ticket {
	/**
	 * 
	 */
	public ClassType classType;
	/**
	 * 
	 */
	public int seatNumber;
	/**
	 * 
	 */
	
	public Ticket(ClassType classType, int seatNumber, double price) {
		super();
		this.classType = classType;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	
	
	public Ticket() {
		super();
	}
	
	
	
	
	
	
	
	public double price;
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
};