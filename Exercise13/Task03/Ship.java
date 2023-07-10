package Aufgabe3;

public class Ship extends Observable {
	
	private boolean sails = false;
	private boolean cannons = false;
	private int heading = 0;
	
	public boolean isSails() {
		return sails;
	}
	
	public void setSails() {
		if (!sails) {
			sails = true;
			setChanged();
			notifyObservers(ShipEvent.SET_SAILS);
		}
	}
	
	public void strikeSails() {
		if (sails) {
			sails = false;
			setChanged();
			notifyObservers(ShipEvent.STRIKE_SAILS);
		}
	}
	
	public boolean isCannonsLoaded() {
		return cannons;
	}
	
	public void loadCannons() {
		if (!cannons) {
			cannons = true;
			setChanged();
			notifyObservers(ShipEvent.LOAD_CANNONS);
		}
	}
	
	public void fireCannons() {
		if (cannons) {
			cannons = false;
			setChanged();
			notifyObservers(ShipEvent.FIRE_CANNONS);
		}
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void turnLeft() {
		heading -= 90;
		if (heading < 0) {
			heading += 360;
		}
		setChanged();
		notifyObservers(ShipEvent.TURN_LEFT);
	}

	public void turnRight() {
		heading += 90;
		if (heading >= 360) {
			heading -= 360;
		}
		setChanged();
		notifyObservers(ShipEvent.TURN_RIGHT);
	}

}
