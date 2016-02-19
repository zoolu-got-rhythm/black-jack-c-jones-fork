package uk.ac.cf.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Carl on 16/02/2016.
 */
public class GameTest {


    @Test
    public void testVictoriaGoesBust() throws Exception{
        Game aGame=new Game("Victoria","David");


        aGame.dealCards(2,false);

        //the game is not over

        assertFalse(aGame.isGameOver());


        //two players
        //Victoria has ACE and THREE so has value of 14
        //David has TWO and FOUR so has value of 6

        //Victoria is the current player and her hand is worth 14.

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.FOURTEEN, aGame.getCurrentPlayer().getHand().getBestValue());



        Player playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She twists.  She gets a FIVE so her value is 19.

        aGame.twist(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.NINETEEN, aGame.getCurrentPlayer().getHand().getBestValue());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //David is the current player.  He twists.  He gets a SIX so his value is 12

        aGame.twist(playerA);

        assertEquals("David", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.TWELVE, aGame.getCurrentPlayer().getHand().getBestValue());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She twists.  She gets an seven so her value is 26, but she has an Ace so value is sixteen

        aGame.twist(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.SIXTEEN, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should still be two players in the game

        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //the game is not over

        assertFalse(aGame.isGameOver());


        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //David is the current player.  He twists.  He gets a EIGHT so his value is 20

        aGame.twist(playerA);

        assertEquals("David", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.TWENTY, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should still be two players in the game

        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //the game is not over

        assertFalse(aGame.isGameOver());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She sticks.  She should stay on 16 and be out of the deal

        aGame.stick(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.SIXTEEN, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should still be two players in the game
        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //There should only be one player in the deal
        assertEquals(1,aGame.getNumberOfPlayersInDeal());

        //the game is  not over because there is still one player to deal to

        assertFalse(aGame.isGameOver());

        aGame.nextPlayer();

        //David sticks as well

        playerA=aGame.getCurrentPlayer();
        aGame.stick(playerA);


        //There should still be two players in the game
        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //There should be no players in the deal
        assertEquals(0,aGame.getNumberOfPlayersInDeal());

        //the game is  not over because there is still one player to deal to

        assertTrue(aGame.isGameOver());



        //the winner should be David by 20 to 16

        assertEquals("David", aGame.getWinner().getName());

        System.out.println(aGame);



    }


    @Test
    public void testBothPlayersStick() throws Exception{
        Game aGame=new Game("Victoria","David");


        aGame.dealCards(2,false);

        //the game is not over

        assertFalse(aGame.isGameOver());


        //two players
        //Victoria has ACE and THREE so has value of 14
        //David has TWO and FOUR so has value of 6

        //Victoria is the current player and her hand is worth 14.

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.FOURTEEN, aGame.getCurrentPlayer().getHand().getBestValue());



        Player playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She twists.  She gets a FIVE so her value is 19.

        aGame.twist(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.NINETEEN, aGame.getCurrentPlayer().getHand().getBestValue());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //David is the current player.  He twists.  He gets a SIX so his value is 12

        aGame.twist(playerA);

        assertEquals("David", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.TWELVE, aGame.getCurrentPlayer().getHand().getBestValue());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She twists.  She gets an seven so her value is 26, but she has an Ace so value is sixteen

        aGame.twist(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.SIXTEEN, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should still be two players in the game

        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //the game is not over

        assertFalse(aGame.isGameOver());


        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //David is the current player.  He twists.  He gets a EIGHT so his value is 20

        aGame.twist(playerA);

        assertEquals("David", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.TWENTY, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should still be two players in the game

        assertEquals(2,aGame.getNumberOfPlayersInGame());

        //the game is not over

        assertFalse(aGame.isGameOver());

        aGame.nextPlayer();

        playerA = aGame.getCurrentPlayer();

        //Victoria is the current player.  She twists.  She gets a nine so her value is 35, the Ace can't save her. She is bust.

        aGame.twist(playerA);

        assertEquals("Victoria", aGame.getCurrentPlayer().getName());
        assertEquals(HandValue.BUST, aGame.getCurrentPlayer().getHand().getBestValue());

        //There should only be one player in the game
        assertEquals(1,aGame.getNumberOfPlayersInGame());

        //There should only be one player in the deal
        assertEquals(1,aGame.getNumberOfPlayersInDeal());

        //the game is  over because there is only one player to deal to

        assertTrue(aGame.isGameOver());

        //the winner should be David

        assertEquals("David", aGame.getWinner().getName());

        System.out.println(aGame);

    }





}