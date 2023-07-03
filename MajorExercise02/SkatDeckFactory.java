
public class SkatDeckFactory extends DeckFactory<FrenchCard> {
	
	@Override
	public Deck<FrenchCard> createDeck() {
		SkatDeck result = new SkatDeck();
		for (Suit suit : Suit.values()) {
			if (suit != Suit.NONE) {
				for (Rank rank : Rank.values()) {
					if (rank.getValue() == 1 || (rank.getValue() >= 7 && rank.getValue() <= 13)) {
						try {
							result.add(new FrenchCard(suit, rank));
						} catch (InvalidRankException | InvalidSuitException | DuplicateCardException e) {
							throw new InvalidDeckConfigurationException(e);
						}
					}
				}
			}
		}
		return result;
	}

}
