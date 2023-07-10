package Aufgabe3;

import Aufgabe3.Captain;
import Aufgabe3.Ship;
import Aufgabe3.ShipEvent;

import java.util.Random;

public class DrunkenPirate extends Captain {
	
	private Random random = new Random();

	public DrunkenPirate(Ship ship) {
		super(ship);
	}

	@Override
	public void commandShip() {
		ShipEvent event = ShipEvent.values()[random.nextInt(ShipEvent.values().length)];
		if (event == ShipEvent.FIRE_CANNONS) {
			System.out.println("Fire cannons!");
			ship.fireCannons();
		} else if (event == ShipEvent.LOAD_CANNONS) {
			System.out.println("Load cannons!");
			ship.loadCannons();
		} else if (event == ShipEvent.SET_SAILS) {
			System.out.println("Set sails!");
			ship.setSails();
		} else if (event == ShipEvent.STRIKE_SAILS) {
			System.out.println("Strike sails!");
			ship.strikeSails();
		} else if (event == ShipEvent.TURN_LEFT) {
			System.out.println("Hard to port!");
			ship.turnLeft();
		} else if (event == ShipEvent.TURN_RIGHT) {
			System.out.println("Hard to starboard!");
			ship.turnRight();
		}
	}

}
