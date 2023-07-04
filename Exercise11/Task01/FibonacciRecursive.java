package Aufgabe1;


//a
public class FibonacciRecursive extends Fibonacci{

    @Override
    public long calculate (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must not be negative!");
        }
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return calculate(n - 1) + calculate(n - 2);
    }
}
