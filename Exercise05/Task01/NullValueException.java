package Aufgabe1;

public class NullValueException extends Exception{
    public NullValueException () {
        super ();
    }

    public NullValueException (String message) {
        super(message);
    }

    public NullValueException (Throwable cause) {
        super (cause);
    }

    public NullValueException (String message, Throwable cause) {
        super(message, cause);
    }
}
