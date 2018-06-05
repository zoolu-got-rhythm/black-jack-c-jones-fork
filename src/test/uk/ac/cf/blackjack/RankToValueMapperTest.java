package uk.ac.cf.blackjack;

import org.junit.Test;
import uk.ac.cf.playingcards.Rank;

import static org.junit.Assert.*;

/**
 * Created by Carl on 19/02/2016.
 */
public class RankToValueMapperTest {

    @Test
    public void testGetBlackjackValueOfACE() throws Exception {
        assertEquals(11,EnumToValueMapper.getBlackjackValue(Rank.ACE));

    }

    @Test
    public void testGetBlackjackValueOfQUEEN() throws Exception {
        assertEquals(10,EnumToValueMapper.getBlackjackValue(Rank.QUEEN));

    }

    @Test
    public void testGetBlackjackValueOfFIVE() throws Exception {
        assertEquals(5,EnumToValueMapper.getBlackjackValue(Rank.FIVE));

    }
}