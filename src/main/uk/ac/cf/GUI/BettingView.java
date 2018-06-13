package uk.ac.cf.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BettingView extends JPanel{
    BettingView(Controller controller){
        JTextField betInput = new JTextField();
        betInput.setPreferredSize(new Dimension(30, betInput.getPreferredSize().height));
        super.add(betInput);
        JButton placeBetButton = new JButton("bet");
        super.add(placeBetButton);
        placeBetButton.addActionListener(controller);

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
}
