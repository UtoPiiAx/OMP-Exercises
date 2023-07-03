public class ChangeDynamic2 extends Change {
	
	@Override
	public int count(int[] coins, int money) {
		if (money < 0) {
			throw new IllegalArgumentException("Amount of money must be positive! Expected: >= 0, found: " + money + ".");
		}
		if (coins == null || coins.length == 0) {
			throw new IllegalArgumentException("At least one coin option must be given!");
		}
		for (int coin : coins) {
			if (coin <= 0) {
				throw new IllegalArgumentException("Coin values must be positive! Expected: > 0, found: " + coin + ".");
			}
		}
		int[] table = new int[money + 1];
		table[0] = 1;
		for (int coin : coins) {
			for (int amount = coin; amount <= money; amount++) {
				table[amount] += table[amount - coin];
			}
		}
		return table[money];
	}

}
