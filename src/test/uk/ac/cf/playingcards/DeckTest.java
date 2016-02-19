package uk.ac.cf.playingcards;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.playingcards.Deck;
import uk.ac.cf.playingcards.PlayingCard;
import uk.ac.cf.playingcards.Rank;
import uk.ac.cf.playingcards.Suit;

import static org.junit.Assert.*;

/**
 * Created by Carl on 16/02/2016.
 */
public class DeckTest {

    private Deck aDeck;

    @Before
    public void setupDeck(){
        aDeck=new Deck();
    }

    @org.junit.Test
    public void testSize() throws Exception {
        assertEquals(52, aDeck.size());
    }

    @org.junit.Test
    public void testGetCardFrontIsAceofClubs() throws Exception {
        assertEquals(new PlayingCard(Suit.CLUBS, Rank.ACE), aDeck.getCardAtIndex(0));
    }

    @org.junit.Test
    public void testGetCardBackIsKingOfSpades() throws Exception {
        assertEquals(new PlayingCard(Suit.SPADES, Rank.KING), aDeck.getCardAtIndex(51));
    }

    @Test
    public void testFirstCardDealtFromSortedPackIsAceOfClubs(){

        PlayingCard topCard = aDeck.deal();

        assertTrue((topCard.equals(new PlayingCard(Suit.CLUBS, Rank.ACE)) && (aDeck.size()==51)));
    }

    @Test
    public void testShuffleKeepsAllCards(){

        aDeck.shuffle(100);

        assertEquals(52,aDeck.size());

    }


}