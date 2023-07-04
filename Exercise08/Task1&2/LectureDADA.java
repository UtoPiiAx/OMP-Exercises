package Aufgabe1und2;

import java.io.IOException;

public class LectureDADA {

	public static void main(String[] args) {
		try {
			// task 1
			Lecture dada = Lecture.load("Aufgabe1und2/dada.dat");
			System.out.println(dada);
			// task 2
			Lecture.saveText("dada.txt", dada);
			dada = Lecture.loadText("dada.txt");
			System.out.println(dada);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
