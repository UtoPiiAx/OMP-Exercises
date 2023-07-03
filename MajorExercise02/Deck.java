
public interface Deck<T extends Card> {
	
	void add(T card) throws InvalidCardException;

}
