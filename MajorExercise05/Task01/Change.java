public abstract class Change {
	
	/**
	 * Calculates the number of solutions for the coin-change-problem, given
	 * a set of coins <code>coins</code> and an amount of money <code>money</code>
	 * @param coins the set of coins
	 * @param money the amount of money
	 * @return the number of possible solutions
	 */
	public abstract int count(int[] coins, int money);

	public static void main(String[] args) {
		test(new ChangeRecursive(), "Recursive");
		test(new ChangeGreedy(), "Greedy");
		test(new ChangeDynamic(), "Dynamic Programming");
		test(new ChangeDynamic2(), "Dynamic Programming 2");
	}
	
	private static void test(Change change, String title) {
		System.out.println(title);
		int[] coins1 = new int[] { 1, 2, 5 };
		int[] coins2 = new int[] { 1, 2, 5, 10, 20, 50 };
		measure(change, coins1, 5);
		measure(change, coins1, 12);
		measure(change, coins1, 123);
		measure(change, coins2, 123);
		measure(change, coins2, 213);
		measure(change, coins2, 321);
		System.out.println();
	}
	
	private static final int REPETITIONS = 5;

	private static void measure(Change change, int[] coins, int money) {
		int result = 0;
		long totalNs = 0, start, stop;
		for (int i = 0; i < REPETITIONS; i++) {
			start = System.nanoTime();
			result = change.count(coins, money);
			stop = System.nanoTime();
			totalNs += stop - start;
		}
		totalNs /= REPETITIONS;
		long totalMs = totalNs / 1000000;
		System.out.println("\t" + result + " (" + totalNs + " ns, ~" + totalMs + " ms)");
	}

}
