package uk.ac.cf.blackjack;

/**
 * Created by Carl on 16/02/2016.
 */
public class Player {

    private String name;
    private Hand hand;
    private boolean stillInTheGame;

    public Player (String name){
        this.name = name;
        hand=new Hand();
        stillInTheGame =true;
    }

    public Hand getHand(){
        return hand;
    }

    public void stick(){

        stillInTheGame =false;
    }



    public boolean getStillInTheGame(){
        return stillInTheGame;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}