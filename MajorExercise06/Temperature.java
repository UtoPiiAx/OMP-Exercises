
import java.util.Random;

public class Temperature {
	
	private int value;

	public Temperature() {
		super();
		Random random = new Random();
		value = random.nextInt(21) + 10;
		System.out.println("Temperature: " + value + "�");
	}

	public Temperature(int value) {
		super();
		this.value = value;
		System.out.println("Temperature: " + value + "�");
	}

	public int getValue() {
		return value;
	}

}
