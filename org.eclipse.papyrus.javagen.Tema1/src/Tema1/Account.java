// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema1;

import java.util.List;
import java.util.stream.Collectors;

/************************************************************/
/**
 * 
 */
public class Account {
	/**
	 * 
	 */
	public String username;
	/**
	 * 
	 */
	public String password;
	/**
	 * 
	 */
	public PersonalInfo personalinfo;
	
	
	public List<Order> orders;
	
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public boolean isValidLogin() {
		return 	MainApplication.accounts.stream()
				.filter(a -> a.username.equals(this.username) 
						&& a.password.equals(this.password))
				.collect(Collectors.toList()).size() == 0 ? false : true;
	}
	
	
	public double getTotalMoneySpent() {
		return orders.stream()
				.mapToDouble(o -> o.totalPrice)
				.reduce(0, (a, b) -> a+b);
	}
	
	
};
