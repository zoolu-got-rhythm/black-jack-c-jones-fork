package uk.ac.cf.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChipsView extends JPanel {

    ChipsView(){
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
            for (int i = 10; i > 0; i--) {
                g.drawImage(image, 20 + (int) Math.floor(Math.random() * 8), i * 11, 80, 40, null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
