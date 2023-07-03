
public class SkatDeck extends FrenchDeck {

	@Override
	public void add(FrenchCard card) throws InvalidRankException, InvalidSuitException, DuplicateCardException {
		if ((card.getRank().getValue() >= 2 && card.getRank().getValue() <= 6) || card.getRank().getValue() == 14) {
			throw new InvalidRankException(card.toString());
		}
		if (card.getSuit() == Suit.NONE) {
			throw new InvalidSuitException(card.toString());
		}
		if (cards.contains(card)) {
			throw new DuplicateCardException(card.toString());
		}
		cards.add(card);
	}

}
