package Aufgabe2;

public class SquareRootFunction extends SquareFunction{
    public SquareRootFunction () {
        super ();
    }
    public SquareRootFunction (Function previous) {
        super(previous);
    }
    @Override
    public double calculate(double value) {
        value = super.calculate(value);
        return Math.sqrt(value);
    }
}
