package Aufgabe1;
import java.util.concurrent.Semaphore;
class Output extends Thread {

	public void run() {
			InOut.sem.acquireUninterruptibly();
			System.out.println(InOut.x * InOut.x);
		}
	}

class Input extends Thread {

	public void run() {
			InOut.x = IO.readInt("E: ");
			InOut.sem.release();
		}
	}

public class InOut {

	static int x = 0;
	static Semaphore sem = new Semaphore(0);

	public static void main(String[] args) {
		new Output().start();
		new Input().start();
	}

}