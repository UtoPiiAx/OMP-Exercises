package de.uni_oldenburg.inf.omp.rulebook.labyrinth.Aufgabe3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chamber {
	
	private String name = "";
	private boolean entrance = false;
	private boolean treasure = false;
	private List<Chamber> adjacent = new ArrayList<>(4);
	private Random random = new Random();
	
	public Chamber(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isEntrance() {
		return entrance;
	}

	public void setEntrance(boolean entrance) {
		this.entrance = entrance;
	}

	public boolean isTreasure() {
		return treasure;
	}

	public void setTreasure(boolean treasure) {
		this.treasure = treasure;
	}

	public List<Chamber> getAdjacent() {
		return adjacent;
	}
	
	public boolean hasAdjacent() {
		return !adjacent.isEmpty();
	}
	
	public Chamber getRandomAdjacent() {
		if (adjacent.isEmpty()) {
			return null;
		}
		return adjacent.get(random.nextInt(adjacent.size()));
	}
	
	public void addAdjacent(Chamber chamber) {
		adjacent.add(chamber);
		chamber.adjacent.add(this);
	}

}
