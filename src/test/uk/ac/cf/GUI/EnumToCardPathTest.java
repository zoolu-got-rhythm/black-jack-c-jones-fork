package uk.ac.cf.GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.playingcards.Rank;
import uk.ac.cf.playingcards.Suit;

import static org.junit.Assert.*;

public class EnumToCardPathTest {



    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void imgPathFromRankAndSuitEnums() throws Exception {
        // 5 of spades
        String expected = "5_of_spades.png";
        String actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.FIVE, Suit.SPADES);
        assertEquals(expected, actual);

        // 10 of hearts
        expected = "10_of_hearts.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.TEN, Suit.HEARTS);
        assertEquals(expected, actual);

        // ace of diamonds
        expected = "ace_of_diamonds.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.ACE, Suit.DIAMONDS);
        assertEquals(expected, actual);

        // 2 of diamonds
        expected = "2_of_diamonds.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.TWO, Suit.DIAMONDS);
        assertEquals(expected, actual);

        // jack of spades
        expected = "jack_of_spades.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.JACK, Suit.SPADES);
        assertEquals(expected, actual);


        // queen of diamonds
        expected = "queen_of_diamonds.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.QUEEN, Suit.DIAMONDS);
        assertEquals(expected, actual);

        // king of spades
        expected = "king_of_spades.png";
        actual = EnumToCardPath.imgPathFromRankAndSuitEnums(Rank.KING, Suit.SPADES);
        assertEquals(expected, actual);


    }

}