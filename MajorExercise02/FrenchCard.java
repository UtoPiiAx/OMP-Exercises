
public class FrenchCard implements ComparableCard<FrenchCard> {
	
	private Suit suit;
	private Rank rank;

	public FrenchCard(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public int compareTo(FrenchCard o) {
		// Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. 
		if (rank == Rank.JOKER && o.rank != Rank.JOKER) {
			return 1;
		} else if (rank != Rank.JOKER && o.rank == Rank.JOKER) {
			return -1;
		} else if (rank == Rank.JOKER && o.rank == Rank.JOKER) {
			return 0;
		}
		int result = suit.getValue() - o.suit.getValue();
		if (result == 0) {
			result = rank.getValue() - o.rank.getValue();
		}
		return result;
	}

	@Override
	public String toString() {
		return rank + (suit == Suit.NONE ? "" : " of " + suit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		FrenchCard other = (FrenchCard) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
