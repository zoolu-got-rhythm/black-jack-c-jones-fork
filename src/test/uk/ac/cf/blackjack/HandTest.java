package uk.ac.cf.blackjack;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.playingcards.PlayingCard;
import uk.ac.cf.playingcards.Rank;
import uk.ac.cf.playingcards.Suit;

import static org.junit.Assert.*;

/**
 * Created by Carl on 16/02/2016.
 */
public class HandTest {

    Hand aHand;

    @Before
    public void createHand() throws Exception {
        aHand = new Hand();
    }

    @Test
    public void testAddFive() throws Exception {
        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.FIVE));
        assertEquals(aHand.numberOfCards(),1);
        assertEquals(HandValue.FIVE,aHand.getBestValue());
    }

    @Test
    public void testAddAce() throws Exception {
        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));
        assertEquals(aHand.numberOfCards(),1);
        assertEquals(HandValue.ELEVEN,aHand.getBestValue());
    }

    @Test
    public void testAddFiveAndAceAndKing() throws Exception {
        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.FIVE));
        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));
        aHand.addCard(new PlayingCard(Suit.HEARTS, Rank.KING));

        assertEquals(aHand.numberOfCards(),3);
        assertEquals(HandValue.SIXTEEN,aHand.getBestValue());
    }

    @Test
    public void testAddTwoAces() throws Exception {
        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));
        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.ACE));

        assertEquals(aHand.numberOfCards(),2);
        assertEquals(HandValue.TWELVE,aHand.getBestValue());
    }

    @Test
    public void testBlackJackBeats21() throws Exception {

        Hand blackjackHand = new Hand();
        aHand.addCard(new PlayingCard(Suit.SPADES, Rank.SEVEN));
        aHand.addCard(new PlayingCard(Suit.HEARTS, Rank.SEVEN));
        aHand.addCard(new PlayingCard(Suit.CLUBS, Rank.SEVEN));

        blackjackHand.addCard(new PlayingCard(Suit.SPADES, Rank.ACE));
        blackjackHand.addCard(new PlayingCard(Suit.HEARTS, Rank.KING));

        assertTrue(blackjackHand.compareTo(aHand)==1);
        assertTrue(aHand.compareTo(blackjackHand)==-1);

    }



}