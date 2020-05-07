package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Tema1.Account;
import Tema1.AccountDbMock;
import Tema1.FlightHelper;
import Tema1.PersonalInfo;
import Tema1.Provider;

class TestLogin {

	@Test
	void createAccountWithValidRegistrationData() {
		int initialDbLength = AccountDbMock.accounts.size();
		PersonalInfo accountPersonalInfo = new PersonalInfo("Beniamin", "Munteanu", "1971219035628", "0748619765");
		if(accountPersonalInfo.isValid()) {
			Account account = new Account("username","password", accountPersonalInfo);
			AccountDbMock.accounts.add(account);
		}
		assertTrue(AccountDbMock.accounts.size () > initialDbLength);
		
	}
	
	@Test 
	void createAccountWithInvalidRegistrationData() {
		int initialDbLength = AccountDbMock.accounts.size();
		PersonalInfo accountPersonalInfo = new PersonalInfo("Beniamin", "Munteanu", "1971219012312335628", "07423338619765");
		if(accountPersonalInfo.isValid()) {
			Account account = new Account("username","password", accountPersonalInfo);
			AccountDbMock.accounts.add(account);
		}
		assertFalse(AccountDbMock.accounts.size () > initialDbLength);
	}

	@Test
	void onSuccessfullLoginReturnFlightList() {
		Account account = new Account("gigi", "masinuta", AccountDbMock.validPersonalInfo);
		try {
			account.login();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(account.flightHelper.getAvailableFlights().size() == FlightHelper.getAvailableFlights().size());
	}
	
	@Test
	void onInvalidLoginReturnError() {
		Account account = new Account("gigel", "costica", AccountDbMock.invalidPersonalInfo);
		try {
			account.login();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().equals("invalid credentials"));
		}
	}
	
}
