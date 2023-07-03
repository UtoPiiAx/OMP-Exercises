package Aufgabe1;

public class Customer {
	
	private String name;
	private Account[] accounts;
	private Address homeAddress;
	private Address workAddress;
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public Account[] getAccounts() { return accounts; }
	
	public void setAccounts(Account[] accounts) { this.accounts = accounts; }
	
	public Address getHomeAddress() { return homeAddress; }
	
	public void setHomeAddress(Address homeAddress) { this.homeAddress = homeAddress; }
	
	public Address getWorkAddress() { return workAddress; }
	
	public void setWorkAddress(Address workAddress) { this.workAddress = workAddress; }

	public boolean removeAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].equals(account)) {
				accounts[i] = null;
			} return true;
		}
		return false;
	}

}
