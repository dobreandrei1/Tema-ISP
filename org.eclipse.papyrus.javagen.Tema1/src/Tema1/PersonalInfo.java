// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Tema1;

/************************************************************/
/**
 * 
 */
public class PersonalInfo {
	/**
	 * 
	 */
	public String lastName;
	/**
	 * 
	 */
	public String firstName;
	/**
	 * 
	 */
	public String identityNumber;
	/**
	 * 
	 */
	public String mobileNumber;
	
	
	
	public PersonalInfo(String lastName, String firstName, String identityNumber, String mobileNumber) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.identityNumber = identityNumber;
		this.mobileNumber = mobileNumber;
	}
	
	
	public PersonalInfo() {
		super();
	}
	
	
	public boolean isValid() {
		if (firstName == null
				|| lastName == null
				|| mobileNumber.length() != 10
				|| identityNumber.length() != 13) {
			return false;
		}
		return true;
	}
	
	
};