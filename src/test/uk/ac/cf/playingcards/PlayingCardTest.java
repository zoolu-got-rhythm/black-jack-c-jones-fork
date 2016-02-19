package uk.ac.cf.playingcards;

import org.junit.Test;
import uk.ac.cf.playingcards.PlayingCard;
import uk.ac.cf.playingcards.Rank;
import uk.ac.cf.playingcards.Suit;

import static org.junit.Assert.*;

/**
 * Created by Carl on 16/02/2016.
 */
public class PlayingCardTest {

    @Test
    public void testEqualCards() throws Exception {
        PlayingCard aCard = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard bCard = new PlayingCard(Suit.CLUBS,Rank.ACE);

        assertTrue(aCard.equals(bCard));

    }

    @Test
    public void testPositionOfAceOfClubsIs0() throws Exception {
        PlayingCard aCard = new PlayingCard(Suit.CLUBS,Rank.ACE);
        assertEquals(0,aCard.position());
    }

    @Test
    public void testPositionOfAceOfDiamondsIs13() throws Exception {
        PlayingCard aCard = new PlayingCard(Suit.DIAMONDS,Rank.ACE);
        assertEquals(13,aCard.position());
    }

    @Test
    public void testPositionOfAceOfHeartsIs26() throws Exception {
        PlayingCard aCard = new PlayingCard(Suit.HEARTS,Rank.ACE);
        assertEquals(26,aCard.position());
    }

    @Test
    public void testPositionOfKingOfSpadesIs51() throws Exception {
        PlayingCard aCard = new PlayingCard(Suit.SPADES,Rank.KING);
        assertEquals(51,aCard.position());
    }




}