package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class BettingView extends JPanel implements Observer{
    private Game model;
    private JButton placeBetButton;
    BettingView(Game model, Controller controller){
        this.model = model;
        JTextField betInput = new JTextField();
        betInput.setPreferredSize(new Dimension(30, betInput.getPreferredSize().height));
        super.add(betInput);
        placeBetButton = new JButton("bet");
        super.add(placeBetButton);
//        placeBetButton.addActionListener(controller);

        placeBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int valueOfUserBet = 0;
//                System.out.println(Integer.valueOf("a"));
                try{
                    int valueOfUserBet = Integer.valueOf(betInput.getText());
                    System.out.println(valueOfUserBet);
                    controller.setBetPlaced(valueOfUserBet);
                    controller.bet();

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(placeBetButton, "Eggs are not supposed to be green.");
                }

//                if(valueOfUserBet != 0){
//                }
//                placeBetButton.invalidate();

            }

        });

//        placeBetButton.addActionListener(controller);

//        placeBetButton.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                JOptionPane.showMessageDialog(placeBetButton,
////                        "You shouldn't use a message dialog "
////                                + "(like this)\n"
////                                + "for a question, OK?",
////                        "Inane question",
////                        JOptionPane.YES_NO_OPTION);
//                System.out.println(e.getActionCommand());
//            }
//        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if(this.model.getPlacedBets().isEmpty()){
            System.out.println("turn button green");
            placeBetButton.setForeground(Color.GREEN);
        }else{
            placeBetButton.setForeground(Color.RED);
        }
        super.invalidate();
    }
}
