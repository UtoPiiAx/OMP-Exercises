package Aufgabe1;

import java.util.ArrayList;
import java.util.*;

//c
public class FibonacciDynamic extends Fibonacci{

    protected List<Long> cache;

    public FibonacciDynamic () {
        cache = new ArrayList<>();
        cache.add(0L);
        cache.add(1L);
    }

    @Override
    public long calculate (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must not be negative!");
        }
        if (cache.size() > n) {
            return cache.get(n);
        }
        long result = calculate(n - 1) + calculate(n - 2);
        cache.add(result);
        return result;
    }
}
