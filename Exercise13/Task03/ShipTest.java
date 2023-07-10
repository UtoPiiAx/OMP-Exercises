package Aufgabe3;

public class ShipTest {

	private static final int MAX_COMMANDS = 50;

	public static void main(String[] args) {
		Ship blackPearl = new Ship();
		blackPearl.addObserver(new ShipLog());
		Captain sparrow = new DrunkenPirate(blackPearl);
		for (int i = 0; i < MAX_COMMANDS; i++) {
			sparrow.commandShip();
		}
	}

}
