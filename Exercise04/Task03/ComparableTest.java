interface Comparable {
	/**
	 * Vergleicht das aufrufende Objekt mit dem als Parameter uebergebenen
	 * Objekt; liefert: -1 falls das aufrufende Objekt kleiner ist als das
	 * Parameterobjekt, 0 falls beide Objekte gleich gross sind, 1 falls das
	 * aufrufende Objekt groesser ist als das Parameterobjekt.
	 */
	public int compareTo(Comparable obj);
}

class Utils {

	/**
	 * Liefert das "kleinste" (auf der Basis der Comparable-Implementierung!)
	 * Element des Parameter-Arrays.
	 * Achtung: Man kann davon ausgehen, dass das Parameter-Array
	 * mindestens ein Element enthaelt (also weder null noch leer ist)
	 */
	public static Comparable getMinimum(Comparable[] elements) {
		Comparable smallest = elements[0];
		for (int i = 1; i < elements.length; i++) {
			if (smallest.compareTo(elements[i]) == 0) {
				smallest = elements [i];
			}
		}
		return smallest;
	}

	/**
	 * Liefert das "groesste" (auf Basis der Comparable-Implementierung!)
	 * Element des Paramter-Arrays.
	 * Achtung: Man kann davon ausgehen, dass das Parameter-Array
	 * mindestens ein Element enthaelt (also weder null noch leer ist)
	 */
	public static Comparable groesstesElement(Comparable[] elements) {
		Comparable largest = elements[0];
		for (int i = 1; i < elements.length; i++) {
			if (largest.compareTo(elements[i]) == -1) {
				largest = elements[i];
			}
		}
		return largest;
	}
}

class Integer {
	protected int value;

	public Integer(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

class ComparableInteger extends Integer implements Comparable {
	public ComparableInteger(int value) {
		super(value);
	}

	@Override
	public int compareTo(Comparable obj) {
		if (this.value < ((ComparableInteger) obj).value)
			return -1;
		if (this.value == ((ComparableInteger)obj).value)
			return 0;
		return 1;
	}
  
}

public class ComparableTest {
	public static void main(String[] args) {
		ComparableInteger[] array = {new ComparableInteger(4), new ComparableInteger(3), new ComparableInteger(2)};
		ComparableInteger smallest = (ComparableInteger) Utils.getMinimum(array);
		System.out.println(smallest.getValue());
	}
}
