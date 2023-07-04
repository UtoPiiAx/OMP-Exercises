package Aufgabe2;

public class Barriers {

	private final static int NUMBER = 3;

	public static void main(String[] args) {
		WaitingRunner[] runner = new WaitingRunner[NUMBER];
		HoldingPoint point = new HoldingPoint(NUMBER);
		for (int i = 0; i < NUMBER; i++) {
			runner[i] = new WaitingRunner(i, point);
		}
		for (int i = 0; i < NUMBER; i++) {
			runner[i].start();
		}
	}
}
class WaitingRunner extends Thread {

	private int number;
	private HoldingPoint point;

	public WaitingRunner(int n, HoldingPoint p) {
		point = p;
		number = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			if (i % 10 == 0) {
				point.reached();
			}
			System.out.println("Thread " + number + ": " + i);
		}
	}
}
class HoldingPoint {
		private int number;
		private int numberReached;

		public HoldingPoint(int n) {
			number = n;
			numberReached = 0;
		}

		public synchronized void reached() {
			numberReached++;
			//nächster wartender Thread ist an der Reihe
			if (numberReached == number) {
				numberReached = 0;
				this.notifyAll();
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) { }
			}
		}
	}
