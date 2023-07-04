package Aufgabe1;

public class SequenceTest {
	public static void main(String[] args) {
		Sequence s = new Primes();
		while (true) {
			System.out.println(s.getNext());
			IO.readBoolean();
		}
	}
}
