import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Performance {

	public static final int ORCHESTRA_SIZE = 3;
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		SheetMusic music = new SheetMusic();
		//SheetMusic music = new WaitNotifyMusic();
		//SheetMusic music = new LockMusic();
		Composer composer = new Composer(music);
		List<Musician> musicians = new ArrayList<>();
		for (int i = 0; i < ORCHESTRA_SIZE; i++) {
			musicians.add(new Musician(music));
		}
		List<Thread> threads = new ArrayList<>();
		//add new thread for composer: compose every 100-200ms
		threads.add(new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				composer.compose();
				try {
					Thread.sleep(100 + RANDOM.nextInt(101));
				} catch (InterruptedException e) {
					break;
				}
			}
		}));
		
		//add new thread for each musician: play every 50-100ms
		for (Musician musician : musicians) {
			threads.add(new Thread(() -> {
				while (!Thread.currentThread().isInterrupted()) {
					musician.play();
					try {
						Thread.sleep(50 + RANDOM.nextInt(51));
					} catch (InterruptedException e) {
						break;
					}
				}
			}));
		}

		//start all threads
		for (Thread thread : threads) {
			thread.start();
		}

		//wait 2s
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { }

		//stop all threads
		for (Thread thread : threads) {
			thread.interrupt();
		}

		/*
		 * Alternativloesung von Florian Dyck:
		class DoWaitRepeatThread extends Thread {
			public DoWaitRepeatThread(Runnable action, long minWait, long maxWait) {
				super(() -> {
					while (!Thread.currentThread().isInterrupted()) {
						action.run();
						try {
							Thread.sleep(minWait + RANDOM.nextInt((int) (maxWait - minWait + 1)));
						} catch (InterruptedException e) {
							break;
						}
					}
				});
			}
		}
		threads.add(new DoWaitRepeatThread(composer::compose, 100, 200));
		musicians.forEach(m -> threads.add(new DoWaitRepeatThread(m::play, 50, 100)));
		threads.forEach(Thread::start);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { }
		threads.forEach(Thread::interrupt);
		*/
	}

}
