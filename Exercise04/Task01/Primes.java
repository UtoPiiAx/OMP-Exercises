package Aufgabe1;

public class Primes extends Filter {
    int value;

    public Primes () {
        super(new Naturals()); //Nimm die natuerlichen Zahlen
        this.sequence.getNext(); //entferne die 1
        this.value = this.sequence.getNext(); //erste Zahl des Restes
    }

    @Override
    public int getNext() {
        int result = this.value;
        //entferne die value und alle Vielfachen
        this.sequence = new ZapMultiples(this.value, this.sequence);
        this.value = this.sequence.getNext(); //erste Zahl des Restes
        return result;
    }
}
