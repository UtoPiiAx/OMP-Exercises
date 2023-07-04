package Aufgabe3;

import java.util.Collection;

public class KnapsackRecursive extends Knapsack {

	public KnapsackRecursive(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}

	@Override
	public Selection pack() {
		return pack(new Selection());
	}

	private Selection pack(Selection selection) {
		// Abbruchbedingung
		if (selection.getWeight() > capacity) {
			return selection;
		}

		// erstellt eine bessere Auswahl für die Rückgabe
		Selection max = new Selection(selection);

		// Durchläuft alle Kandidaten in der Liste
		for (Item cand : candidates) {
			//erstellt eine temporäre Auswahl für den Maximum-Vergleich
			Selection tmp = pack(new Selection(selection, cand));

			// Wenn die aktuelle Auswahl besser als die alte Auswahl
			// => ersetze die alte Auswahl
			if (tmp.getWeight() <= capacity && tmp.getValue() > max.getValue()) {
				max = tmp;
			}
		}

		// Abbruchbedingung: Die aktuelle Auswahl ist besser als die alte Auswahl
		// => ersetze die alte Auswahl und gib die neue Auswahl zurück
		if (max.getWeight() <= capacity && max.getValue() > selection.getValue()) {
			System.out.println("Das aktuelle Maximum: " + max);
			return pack(max);
		}

		//Gibt das aktuelle Maximum der Auswahl zurück
		return max;
	}

}
