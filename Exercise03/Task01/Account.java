public class Account {
	
	private Customer[] holders;
	private Bank bank;
	private long balance;
	private String iban;
	
	public Account(String iban) { this.iban = iban; }

	public void setBank(Bank bank) {
		// disallow arbitrary banks, make sure that
		// the account actually belongs to that bank
		if (bank.contains(this)) {
			this.bank = bank;
		}
	}

	public Bank getBank() {
		return bank;
	}

	public Customer[] getHolders() { return holders; }

	public void setHolders(Customer[] holders) { this.holders = holders; }

	public long getBalance() { return balance; }

	public void setBalance(long balance) { this.balance = balance; }

	public String getIban() { return iban; }

}
