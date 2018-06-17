package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ChipsCountView extends JPanel implements Observer {
    private Game model;
    private JTextArea chipsCount;
//    private Controller controller;

    ChipsCountView(Game model){
        this.model = model;
//        this.controller = controller;
        super.setBackground(Color.BLACK);
        this.chipsCount = new JTextArea("dsf");
        super.add(this.chipsCount);
        this.chipsCount.setBackground(Color.black);
        this.chipsCount.setForeground(Color.GREEN);


        this.chipsCount.setText("chips: " + nOfChips());
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = super.getWidth();
        int height = super.getHeight();


    }

    @Override
    public void update(Observable o, Object arg) {
        this.chipsCount.setText("chips: " + nOfChips());
        super.repaint();
    }

    private int nOfChips(){
        int numberOfChips = 0;

        try{
            numberOfChips = model.getPlayerByName("player").getChips().getCurrentBalance();
            numberOfChips = numberOfChips - model.getPlacedBets().get(model.getPlayerByName("player"));
        }catch(Exception exc){

        }
        return numberOfChips;
    }
}

