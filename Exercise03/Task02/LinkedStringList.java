public class LinkedStringList {

	private LinkedStringListElement start;
	
	public int size() {
		int result = 0;
		LinkedStringListElement tmp = start;
		while (tmp != null) {
			tmp = tmp.getNext();
			result++;
		}
		return result;
	}
	
	public String get(int index) {
		if (start == null) { // list is empty
			return null;
		}
		LinkedStringListElement current = start;
		int pos = 0; // counter for finding the right position
		while (pos < index) {
			if (current.getNext() == null) {
				// list does not have enough elements
				return null;
			}
			current = current.getNext();
			pos++;
		}
		return current.getValue();
	}
	
	public void add(String value) {
		LinkedStringListElement elem = new LinkedStringListElement();
		elem.setValue(value);
		if (start == null) { // list is empty
			start = elem;
		} else {
			LinkedStringListElement tmp = start;
			while (tmp.getNext() != null) { // find last element
				tmp = tmp.getNext();
			}
			tmp.setNext(elem);
		}
	}

	public String remove(int index) {
		if (start == null) { // list is empty
			return null;
		}
		if (index == 0) { // remove from the beginning of non-empty list
			String result = start.getValue();
			start = start.getNext();
			return result;
		}
		// remove from anywhere in a non-empty list
		LinkedStringListElement current = start;
		int pos = 0; // counter for finding the right position
		while (pos < index - 1) {
			if (current.getNext() == null) {
				// list does not have enough elements
				return null;
			}
			current = current.getNext();
			pos++;
		}
		if (current.getNext() == null) { // not enough elements
			return null;
		}
		String result = current.getNext().getValue();
		current.setNext(current.getNext().getNext());
		return result;
	}
	
}
class LinkedStringListElement {
	
	private LinkedStringListElement next;
	private String value;
	
	public LinkedStringListElement getNext() {
		return next;
	}
	public void setNext(LinkedStringListElement next) {
		this.next = next;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
