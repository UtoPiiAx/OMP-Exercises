package Aufgabe3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Selection {
	
	private Map<Item, Integer> items = new HashMap<>();
	private int value;
	private int weight;
	
	public Selection() {
		super();
	}
	
	public Selection(Selection previous) {
		super();
		items.putAll(previous.items);
		value = previous.value;
		weight = previous.weight;
	}
	
	public Selection(Selection previous, Item item) {
		super();
		items.putAll(previous.items);
		value = previous.value;
		weight = previous.weight;
		add(item);
	}
	
	private void add(Item item) {
		items.put(item, getCount(item) + 1);
		value += item.getValue();
		weight += item.getWeight();
	}
	
	public int getCount(Item item) {
		Integer result = items.get(item);
		if (result == null) {
			result = 0;
		}
		return result;
	}
	
	public Collection<Item> getItems() {
		return items.keySet();
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Value: ");
		b.append(value);
		b.append(", weight: ");
		b.append(weight);
		b.append(", items: ");
		List<Item> list = new ArrayList<>(items.keySet());
		list.sort((i1, i2) -> i1.getName().compareTo(i2.getName()));
		for (int i = 0; i < list.size(); i++) {
			b.append(items.get(list.get(i)));
			b.append("x ");
			b.append(list.get(i).getName());
			if (i < list.size() - 1) {
				b.append(", ");
			}
		}
		return b.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selection other = (Selection) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
	
}
