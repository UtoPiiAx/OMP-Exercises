package Aufgabe1;

public class mainTest {
    public static void main (String [] args) {
        FibonacciRecursive re = new FibonacciRecursive();
        FibonacciParallel pa = new FibonacciParallel();
        FibonacciDynamic dy = new FibonacciDynamic();
        FibonacciDynamicParallel dp = new FibonacciDynamicParallel();
        System.out.println("result recursive: " + re.calculate(16));
        System.out.println("result parallel: " + pa.calculate(16));
        System.out.println("result dynamic: " + dy.calculate(10));
        System.out.println("result dynamicparallel: " + dp.calculate(10));
    }
}
