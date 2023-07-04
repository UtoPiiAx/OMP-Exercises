package Aufgabe2;

import java.util.stream.Stream;
public class StreamTest {
    public static void main (String[] args) {
        //a
        Stream<Integer> naturals = Stream.iterate(1, (n) -> n + 1);
        //b
        Stream<Integer> integers = Stream.iterate(0, (n) -> {
            if (n <= 0) {
                return Math.abs(n) + 1;
            } else {
                return n * -1;
            }
        });
        System.out.println("Ergebnis für naturals: " + filterAndSum(naturals));
        System.out.println("Ergebnis für integers: " + filterAndSum(integers));
    }
        //c Hilfsmethode private!!!!!
        private static Integer filterAndSum(Stream<Integer> stream) {
            return stream.filter(n -> n % 2 == 0).limit (10).reduce((n,m) -> n + m).orElse(0);
        }

}
