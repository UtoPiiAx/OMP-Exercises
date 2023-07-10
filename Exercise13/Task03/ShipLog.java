package Aufgabe3;

public class ShipLog implements Observer {

	@Override
	public void update(Observable who, ShipEvent what) {
		Ship ship = (Ship) who;
		if (what == ShipEvent.FIRE_CANNONS) {
			System.out.println("Cannons fired.");
		} else if (what == ShipEvent.LOAD_CANNONS) {
			System.out.println("Cannons loaded.");
		} else if (what == ShipEvent.SET_SAILS) {
			System.out.println("Sails set.");
		} else if (what == ShipEvent.STRIKE_SAILS) {
			System.out.println("Sails struck.");
		} else if (what == ShipEvent.TURN_LEFT) {
			System.out.println("Turned to port. New heading " + ship.getHeading() + " degrees.");
		} else if (what == ShipEvent.TURN_RIGHT) {
			System.out.println("Turned to starboard. New heading " + ship.getHeading() + " degrees.");
		} else if (what == ShipEvent.NO_EVENT) {
			System.out.println("No action taken.");
		}
	}

}
