package Tema1;

import java.util.ArrayList;
import java.util.List;

public class AccountDbMock {

	public static List<Account> accounts = new ArrayList<>();
	private static AccountDbMock singletonAccountListMock = null;
	
	public static final PersonalInfo validPersonalInfo = new PersonalInfo("Beniamin", "Munteanu", "1971219035628", "0748619765");
	public static final PersonalInfo invalidPersonalInfo = new PersonalInfo("Beniamin", "Munteanu", "19712", "07486197651123");

	public AccountDbMock() {
		
	}
	
	public static final AccountDbMock getSingletonInstance() {
		if(singletonAccountListMock == null) {
			accounts.add(new Account("gigi", "masinuta", validPersonalInfo));
			accounts.add(new Account("mitica", "capDeLemn", validPersonalInfo));
			accounts.add(new Account("luigi", "talianul", validPersonalInfo));
			accounts.add(new Account("titel", "bmw", validPersonalInfo));
			accounts.add(new Account("Zana", "Maseluta", validPersonalInfo));
			accounts.add(new Account("Grigore", "Ureche", validPersonalInfo));
			singletonAccountListMock =  new AccountDbMock();
		} 
		return singletonAccountListMock;
	}
	
	public final List<Account> getMockUserList(){
		return accounts;
	}
	
	
	
}
