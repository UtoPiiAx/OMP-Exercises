package Aufgabe1;

public class EmptyValueException extends Exception{

    public EmptyValueException () {
        super ();
    }
    public EmptyValueException (String message) {
        super(message);
    }
    public EmptyValueException (Throwable cause) {
        super (cause);
    }

    public EmptyValueException (String message, Throwable cause) {
        super(message, cause);
    }

}
