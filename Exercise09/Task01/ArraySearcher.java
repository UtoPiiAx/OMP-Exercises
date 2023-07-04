package Aufgabe1;

public class ArraySearcher extends Thread {

    private int [] numbers;
    private int from;
    private int to;
    private int value;
    private boolean found;

    ArraySearcher(int [] numbers, int from, int to, int value) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public void run () {
        for (int i = from; i <= to; i++) {
            if (numbers[i] == value) {
                System.out.println(getName() + ": found");
                found = true;
                return;
            }
        }
        System.out.println(getName() + ": not found");
    }

    public boolean isFound () { return found; }

}
