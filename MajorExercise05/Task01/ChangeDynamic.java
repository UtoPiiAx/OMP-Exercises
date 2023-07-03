import java.util.HashMap;
import java.util.Map;

public class ChangeDynamic extends Change {
	
	private Map<Pair<Integer>, Integer> cache = new HashMap<>();

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
		cache.clear();
		return count(coins, money, coins.length - 1);
	}

	private int count(int[] coins, int money, int index) {
		if (money < 0) {
			return 0;
		}
		if (money == 0) {
			return 1;
		}
		if (index < 0) {
			return 0;
		}
		Pair<Integer> pair = new Pair<>(money, index);
		Integer result = cache.get(pair);
		if (result != null) {
			return result;
		}
		result = count(coins, money, index - 1) + count(coins, money - coins[index], index);
		cache.put(pair, result);
		return result;
	}

}
