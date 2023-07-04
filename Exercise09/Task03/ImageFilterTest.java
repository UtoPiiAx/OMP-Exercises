package Aufgabe3;

import java.io.File;
import java.io.IOException;

public class ImageFilterTest {
	
	private static final int REPETITIONS = 5;

	public static void main(String[] args) {
		ImageFilter filterSequential = new ImageFilter();
		ImageFilter filterThreaded = new ImageFilterThreaded();
		try {
			filterSequential.setImage(new File("C:\\Users\\lohma\\eclipse\\OMP\\Uebung09\\src\\Aufgabe3\\university_of_oldenburg.jpg"));
			filterThreaded.setImage(new File("C:\\Users\\lohma\\eclipse\\OMP\\Uebung09\\src\\Aufgabe3\\university_of_oldenburg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		long start;
		long stop;
		long time;
		start = System.nanoTime();
		for (int i = 0; i < REPETITIONS; i++) {
			runFilters(filterSequential);
		}
		stop = System.nanoTime();
		time = (stop - start) / 1000000L;
		System.out.println("Sequential runtime: " + time + " ms");
		start = System.nanoTime();
		for (int i = 0; i < REPETITIONS; i++) {
			runFilters(filterThreaded);
		}
		stop = System.nanoTime();
		time = (stop - start) / 1000000L;
		System.out.println("Threaded runtime: " + time + " ms");
	}
	
	private static void runFilters(ImageFilter filter) {
		try {
			filter.applyFilter(ImageFilter.FILTER_BLUR, new File("C:\\Users\\lohma\\eclipse\\OMP\\Uebung09\\src\\Aufgabe3\\university_of_oldenburg_blur.jpg"));
			filter.applyFilter(ImageFilter.FILTER_SHARPEN, new File("C:\\Users\\lohma\\eclipse\\OMP\\Uebung09\\src\\Aufgabe3\\university_of_oldenburg_sharpen.jpg"));
			filter.applyFilter(ImageFilter.FILTER_LINES, new File("C:\\Users\\lohma\\eclipse\\OMP\\Uebung09\\src\\Aufgabe3\\university_of_oldenburg_lines.jpg"));
		} catch (IOException | InvalidFilterException e) {
			e.printStackTrace();
		}
	}

}
