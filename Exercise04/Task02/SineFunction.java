package Aufgabe2;

public class SineFunction extends Function{
    public SineFunction () {
        super ();
    }
    public SineFunction (Function previous) {
        super (previous);
    }

    @Override
    public double calculate(double value) {
        value = super.calculate(value);
        return Math.sin(value);
    }
}
