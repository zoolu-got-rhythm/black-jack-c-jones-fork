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
    Controller(Game model, CardView cardView){
        this.model = model;
        this.cardView = cardView;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        switch(event.getActionCommand().toLowerCase()){
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
            this.placeBet();
        }
    }

    public void placeBet(){

//            boolean enoughChips = false;
//            while(enoughChips != true) {
//                Scanner s = new Scanner(System.in);
//                int userBuyInAmount = Integer.parseInt(s.next());
//                try {
//                    if (userBuyInAmount > model.getPlayerByName("player").getChips().getCurrentBalance()) {
//                        System.out.println("you don't have that many chips");
//                    }else{
//                        enoughChips = true;

                        try {
                            model.placeChipsToEnterGame(model.getPlayerByName("player"), 3);
                            model.placeChipsToEnterGame(model.getPlayerByName("house"), 3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        model.dealCards(2, true);
                        // check for blackjack
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
    }

    // check if game is over
}
