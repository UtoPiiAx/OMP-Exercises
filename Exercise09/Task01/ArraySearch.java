package Aufgabe1;

public class ArraySearch {

    public static void main (String [] args) {
        int [] numbers = { 2, 3, 4, 5, 6 };
        int number = 6;
        ArraySearcher search1 = new ArraySearcher(numbers, 0, numbers.length / 2, number);
        ArraySearcher search2 = new ArraySearcher(numbers, numbers.length / 2 + 1, numbers.length - 1, number);
        search1.start();
        search2.start();
        try {
            search1.join();
            search2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Found: " + (search1.isFound() || search2.isFound()));
    }
}
