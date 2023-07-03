
public enum Suit {
	
	NONE(0), TILES(1), HEARTS(2), PIKES(3), CLOVERS(4);

	private int value;
	
	private Suit(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
