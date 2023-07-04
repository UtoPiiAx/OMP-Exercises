package Aufgabe2;

import Aufgabe2.QuickSort;

public class QuickSortThreaded extends QuickSort implements Runnable {

	/**
	 * sortiert das uebergebene Array in aufsteigender Reihenfolge
	 * gemaess dem QuickSort-Algorithmus (parallel!)
	 */
	public static void sort(int[] numbers) {
		Thread thread = new Thread(new QuickSortThreaded(numbers, 0, numbers.length -1));
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int[] numbers;
	private int from;
	private int to;

	private QuickSortThreaded(int [] numbers, int from, int to) {
		this.numbers = numbers;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		quickSort(this.numbers, this.from, this.to);
	}

	/**
	 * der Quicksort-Algorithmus wird auf dem Array zwischen den
	 * angegebenen Indizes ausgefuehrt
	 */
	protected void quickSort(int[] numbers, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = divide(numbers, leftIndex, rightIndex);
			Thread part1 = new Thread(new QuickSortThreaded(numbers, leftIndex, pivotIndex - 1));
			Thread part2 = new Thread(new QuickSortThreaded(numbers, pivotIndex + 1, rightIndex));
			part1.start();
			part2.start();
			try {
				part1.join();
				part2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
