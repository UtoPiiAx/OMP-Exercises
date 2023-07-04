package Aufgabe3;

public class InvalidIdException extends Exception {

    protected int id;

    public InvalidIdException(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
