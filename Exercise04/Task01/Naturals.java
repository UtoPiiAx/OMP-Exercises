package Aufgabe1;

//1b
public class Naturals implements Sequence{
    int value;

    Naturals () {
        this.value = 1;
    }

    @Override
    public int getNext() {
        return this.value++;
    }
}
