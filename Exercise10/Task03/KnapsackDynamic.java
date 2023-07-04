package Aufgabe3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KnapsackDynamic extends Knapsack {

	private Map<Selection, Selection> cache = new HashMap<>();
	public KnapsackDynamic(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}

	@Override
	public Selection pack() {
		cache.clear();
		return new Selection();
	}

	private Selection pack(Selection selection) {
		// Abbruchbedingung: Das Gewicht der Auswahl übersteigt die Kapazität
		if (selection.getWeight() > capacity) {
			return selection;
		}
		// Durchläuft alle Kandidaten der Liste
		Selection max = new Selection(selection);
		for (Item cand: candidates) {
			// erstellt eine temporäre Auswahl für den Maximum-Vergleich
			// hier mit Zwischenspeicherung in der Hashmap
			Selection tmp = getCached(new Selection(selection, cand));
			// Wenn die aktuelle Auswahl besser als die alte Auswahl
			// => ersetze die alte Auswahl
			if (tmp.getWeight() <= capacity && tmp.getValue() > max.getValue()) {
				max = tmp;
			}
		}
		// Gibt das aktuelle Maximum der Auswahl zurück
		System.out.println("Das aktuelle Maximum: " + max);
		return max;
	}

	private Selection getCached (Selection selection) {
		Selection result = cache.get(selection);
		if (result == null) {
			result = pack(selection);
			cache.put(selection, result);
		}
		return result;
	}
}
