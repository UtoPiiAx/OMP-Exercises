class Util {

	// liefert die kleinste Zahl des uebergebenen Arrays
	public static int minimum(int[] values) throws NullValueException, EmptyValueException {
		if (values == null) {
			throw new NullValueException("Value cant be null!");
		}
		if (values.length == 0) {
			throw new EmptyValueException("Value cant be empty!");
		}
		int min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}

	// konvertiert den uebergebenen String in einen int-Wert
	public static int toInt(String str) throws NullValueException, EmptyValueException {
		if (str == null) {
			throw new NullValueException("Value cant be null!");
		}
		if(str.isEmpty()) {
			throw new EmptyValueException("Value cant be empty!");
		}
		int result = 0, factor = 1;
		char ch = str.charAt(0);
		switch (ch) {
		case '-':
			factor = -1;
			break;
		case '+':
			factor = 1;
			break;
		default:
			result = ch - '0';
		}
		for (int i = 1; i < str.length(); i++) {
			ch = str.charAt(i);
			int ziffer = ch - '0';
			result = result * 10 + ziffer;
		}
		return factor * result;
	}

	// liefert die Potenz von zahl mit exp,
	// also zahl "hoch" exp (number to the power of exp)
	public static long power(long number, int exp) throws NegativeValueException {
		if (exp < 0) {
			throw new NegativeValueException("Please use a positive number!");
		}
		if (exp == 0) {
			return 1L;
		}
		return number * Util.power(number, exp - 1);
	}
}

public class UtilTest {
	// Testprogramm
	public static void main(String[] args) {
		String eingabe = IO.readString("Zahl: ");
		try {
			int zahl = Util.toInt(eingabe);
			System.out.println(zahl + " hoch " + zahl + " = "
					+ Util.power(zahl, zahl));
		}
		catch (NullValueException f){
			f.printStackTrace();
		}
		catch (EmptyValueException f){
			f.printStackTrace();
		}
		catch (NegativeValueException f){
			f.printStackTrace();
		}
		try {
			System.out.println(Util.minimum(new int[] { 1, 6, 4, 7, -3, 2 }));
			System.out.println(Util.minimum(new int[0]));
			System.out.println(Util.minimum(null));
		} catch (NullValueException e) {
			e.printStackTrace();
		} catch (EmptyValueException e) {
			e.printStackTrace();
		}
	}
}
