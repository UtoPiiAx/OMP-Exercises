package Aufgabe1;

public class Bank {
	
	private String name;
	private Account[] accounts;

	public Bank(String name) { this.name = name; }
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Account[] getAccounts() { return accounts; }

	public void setAccounts(Account[] accounts) { this.accounts = accounts; }

	public boolean addAccount (Account account) {
		// if the account is listed for another bank, refuse it
		if (account.getBank() != null) {
			return false;
		}
		//make sure that the array is initialised
		accounts = new Account [0];
		//copy existing accounts into new, larger array
		Account [] tmp = new Account [accounts.length + 1];

		for (int i = 0; i < accounts.length; i++) {
			tmp[i] = accounts[i];
		}
		//add new account to new array
		tmp[accounts.length] = account;

		//update the account list
		accounts = tmp;
		return true;
		//make sure that the account is listed for this bank
	}

	//use this method to remove a bank
/*	public void close () {
		if (accounts != null) {
			// make sure that accounts are removed from the customers as well
			for (Customer customer : accounts.getHolders()) {
				customer.removeAccount(accounts);
			}
		}
	}
*/
	public boolean contains(Account account) {
		if (accounts == null) {
			return false;
		}

		for (Account a : accounts) {
			if (a.equals(account)) {
				return true;
			}
		} return false;
	}

}
