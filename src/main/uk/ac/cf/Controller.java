package uk.ac.cf;

import uk.ac.cf.blackjack.*;
import uk.ac.cf.playingcards.PlayingCard;

import java.util.Scanner;

public class Controller {
    private Game model;
    private View view;

    Controller(Game model, View view){
        this.model = model;
        this.view = view;
        this.view.addCustomListener(new CustomListener() {

            //TODO:
            // hand to value mapper: done
            // ace edge case: done
            // draw
            // add chips

            @Override
            public void notifi(String userInput) {
                // switch statement: user action

//                if(userInput.toLowerCase().equals("placeBets")){
//
//
//                }

                if(userInput.toLowerCase().equals("card")){
                    // draw new card in model
                    model.twist(model.getCurrentPlayer());
                }

                // if player sticks(stay), then it's now the house's(computers turn)
                if(userInput.toLowerCase().equals("stay")){
                    model.stick(model.getCurrentPlayer());
                    try {
                        model.nextPlayer();
                    } catch (NoPlayersInGameException e) {
                        e.printStackTrace();
                    }

                    int computerValue = EnumToValueMapper.getHandIntValueFromHandValueEnum(
                            model.getCurrentPlayer().getHand().getBestValue());

                    int playerValue = 0;

                    try {
                        playerValue = EnumToValueMapper.getHandIntValueFromHandValueEnum(
                                model.getPlayerByName("player").getHand().getBestValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    while (computerValue < playerValue
                            && computerValue != 0 && computerValue != 1 && computerValue != 23){
                        model.twist(model.getCurrentPlayer());
                        computerValue = EnumToValueMapper.getHandIntValueFromHandValueEnum(
                                model.getCurrentPlayer().getHand().getBestValue());
                    }

                    // change this here abit.
                    view.printEndGameResult(model);
                }
            }
        });


        // init app
//        model.notifyObservers();
    }

    public void initGame(){
        try {
            System.out.println("you have: " +
                    model.getPlayerByName("player").getChips().getCurrentBalance() + " chips");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("input chip amount number, minimum buy in is 3..");

        boolean enoughChips = false;
        while(enoughChips != true) {
            Scanner s = new Scanner(System.in);
            int userBuyInAmount = Integer.parseInt(s.next());
            try {
                if (userBuyInAmount > model.getPlayerByName("player").getChips().getCurrentBalance()) {
                    System.out.println("you don't have that many chips");
                }else{
                    enoughChips = true;

                    try {
                        model.placeChipsToEnterGame(model.getPlayerByName("player"), userBuyInAmount);
                        model.placeChipsToEnterGame(model.getPlayerByName("house"), 3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.dealCards(2, true);
                    // check for blackjack
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // redudant
    private int valueOfCardsForPlayer(Player player){
        int valueForComputerPlayer = 0;
        for(PlayingCard card : player.getHand().getCards()){
//                            System.out.println(card);
//                            System.out.println(RankToValueMapper.getBlackjackValue(card.rank));
            valueForComputerPlayer += EnumToValueMapper.getBlackjackValue(card.rank);

        };
        return valueForComputerPlayer;
    }


}
