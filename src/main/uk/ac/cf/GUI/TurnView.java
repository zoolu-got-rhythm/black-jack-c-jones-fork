package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class TurnView extends JPanel implements Observer {

    private Game model;
    private String playerName;

    TurnView(Game model, String playerName){
        this.model = model;
        this.playerName = playerName;
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

        Player playerSide = null;
        try{
            playerSide = model.getPlayerByName(playerName);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        final String playerTurn = playerSide.getName().toUpperCase() +
                ", best hand value: " + playerSide.getHand().getBestValue();
        g.setColor(Color.GREEN);
        g.drawString(playerTurn, 5, (height / 2) + 4);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        super.repaint();
    }
}
