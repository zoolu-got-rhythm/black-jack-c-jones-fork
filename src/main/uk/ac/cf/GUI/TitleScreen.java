package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TitleScreen extends JPanel {
    private final String title = "tip: insert a number higher than 3 to place your bet";
    private String displayTitle = "";
    private Timer t1;

    TitleScreen(){
        // init timers
        super.setBackground(Color.BLACK);
        this.t1 = new Timer();
        this.t1.scheduleAtFixedRate(new TimerTask() {
            private int i = 0;
            @Override
            public void run() {

                if(i >= title.length()) {
                    i = 0;
                }

                i++;

                displayTitle = title.substring(0, i);
                repaint();
            }
        }, 100, 70);
    }

    @Override
    public void paintComponent(Graphics g){
        int width = super.getWidth();
        int height = super.getHeight();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GREEN);

        g.drawString(displayTitle, 5, (height / 2) + 4);
    }
}
