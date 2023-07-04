package Aufgabe1;

//d
public class FibonacciDynamicParallel extends FibonacciDynamic {
    @Override
    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must not be negative!");
        }
        if (cache.size() > n) {
            return cache.get(n);
        }
        Thread thread = new Thread(new FibRunner(n));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) { }
        return cache.get(n);
    }

    private class FibRunner implements Runnable {
        private int n;

        public FibRunner (int n) {
            this.n = n;
        }

        @Override
        public void run () {
            if (cache.size() <= n) {
                Thread thread1 = new Thread(new FibRunner(n - 1));
                Thread thread2 = new Thread(new FibRunner(n - 2));
                thread1.start();
                thread2.start();
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {}
                synchronized (cache) {
                    if (cache.size() < n + 1) {
                        cache.add(0L);
                    }
                    cache.set(n, cache.get(n-1) + cache.get(n - 2));
                }
            }
        }
    }
}
