package Aufgabe3;

public class DuplicateIdException extends InvalidIdException {
    public DuplicateIdException(int id) {
        super(id);
    }
}
