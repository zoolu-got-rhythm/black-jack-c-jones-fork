package uk.ac.cf.blackjack;

import uk.ac.cf.playingcards.PlayingCard;
import uk.ac.cf.playingcards.Rank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Carl on 16/02/2016.
 */
public class Hand {

    Set<PlayingCard> cards;
    int total;
    int aces;


    public Hand() {
        cards = new HashSet<PlayingCard>();
        total = 0;
        aces = 0;

    }

    public void addCard(PlayingCard aCard) {
        cards.add(aCard);
        total += RankToValueMapper.getBlackjackValue(aCard.rank);
        if (aCard.rank == Rank.ACE) {
            aces++;
        }

    }

    public int numberOfCards() {

        return cards.size();
    }

    public HandValue getBestValue() {

        int over = total - 21;
        int numberOfAcesToSave = Math.floorDiv(over, 10) + 1;


        if (total > 21 && aces < numberOfAcesToSave) {
            return HandValue.BUST;
        }
        if (total > 21) {
            int valueIndex = total - ((numberOfAcesToSave * 10) - 1);
            HandValue value = HandValue.values()[valueIndex];
            return value;
        }
        if (total == 21 && cards.size() == 2) {
            return HandValue.BLACKJACK;
        }
        return HandValue.values()[total + 1];
    }

    public int compareTo(Hand aHand) {
        return (this.getBestValue().compareTo(aHand.getBestValue()));

    }

    @Override
    public String toString() {
        return cards + " = " + getBestValue();
    }
}
