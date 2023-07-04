package Aufgabe2;

public class FunctionTest {

	public static void main(String[] args) {
		Function chain = new SquareFunction(new SquareRootFunction(new SineFunction()));
		// Function chain = new SquareRootFunction(new SquareRootFunction(new SquareFunction()));
		while (true) {
			double x = IO.readDouble("Value: ");
			System.out.println(chain.calculate(x));
		}
	}
}
