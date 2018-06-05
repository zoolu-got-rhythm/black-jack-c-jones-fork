package uk.ac.cf.blackjack;

import uk.ac.cf.playingcards.Rank;

/**
 * Created by Carl on 19/02/2016.
 */
public class EnumToValueMapper {

    public static int getBlackjackValue(Rank aRank) {
        switch (aRank) {
            case ACE:
                return 11;
            case TEN:case JACK:case QUEEN: case KING: return 10;
            default:
                return aRank.ordinal() + 1;
        }
    }

    public static int getHandIntValueFromHandValueEnum(HandValue handValue) {
            return handValue.ordinal();
    }
}
