package Aufgabe2;

public abstract class Function {
    protected Function previous;

    public Function () {
        this.previous = null;
    }

    public Function (Function previous) {
        this.previous = previous;
    }

    public double calculate (double value) {
        if (this.previous != null) {
            value = this.previous.calculate(value);
        }
        return value;
    }
}
