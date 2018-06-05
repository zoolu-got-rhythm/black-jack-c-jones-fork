package uk.ac.cf.blackjack;

import uk.ac.cf.playingcards.Deck;
import uk.ac.cf.playingcards.PlayingCard;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// note: could use aspect oriented programming/aop here to trigger observer.update after every method call
public class Game extends Observable{

    private ArrayList<Player> players;
    private ArrayList<Player> playersInGame;
    private ArrayList<Player> playersInDeal;
    private Player currentPlayer;
    private Player winner;
    private boolean isGameOver;
    private Deck theDeck;



    public Game (String playerNameA, String playerNameB, String... otherPlayerNames){
        super();
        players = new ArrayList<Player>();
        players.add(new Player(playerNameA));
        players.add(new Player(playerNameB));
        if (otherPlayerNames.length>0){
            for (String other : otherPlayerNames){
                players.add(new Player(other));
            }
        }
        playersInGame = new ArrayList<Player>();
        playersInGame.addAll(players);
        playersInDeal = new ArrayList<Player>();
        playersInDeal.addAll(players);
        isGameOver=false;
        theDeck=new Deck();
        currentPlayer = players.get(0);
    }

    public void dealCards(int numberOfCardsInInitialShuffle, boolean shuffleFirst){

        PlayingCard aCard;

        if (shuffleFirst){
            theDeck.shuffle(100);
        }
        for (int cards=1;cards<=numberOfCardsInInitialShuffle;cards++){
            for (Player aPlayer : playersInGame) {
                aCard = theDeck.deal();
                aPlayer.getHand().addCard(aCard);
            }
        }

        this.notifyView();
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Player getPlayerByName(String playerName) throws Exception { // change to no player found custom exception
        for(Player player : this.players){
            if(player.getName().equals(playerName))
                return player;
        }
        throw new Exception("no player with that name found");
    }

    public void nextPlayer() throws NoPlayersInGameException{

        int currentPlayerIndex=playersInDeal.indexOf(currentPlayer);
        int numberOfPlayersInGame=playersInDeal.size();

        if (numberOfPlayersInGame==0){
            throw new NoPlayersInGameException();
        }

        if (currentPlayerIndex==numberOfPlayersInGame-1){
            currentPlayer = playersInDeal.get(0);
        }
        else{
            currentPlayer = playersInDeal.get(currentPlayerIndex+1);
        }
    }

    public void stick(Player aPlayer){
        playersInDeal.remove(aPlayer);
        aPlayer.stick();
    }


    public void twist(Player aPlayer){
        PlayingCard nextCard = theDeck.deal();
        aPlayer.getHand().addCard(nextCard);
        if (aPlayer.getHand().getBestValue()==HandValue.BUST){
            playersInGame.remove(aPlayer);
            playersInDeal.remove(aPlayer);
        }
        this.notifyView();
    }

    public boolean isGameOver(){
        return ((playersInGame.size()==1) || (playersInDeal.isEmpty()));
    }

    public int getNumberOfPlayersInGame() {
        return playersInGame.size();
    }

    public int getNumberOfPlayersInDeal() {
        return playersInDeal.size();
    }

    public Player getWinner(){
        Player theWinner;

        //if everyone else has gone bust, the winner is the last player standing

        if (playersInGame.size()==1){
            theWinner=playersInGame.get(0);
        }

        //Otherwise, it is the player with the best hand-value

        theWinner = playersInGame.get(0);
        for (Player aPlayer : playersInGame){
            if (aPlayer.getHand().getBestValue().ordinal() > theWinner.getHand().getBestValue().ordinal()){
                theWinner = aPlayer;
            }
        }
        this.winner=theWinner;
        return theWinner;

    }

    private void notifyView(){
        super.setChanged();
        super.notifyObservers(this);
        super.clearChanged();
    }


    @Override
    public void addObserver(Observer o){ // can denote this method i think and just directly/externally call super method
            super.addObserver(o);
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", winner=" + winner +
                '}';
    }
}