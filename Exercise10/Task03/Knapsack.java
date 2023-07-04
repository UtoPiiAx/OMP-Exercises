package Aufgabe3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Knapsack {
	
	protected List<Item> candidates = new ArrayList<>();
	protected int capacity;

	public Knapsack(int capacity, Collection<Item> candidates) {
		super();
		this.capacity = capacity;
		this.candidates.addAll(candidates);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Item> getCandidates() {
		return candidates;
	}
	
	public abstract Selection pack();
	
	private static final int REPETITIONS = 5;
	private static final int CAPACITY = 49;

	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Item("Banknote", 100, 1));
		items.add(new Item("Goldbar", 1000, 30));
		items.add(new Item("Diamond", 750, 5));
		test("Recursive", new KnapsackRecursive(CAPACITY, items));
		test("Greedy", new KnapsackGreedy(CAPACITY, items));
		test("Dynamic Programming", new KnapsackDynamic(CAPACITY, items));
	}
	
	private static void test(String title, Knapsack knapsack) {
		System.out.print(title);
		Selection result = null;
		long totalNs = 0;
		for (int i = 0; i < REPETITIONS; i++) {
			long start = System.nanoTime();
			result = knapsack.pack();
			long stop = System.nanoTime();
			totalNs += stop - start;
			System.out.print(".");
		}
		System.out.println("\n\t" + result);
		totalNs /= REPETITIONS;
		long totalMs = totalNs / 1000000L;
		System.out.println("\tTime required: " + totalNs + " ns (~ " + totalMs + " ms)");
		System.out.println();
	}

}
