package uk.ac.cf.GUI;

import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class NavigationView extends JPanel implements Observer{
    NavigationView(){
        super.setBackground(Color.GREEN);

        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
        super.setLayout(fl2);

        JButton stay = new JButton("stay");
        super.add(stay);

        JButton card = new JButton("card");
        super.add(card);
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

    }
}
