package Aufgabe3;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	
	private List<Observer> observers = new ArrayList<>();
	private boolean changed = false;
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	protected void setChanged() {
		changed = true;
	}
	
	protected void clearChanged() {
		changed = false;
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	public void notifyObservers(ShipEvent what) {
		if (isChanged()) {
			for (Observer o : observers) {
				o.update(this, what);
			}
			clearChanged();
		}
	}

}
