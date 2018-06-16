package uk.ac.cf.GUI;

import javafx.beans.Observable;
import uk.ac.cf.blackjack.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class NavigationView extends JPanel implements Observer{

    private JButton stay;
    private JButton card;
    private Game model;

    NavigationView(Controller controller, Game model){
        super.setBackground(Color.GREEN);

        this.model = model;
        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
        super.setLayout(fl2);

        this.stay = new JButton("stay");
        this.stay.addActionListener(controller);
        super.add(this.stay);

        this.card = new JButton("card");
        this.card.addActionListener(controller);
        super.add(this.card);
    }

    @Override
    public void paintComponent(Graphics g){
        int width = super.getWidth();
        int height = super.getHeight();

        for(int j = 0; j * (width / 25) < width; j++){
            for(int k = 0; k * (height / 5) < height; k++){
                Color c;
                if(j % 2 == 0){
                    c = k % 2 == 0 ? new Color(20, 25, 102) : new Color(40, 80, 102);
                }else{
                    c = k % 2 == 0 ? new Color(40, 80, 102) : new Color(20, 25, 102);
                }
                g.setColor(c);
                g.fillRect(j * (width / 25), k * (height / 5), width / 25, height / 5);
            }
        }
    }

    @Override
    public void update(java.util.Observable o, Object arg) {


        System.out.println("hav view");
        System.out.println(model);

        if(this.model.getCurrentPlayer().getName().equals("player")){
            System.out.println("turn button green");
//            this.stay.setBackground(Color.GREEN); java 8 doesn't work bg color on mac
//            this.card.setBackground(Color.GREEN);
            this.stay.setForeground(Color.GREEN);
            this.card.setForeground(Color.GREEN);
        }else{
            this.stay.setForeground(Color.RED);
            this.card.setForeground(Color.RED);
        }
        super.invalidate();
        super.repaint();

    }

}
