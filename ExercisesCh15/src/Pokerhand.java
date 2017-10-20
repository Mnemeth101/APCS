/* Question 15.5.2 Successfully created Pokerhand which extends Deck.
 * 
 */
public class Pokerhand extends Deck{
	public static int handsize = 5;
	
	public Pokerhand() {
		super(handsize);
	}
	
	public Pokerhand(int size) {
		super(size);
	}
	/* Question 15.5.5
	 * hasFlush checks to see whether or not the Pokerhand has a flush. It does so by 
	 * getting the suit of the first card, and if any of the other cards does not share
	 * the same suit, it returns false. Otherwise, it returns true.
	 */
	public boolean hasFlush() {
		int firstsuit = cards[0].suit;
		for (Card c : cards) {
			if (c.suit != firstsuit) {
				return false;
			}
		}
		return true;
	}
	/* Question 15.5.6
	 * hasThreeKind checks to see whether or not the hand has 3 cards of the same suit.
	 * It does so by creating a counting list which is modified with every card and counts
	 * the number of each rank.
	 */
	public boolean hasThreeKind() {
		int[] rankcount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : cards) {
			rankcount[c.suit]++;
		}
		for (int n : rankcount) {
			if (n == 3) {return true;}
		}
		
		return false;
	}
	/*
	 * Checks whether the hand has a straight.
	 */
	public boolean hasStraight() {
		sort();
		boolean numorder = true;
		for (int i = 0; i < 4; i++) {
			if ((cards[i].rank == cards[i+1].rank-1) == false) {
				numorder = false;
				break;
			}
		}
		return numorder;
	}
	/*
	 * Checks whether the hand has a straight flush.
	 */
	public boolean hasStraightFlush() {
		return hasStraight()&&hasFlush();
	}
	/*
	 * Checks whether the hand has 4 of a kind.
	 */
	public boolean hasFourKind() {
		int[] suitscount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : cards) {
			suitscount[c.suit]++;
		}
		for (int n : suitscount) {
			if (n == 4) {return true;}
		}
		
		return false;
	}
	/*
	 * Checks whether the hand has a full house.
	 */
	public boolean hasFullHouse() {
		int[] suitscount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : cards) {
			suitscount[c.rank]++;
		}
		boolean has3 = false;
		boolean has2 = false;
		for (int n : suitscount) {
			if (n == 3) {has3 = true;}
			if (n == 2) {has2 = true;}
		}
		return has3&&has2;
	}
	/*
	 * Checks whether the hand has 2 pairs.
	 */
	public boolean hasTwoPair() {
		int[] suitscount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : cards) {
			suitscount[c.rank]++;
		}
		int has2 = 0;
		for (int n : suitscount) {
			if (n == 2) {has2++;}
		}
		return (has2 == 2);
	}
	/*
	 * Checks whether the hand has 1 pair.
	 */
	public boolean hasPair() {
		int[] suitscount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (Card c : cards) {
			suitscount[c.rank]++;
		}
		int has2 = 0;
		for (int n : suitscount) {
			if (n == 2) {has2++;}
		}
		return (has2 == 1);
	}
}
