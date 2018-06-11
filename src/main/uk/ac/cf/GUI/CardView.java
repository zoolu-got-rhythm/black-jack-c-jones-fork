package uk.ac.cf.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class CardView extends JPanel implements Observer {

    CardView(String sideOfTable){
        JLabel text = new JLabel(sideOfTable);
        super.add(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = super.getWidth();
        int height = super.getHeight();

        try {
            final BufferedImage image = ImageIO.read(
                    new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/2_of_clubs.png"));

            g.fillRect(0, 0, width, height);

            // draw table texture
            for(int j = 0; j < 54; j++){
                for(int k = 0; k < 50; k++){
                    Color c;
                    if(j % 2 == 0){
                        c = k % 2 == 0 ? new Color(102, 255, 102) : new Color(0, 204, 102);
                    }else{
                        c = k % 2 == 0 ? new Color(0, 204, 102) : new Color(102, 255, 102);
                    }
                    g.setColor(c);
                    g.fillRect(j * (width / 50), k * (height / 50), width / 50, height / 50);
                }
            }

            // draw cards
            for(int i = 0; i < 4; i ++){
                g.setColor(Color.GRAY);
                g.fillRoundRect(i * (width / 5) + 20 - 2, 30 + (i * 10) - 2, width / 4 - 10, (width / 4) + 20, 5, 5);

                g.setColor(Color.WHITE);
                g.fillRoundRect(i * (width / 5) + 20, 30 + (i * 10), width / 4 - 10, (width / 4) + 20, 5, 5);

                g.drawImage(image, i * (width / 5) + 20, 30 + (i * 10), width / 4 - 10, (width / 4) + 20, null);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
