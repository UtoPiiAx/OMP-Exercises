package Aufgabe2;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] numbers = {2, 3, 9, 33, -2, 4, 55, 66, -234};
		print(numbers);
		QuickSort.sort(numbers);
		print(numbers);
		
		int[] numbers2 = {2, 3, 9, 33, -2, 4, 55, 66, -234};
		print(numbers2);
		QuickSortThreaded.sort(numbers2);
		print(numbers2);
	}
	
	private static void print(int[] numbers) {
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

}
