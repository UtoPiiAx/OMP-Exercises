package Aufgabe2;

public class QuickSort {

	/**
	 * sortiert das uebergebene Array in aufsteigender Reihenfolge
	 * gemaess dem QuickSort-Algorithmus
	 */
	public static void sort(int[] numbers) {
		new QuickSort().quickSort(numbers, 0, numbers.length - 1);
	}

	/**
	 * der Quicksort-Algorithmus wird auf dem Array zwischen den
	 * angegebenen Indizes ausgefuehrt
	 */
	protected void quickSort(int[] numbers, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = divide(numbers, leftIndex, rightIndex);
			quickSort(numbers, leftIndex, pivotIndex - 1);
			quickSort(numbers, pivotIndex + 1, rightIndex);
		}
	}

	/**
	 * liefert den Index des Pivot-Elementes und ordnet das Array innerhalb
	 * der angegebenen Indizes so um, dass alle Zahlen links vom Index
	 * kleiner oder gleich und alle Zahlen rechts vom Index groesser
	 * oder gleich dem Pivot-Element sind
	 */
	protected int divide(int[] numbers, int leftIndex, int rightIndex) {
		int pivotIndex = choosePivotIndex(numbers, leftIndex, rightIndex);
		int pivotValue = numbers[pivotIndex];
		// das Pivot-Element kommt nach ganz rechts im Array
		swap(numbers, pivotIndex, rightIndex);
		int left = leftIndex - 1;
		int right = rightIndex;
		// ordne das Array so um, dass jeweils alle Elemente links vom
		// Zeiger left kleiner und alle Elemente rechts vom Zeiger right
		// groesser als das Pivot-Element sind
		do {
			left++;
			while (left <= rightIndex && numbers[left] <= pivotValue)
				left++;
			right--;
			while (right >= leftIndex && numbers[right] >= pivotValue)
				right--;
			if (left < right) {
				swap(numbers, left, right);
			}
		} while (left < right);
		// platziere das Pivot-Element an seine korrekte Position
		if (left < rightIndex) {
			swap(numbers, left, rightIndex);
			return left;
		} else {
			return rightIndex;
		}
	}

	/**
	 * waehlt einen beliebigen Index zwischen den angegebenen Indizes
	 */
	protected int choosePivotIndex(int[] numbers, int leftIndex, int rightIndex) {
		// in diesem Fall einfach der mittleren Index
		return (leftIndex + rightIndex) / 2;
	}

	/**
	 * tauscht die Elemente des Arrays an den angegebenen Indizes
	 */
	protected void swap(int[] numbers, int index1, int index2) {
		if (index1 != index2) {
			int tmp = numbers[index1];
			numbers[index1] = numbers[index2];
			numbers[index2] = tmp;
		}
	}
	
}
