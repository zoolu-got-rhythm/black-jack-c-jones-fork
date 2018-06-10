package uk.ac.cf.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board{

    public static void createAndShowGui() {


//        frame.setBackground(Color.green);
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);


        JPanel container = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {

            }

        };



//        container.setBorder(new EmptyBorder(0, 0, 0, 0));

//        p.setSize(50,50);
//        p.setBackground(Color.green);
//        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
//        container.setSize(600, 600);
//        p.setOpaque(false);

//        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.black);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        fl.setHgap(0);
        fl.setVgap(0);
        container.setLayout(fl);
        container.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        frame.setContentPane(container);

        // get rid of padding

        Insets insets = container.getInsets();

//        Container

        JPanel cardsTable = new JPanel();

        FlowLayout flForCardsTable = new FlowLayout(FlowLayout.LEFT);
        flForCardsTable.setHgap(0);
        flForCardsTable.setVgap(0);
        cardsTable.setLayout(flForCardsTable);
//        BoxLayout boxLayout = new BoxLayout(cardsTable, BoxLayout.Y_AXIS);
        cardsTable.setBackground(Color.ORANGE);
//        cardsTable.setBorder(new EmptyBorder(0, 0, 0, 0));
        cardsTable.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, frame.getHeight()));
//        cardsTable.setBorder(new EmptyBorder(0, 0, 0, 0));

//        cardsTable.setSize(cardsTableD.width, 40);
//        cardsTable.setBounds(insets.left + 50, insets.top + 50, 100, 100);
        Dimension cardsTableD = cardsTable.getPreferredSize();

        JPanel computerCards = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                int width = getWidth();
                int height = getHeight();

//                C c = new Color(102, 255, 102);
                g.fillRect(0, 0, width, height);

                // draw table texture
                for(int j = 0; j < 50; j++){
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
                    g.fillRoundRect(i * (width / 5) + 20 - 2, 30 - 2, width / 5 - 10, (width / 5) + 20, 5, 5);

                    g.setColor(Color.WHITE);
                    g.fillRoundRect(i * (width / 5) + 20, 30, width / 5 - 10, (width / 5) + 20, 5, 5);
                }

            }
        };


        computerCards.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
        computerCards.setBackground(Color.BLUE);

        JLabel textComputer = new JLabel("computer");
        computerCards.add(textComputer);

        cardsTable.add(computerCards);

        JPanel playerCards = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                int width = getWidth();
                int height = getHeight();
//
//                int width = (frame.getWidth() / 4) * 3;
//                int height = frame.getHeight();

//                C c = new Color(102, 255, 102);

//                BufferedImage image;
                try {
                    final BufferedImage image = ImageIO.read(new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/2_of_clubs.png"));

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
                        g.fillRoundRect(i * (width / 5) + 20 - 2, 30 - 2, width / 5 - 10, (width / 5) + 20, 5, 5);

                        g.setColor(Color.WHITE);
                        g.fillRoundRect(i * (width / 5) + 20, 30, width / 5 - 10, (width / 5) + 20, 5, 5);

                        g.drawImage(image, i * (width / 5) + 20, 30, width / 5 - 10, (width / 5) + 20, null);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        };

        playerCards.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
//        playerCards.setBackground(Color.GREEN);
        JLabel text = new JLabel("player");
        playerCards.add(text);
        cardsTable.add(playerCards);


        JPanel blackjackNavigation = new JPanel();
        blackjackNavigation.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 50));
        blackjackNavigation.setBackground(Color.CYAN);

        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
        blackjackNavigation.setLayout(fl2);

        JButton stay = new JButton("stay");
        blackjackNavigation.add(stay);

        JButton card = new JButton("card");
        blackjackNavigation.add(card);


        cardsTable.add(blackjackNavigation);


        container.add(cardsTable);






        JPanel chipsContainer = new JPanel();
        chipsContainer.setBorder(BorderFactory.createLineBorder(Color.red));



        BoxLayout chipsLayout = new BoxLayout(chipsContainer, BoxLayout.Y_AXIS);
        chipsContainer.setLayout(chipsLayout);

        JLabel chipsLabel = new JLabel("chips");
        chipsContainer.add(chipsLabel);


        chipsContainer.setBackground(Color.GREEN);
//        chipsContainer.setBorder(new EmptyBorder(0, 0, 0, 0));

        chipsContainer.setPreferredSize(new Dimension((frame.getWidth() / 4), frame.getHeight()));

//        frame.
//        frame.

        JPanel chipsStack = new JPanel () {
            @Override
            protected void paintComponent(Graphics g) {
                int width = getWidth();
                int height = getHeight();
//
//                int width = (frame.getWidth() / 4) * 3;
//                int height = frame.getHeight();

//                C c = new Color(102, 255, 102);

//                BufferedImage image;
                try {
                    final BufferedImage image = ImageIO.read(new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/gold-coin-hi.png"));

                    // draw table texture
                        for (int i = 30; i > 0; i--) {
                            g.drawImage(image, 20 + (int) Math.floor(Math.random() * 8), i * 11, 80, 40, null);
                        }


                    // draw cards

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };


        chipsStack.setBackground(Color.WHITE);

//        System.out.println(frame.getJMenuBar().getHeight());

        chipsStack.setPreferredSize(new Dimension(frame.getWidth() / 4, (frame.getHeight() / 4) * 3));
//        chipsStack.setMinimumSize(new Dimension(frame.getWidth() / 3, frame.getHeight() / 3));
        chipsStack.setMaximumSize(new Dimension(frame.getWidth() / 4, frame.getHeight() / 3));
        chipsStack.setAlignmentX(Component.LEFT_ALIGNMENT);
        chipsContainer.add(chipsStack);


        JPanel placeBet = new JPanel(){

        };


        placeBet.setBackground(Color.BLACK);

//        chipsStack.setPreferredSize(new Dimension(frame.getWidth() / 3, frame.getHeight() / 2));
//        chipsStack.setMaximumSize(new Dimension(frame.getWidth() / 4, frame.getHeight() / 2));

        placeBet.setAlignmentX(Component.LEFT_ALIGNMENT);


        chipsContainer.add(placeBet);







        container.add(chipsContainer);

//        JPanel chipsContainer = new JPanel();
//        chipsContainer.setBackground(Color.RED);
////        chipsContainer.setBounds(insets.left + 150, insets.top + 150, 200, 40);
//        chipsContainer.add(new Button("stay"));
//        chipsContainer.add(new Button("card"));

//        container.add(chipsContainer);


//        JButton b = new JButton("dsaf");
//        cardsTable.add(b);
//
//        JPanel chipsContainer = new JPanel();
//        chipsContainer.setBackground(Color.RED);
//        chipsContainer.setSize(100, 100);




//        frame.getContentPane().add(p2);
//        frame.getContentPane().add(chipsContainer);
    }

//    public Dimension getPreferredSize() {
//        return new Dimension(500, 500);
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
