package Aufgabe1;

public class Banking {
	
	public static void main(String[] args) {
		Bank sbt = new Bank("Smaug Bank & Trust");
		sbt.setAccounts(new Account[1]);
		sbt.getAccounts()[0] = new Account("ER99123412341234123412");
		sbt.getAccounts()[0].setBalance(54100000000L);
		Customer thorin = new Customer();
		thorin.setAccounts(new Account[1]);
		thorin.getAccounts()[0] = sbt.getAccounts()[0];
		thorin.setName("Thorin");
		Address home = new Address();
		home.setStreet("Kingsroad 1");
		home.setPostCode("12345");
		home.setCity("Dunland");
		thorin.setHomeAddress(home);
		Address work = new Address();
		work.setStreet("Throneroom 1");
		work.setPostCode("54321");
		work.setCity("Erebor");
		thorin.setWorkAddress(work);
		sbt.getAccounts()[0].setHolders(new Customer[] { thorin });
	}

}
