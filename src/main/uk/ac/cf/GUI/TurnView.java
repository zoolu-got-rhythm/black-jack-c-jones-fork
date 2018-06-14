package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class TurnView extends JPanel implements Observer {

    private Game model;

    TurnView(Game model){
        this.model = model;
        super.setBackground(Color.BLACK);

        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
        super.setLayout(fl2);

//        JButton stay = new JButton("stay");
//        stay.addActionListener(controller);
//        super.add(stay);
//
//        JButton card = new JButton("card");
//        card.addActionListener(controller);
//        super.add(card);
    }

    @Override
    public void paintComponent(Graphics g){
        int width = super.getWidth();
        int height = super.getHeight();

        final String playerTurn = "turn: " + model.getCurrentPlayer().getName().toUpperCase() +
                ", best hand value: " + model.getCurrentPlayer().getHand().getBestValue();
        g.setColor(Color.GREEN);
        g.drawString(playerTurn, 5, height / 2);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        super.repaint();
    }
}
