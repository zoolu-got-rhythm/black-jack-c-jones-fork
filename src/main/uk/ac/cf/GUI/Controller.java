package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.EnumToValueMapper;
import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.NoPlayersInGameException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Controller implements ActionListener{
    private Game model;
    private CardView cardView;
    private int betPlaced;
    Controller(Game model, CardView cardView){
        this.model = model;
        this.cardView = cardView;
        this.betPlaced = 0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        switch(event.getActionCommand().toLowerCase()){
            case "bet" :
//                if(model.getPlacedBets().isEmpty())
//                System.out.println("bet placed");
//                this.placeBet(this.getBetPlaced());
//                this.setBetPlaced(0);
                break;
            case "card" :
                // draw new card in model
                System.out.println("execute");
                model.twist(model.getCurrentPlayer());
                break;
            case "stay" :
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                while (computerValue < playerValue
                        && computerValue != 0 && computerValue != 1 && computerValue != 23){
                    model.twist(model.getCurrentPlayer());
                    computerValue = EnumToValueMapper.getHandIntValueFromHandValueEnum(
                            model.getCurrentPlayer().getHand().getBestValue());
                }
                break;


            default:
                break;
        }

        if(model.isGameOver()){
//            JOptionPane.showMessageDialog(this.cardView,
//                        "You shouldn't use a message dialog "
//                                + "(like this)\n"
//                                + "for a question, OK?",
//                        "Inane question",
//                        JOptionPane.YES_NO_OPTION);
            this.model.getWinner();
            this.model.resetGame();

            // if player chips below 3
            // prompt user to re-start the game
//            this.placeBet();
        }
    }

    public void placeBet(int betAmount){
        int playerChipsAmount = 0;
        try{
            playerChipsAmount = model.getPlayerByName("player").getChips().getCurrentBalance();
        }catch(Exception e1){

        }


        if (playerChipsAmount >= 3 && betAmount <= playerChipsAmount) {
            if(betAmount >= 3) {
                if(model.getPlacedBets().isEmpty()) {
                    try {
                        model.placeChipsToEnterGame(model.getPlayerByName("player"), betAmount);
                        model.placeChipsToEnterGame(model.getPlayerByName("house"), 3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.dealCards(2, true);
                }else{
                    // current game in play
                }
            }else{
                // minimum buy in is 3
            }
            // check for blackjack
        } else{
//            JOptionPane.showMessageDialog(this.cardView,
//            this.getBetPlaced(),
//            "not enough chips",
//            JOptionPane.YES_NO_OPTION);

            // you don't have enough chips
        }
    }

    public void bet(){
        System.out.println("bet placed");
        this.placeBet(this.getBetPlaced());
        this.setBetPlaced(0);
    }

    public int getBetPlaced() {
        return betPlaced;
    }

    public void setBetPlaced(int betPlaced) {
        this.betPlaced = betPlaced;
    }

    // check if game is over
}
