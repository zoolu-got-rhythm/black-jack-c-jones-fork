package uk.ac.cf;

import uk.ac.cf.blackjack.EnumToValueMapper;
import uk.ac.cf.blackjack.Game;

import java.util.*;

public class View implements Observer {

    private List<CustomListener> customListenerList = new ArrayList<CustomListener>();

    @Override
    public void update(Observable o, Object arg) {

        Game model = (Game) o;

        // view observes model for changes and polls it's state to decide what questions to ask the user
        System.out.println("turn: " + model.getCurrentPlayer().getName());
        System.out.println("hand value: " + model.getCurrentPlayer().getHand().getBestValue());


        if(model.isGameOver()) {
            System.out.println("winner: " + model.getWinner());
            System.exit(0);
        }

        if(!model.getCurrentPlayer().getName().equals("house")) {
            System.out.println("input options: 'stay', 'card'");
            Scanner s = new Scanner(System.in);
            String userInput = s.next();
            sendInputToController(userInput);
        }

    }

    public void sendInputToController(String userInput){
        for(CustomListener listener : this.customListenerList){
            listener.notifi(userInput);
        }
    }

    // if there is no bust and it comes down to highest deck value of 2 players, this method is called by controller
    public void printEndGameResult(Game model){
        System.out.println("winner: " + model.getWinner());
        System.exit(0);
    }

    public void addCustomListener(CustomListener customListener){
        this.customListenerList.add(customListener);
    }




}
