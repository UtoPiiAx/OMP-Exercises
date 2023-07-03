public class CanastaDeck extends FrenchDeck {

	@Override
	public void add(FrenchCard card) throws InvalidSuitException, DuplicateCardException {
		if (card.getSuit() == Suit.NONE && card.getRank() != Rank.JOKER) {
			throw new InvalidSuitException(card.toString());
		}
		if (cards.contains(card) && card.getRank() != Rank.JOKER) {
			throw new DuplicateCardException(card.toString());
		}
		if (countJokers() >= 6 && card.getRank() == Rank.JOKER) {
			throw new DuplicateCardException(card.toString());
		}
		cards.add(card);
	}

	private int countJokers() {
		int result = 0;
		for (FrenchCard card : cards) {
			if (card.getRank() == Rank.JOKER) {
				result++;
			}
		}
		return result;
	}

}
