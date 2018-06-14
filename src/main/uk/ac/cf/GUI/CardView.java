package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;
import uk.ac.cf.playingcards.PlayingCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class CardView extends JPanel implements Observer {

    private Game model;
    private String sideOfTable;

    CardView(Game model, String sideOfTable){
        this.sideOfTable = sideOfTable;
        this.model = model;
        JLabel text = new JLabel(sideOfTable);
        super.add(text);

    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = super.getWidth();
        int height = super.getHeight();

        System.out.println("asfdsaf");

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

//            int amountOfCardsForSideOfTable = 0;
//            try{
//               amountOfCardsForSideOfTable = model.getPlayerByName(this.sideOfTable).getHand().getCards().size();
//            }catch(Exception playerNameException){
//
//            }

//            // draw cards
//            for(int i = 0; i < amountOfCardsForSideOfTable; i ++){


                try{

                    Iterator iterator = null;
                    iterator = model.getPlayerByName(this.sideOfTable).getHand().getCards().iterator();

                    int numberOfCards = model.getPlayerByName(this.sideOfTable).getHand().numberOfCards();


                    int cardWidth, cardHeight = 0;

                    if(numberOfCards > 4){
                        cardWidth = width / 6;
                    }else if(numberOfCards > 3){
                        cardWidth = width / 5;
                    }else{
                        cardWidth = width / 4;
                    }
                    cardHeight = cardWidth + (cardWidth / 3);

                    int i = 0;

                    System.out.println(this.model);

                    int cardMargin = 20;

                    while (iterator.hasNext()){
//                      int i = model.getPlayerByName(this.sideOfTable).getHand().getCards().size();

                        PlayingCard currentCard = (PlayingCard) iterator.next();
                        System.out.println(currentCard);
                                String cardName =
                                        EnumToCardPath.imgPathFromRankAndSuitEnums(currentCard.rank, currentCard.suit);
                        String imgPath = "/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/png/";
                        imgPath += cardName;

                        final BufferedImage cardImage = ImageIO.read(
                                new File(imgPath));


                        if(i != 0) {
                            cardMargin += cardWidth + 5;
                        }


                        g.setColor(Color.GRAY);
                        g.fillRoundRect( cardMargin - 2, 30 - 2, cardWidth, cardHeight, 5, 5);

                        g.setColor(Color.WHITE);
                        g.fillRoundRect(cardMargin, 30, cardWidth, cardHeight, 5, 5);

                        g.drawImage(cardImage, cardMargin, 30, cardWidth, cardHeight, null);
                        i++;
                    }

                }catch(Exception exc){
                    System.out.println(exc.getMessage());
                }





    }

    @Override
    public void update(Observable o, Object arg) {
//        this.model = (Game) o;
        super.repaint();
    }
}
