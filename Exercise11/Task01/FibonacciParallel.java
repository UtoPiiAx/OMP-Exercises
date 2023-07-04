package Aufgabe1;

//b
public class FibonacciParallel extends Fibonacci{

    @Override
    public long calculate (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must not be negative!");
        }
        FibRunner thread = new FibRunner (n);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) { }
        return thread.getResult();
    }

    private class FibRunner extends Thread {
        private int n;
        private long result;
        public FibRunner(int n) {
            this.n = n;
        }
        public long getResult() {
            return result;
        }

        @Override
        public void run () {
            if (n == 0) {
                result = 0L;
            } else if (n == 1) {
                result = 1L;
            } else {
                FibRunner thread1 = new FibRunner(n - 1);
                FibRunner thread2 = new FibRunner(n - 2);
                thread1.start();
                thread2.start();
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) { }
                result = thread1.getResult() + thread2.getResult();
            }
        }
    }
}
