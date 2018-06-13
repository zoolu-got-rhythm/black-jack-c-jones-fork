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

public class ChipsView extends JPanel implements Observer {
    private Game model;

    ChipsView(Game model){
        this.model = model;
        JLabel chipsLabel = new JLabel("chips");
        super.add(chipsLabel);
        super.setBackground(Color.DARK_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = super.getWidth();
        int height = super.getHeight();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        try {
            final BufferedImage image = ImageIO.read(new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/gold-coin-hi.png"));

            for(int j = 0; j * (width / 25) < width; j++){
                for(int k = 0; k * (height / 45) < height; k++){
                    Color c;
                    if(j % 2 == 0){
                        c = k % 2 == 0 ? new Color(20, 25, 102) : new Color(40, 80, 102);
                    }else{
                        c = k % 2 == 0 ? new Color(40, 80, 102) : new Color(20, 25, 102);
                    }
                    g.setColor(c);
                    g.fillRect(j * (width / 25), k * (height / 45), width / 25, height / 45);
                }
            }

            // draw table texture
            int numberOfChips = 0;
            try{
                numberOfChips = model.getPlayerByName("player").getChips().getCurrentBalance();
                System.out.println("chips");
                System.out.println(numberOfChips);
            }catch(Exception exc){

            }

            for (int i = numberOfChips; i > 0; i--) {
                g.drawImage(image, 20 + (int) Math.floor(Math.random() * 8), i * 11, 80, 40, null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        super.repaint();
    }
}
