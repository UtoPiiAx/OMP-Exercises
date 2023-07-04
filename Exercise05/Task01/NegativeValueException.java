package Aufgabe1;

public class NegativeValueException extends Exception{
    public NegativeValueException () {
        super ();
    }
    public NegativeValueException (String message) {
        super(message);
    }
    public NegativeValueException (Throwable cause) {
        super (cause);
    }

    public NegativeValueException (String message, Throwable cause) {
        super(message, cause);
    }
}
