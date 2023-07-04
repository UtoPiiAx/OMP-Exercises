package Aufgabe1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	private static final int[] NUMBERS = new int[] { 3, 5, 8, 12, 9, 18, 15, 10, 7, 11, 20 };
	
	@Test
	void test() {
		for (int i = 0; i < NUMBERS.length; i++) {
			FibonacciRecursive recursive = new FibonacciRecursive();
			FibonacciParallel parallel = new FibonacciParallel();
			FibonacciDynamic dynamic = new FibonacciDynamic();
			FibonacciDynamicParallel dynamicParallel = new FibonacciDynamicParallel();

			long recursiveResult = recursive.calculate(NUMBERS[i]);
			long parallelResult = parallel.calculate(NUMBERS[i]);
			long dynamicResult = dynamic.calculate(NUMBERS[i]);
			long dynamicParallelResult = dynamicParallel.calculate(NUMBERS[i]);

			assertEquals(recursiveResult, parallelResult);
			assertEquals(recursiveResult, dynamicResult);
			assertEquals(recursiveResult, dynamicParallelResult);
		}
	}

}
