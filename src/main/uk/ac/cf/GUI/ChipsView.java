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
//    private Controller controller;

    ChipsView(Game model){
        this.model = model;
//        this.controller = controller;
        JLabel chipsLabel = new JLabel("chips");
        super.add(chipsLabel);
//        super.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = super.getWidth();
        int height = super.getHeight();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        try {
            final BufferedImage image = ImageIO.read(new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/gold-coin-hi.png"));

            for(int j = 0; j < 16; j++){
                for(int k = 0; k < 3; k++){
                    Color c;
                    if(j % 2 == 0){
                        c = k % 2 == 0 ? Color.BLACK : Color.WHITE;
                    }else{
                        c = k % 2 == 0 ? Color.WHITE : Color.BLACK;
                    }
                    g.setColor(c);
                    g.fillRect(j * (width / 16), k * (width / 16), width / 16, width / 16);
                }
            }



            // draw table texture
            int numberOfChips = 0;
            try{
                numberOfChips = model.getPlayerByName("player").getChips().getCurrentBalance();
                numberOfChips = numberOfChips - model.getPlacedBets().get(model.getPlayerByName("player"));
//                numberOfChips = numberOfChips
                System.out.println("chips");
                System.out.println(numberOfChips);
            }catch(Exception exc){

            }

            int offSet = (height - (numberOfChips * 11)) - 40;
            for (int i = numberOfChips; i > 0; i--) {
                g.drawImage(image, 20 + (int) Math.floor(Math.random() * 8), offSet + (i * 11), 80, 40, null);
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
