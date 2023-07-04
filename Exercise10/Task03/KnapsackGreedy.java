package Aufgabe3;

import java.util.Collection;

public class KnapsackGreedy extends Knapsack {

	public KnapsackGreedy(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}

	@Override
	public Selection pack() {
		candidates.sort((i1, i2) -> Integer.compare(i2.getValue(), i1.getValue()));
		return pack (new Selection());
	}

	private Selection pack(Selection selection) {
		// Abbruchbedingung: Das Gewicht der Auswahl übersteigt die Kapazität
		if (selection.getWeight() > capacity) {
			return selection;
		}

		//Durchläuft alle Kandidaten in der Liste
		for (Item cand : candidates) {

			//erstellt eine temporäre Auswahl für den Maximum-Vergleich
			Selection tmp = pack(new Selection(selection, cand));

			// Wenn die aktuelle Auswahl besser als die alte Auswahl
			// => gib die temporäre Auswahl zurück
			if (tmp.getWeight() <= capacity && tmp.getValue() > selection.getValue()) {
				System.out.println("Das aktuelle Maximum: " + tmp);
				return pack(tmp);
			}
		}

		//Gibt die aktuelle Auswahl zurück
		return selection;
	}

}
