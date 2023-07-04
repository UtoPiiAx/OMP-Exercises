package Aufgabe2;
public class SquareFunction extends Function{
    public SquareFunction () {
        super ();
    }

    public SquareFunction(Function previous) {
        super(previous);
    }

    @Override
    public double calculate(double value) {
        value = super.calculate(value);
        return value * value;
    }
}
