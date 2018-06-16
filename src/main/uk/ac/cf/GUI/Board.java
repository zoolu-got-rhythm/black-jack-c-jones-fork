package uk.ac.cf.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board{

    private CardView computerCards;
    private CardView playerCards;
    private NavigationView blackjackNavigation;
    private ChipsView chipsView;
    private BettingView bettingView;
    private TurnView playerTurnView;
    private TurnView houseTurnView;

    Board(CardView computerCards, CardView playerCards, NavigationView navigationView, ChipsView chipsView,
          BettingView bettingView, TurnView playerTurnView, TurnView houseTurnView){
        this.computerCards = computerCards;
        this.playerCards = playerCards;
        this.blackjackNavigation = navigationView;
        this.chipsView = chipsView;
        this.bettingView = bettingView;
        this.playerTurnView = playerTurnView;
        this.houseTurnView = houseTurnView;
    }

    public void createAndShowGui() {


        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);

        // set app logo img
//        URL logoImgPath = new URL();
//        String logoImgPath = "/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/png/blackJackLogo.png";
//        try{
//            final BufferedImage logoImage = ImageIO.read(
//                    new File(logoImgPath));
//            frame.setIconImage(logoImage);
//        }catch(Exception imgLoadE){
//
//        }

//        URL url = ClassLoader.getSystemResource("/src/main/uk/ac/cf/GUI/png/blackJackLogo");
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Image img = kit.createImage(url);
//        frame.setIconImage(img);

//        Toolkit.getDefaultToolkit().getImage("/png/blackJackLogo.png");
//        frame.("/png/blackJackLogo.png");
//        frame.setIconImage();




        JPanel container = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {

            }

        };

        // SET CONTENT PANE
        container.setBackground(Color.black);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        fl.setHgap(0);
        fl.setVgap(0);
        container.setLayout(fl);
        container.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        frame.setContentPane(container);

        // CARDS TABLE CONTAINER

        JPanel cardsTable = new JPanel();
        cardsTable.setBorder(BorderFactory.createLineBorder(Color.GREEN));


        FlowLayout flForCardsTable = new FlowLayout(FlowLayout.LEFT);
        flForCardsTable.setHgap(0);
        flForCardsTable.setVgap(0);
        cardsTable.setLayout(flForCardsTable);
//        BoxLayout boxLayout = new BoxLayout(cardsTable, BoxLayout.Y_AXIS);
        cardsTable.setBackground(Color.ORANGE);
//        cardsTable.setBorder(new EmptyBorder(0, 0, 0, 0));
        cardsTable.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, frame.getHeight()));
//        cardsTable.setBorder(new EmptyBorder(0, 0, 0, 0));


        // turn view component
        houseTurnView.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 25));
//        houseTurnView.setBackground(Color.black);
        cardsTable.add(houseTurnView);

        // COMPUTER CARDS VIEW COMPONENT
        computerCards.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
//        computerCards.setBackground(Color.BLUE);

        cardsTable.add(computerCards);


        // player turn view component
        playerTurnView.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 25));
//        playerTurnView.setBackground(Color.black);
        cardsTable.add(playerTurnView);



        // PLAYER CARDS VIEW COMPONENT
        playerCards.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
//        playerCards.setBackground(Color.GREEN);

        cardsTable.add(playerCards);

        // NAVIGATION VIEW COMPONENT
        blackjackNavigation.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, blackjackNavigation.getPreferredSize().height));


        // NAVIGATION VIEW COMPONENT
        cardsTable.add(blackjackNavigation);
        container.add(cardsTable);

        // CHIPS CONTAINER
        JPanel chipsContainer = new JPanel();
        chipsContainer.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        BoxLayout chipsLayout = new BoxLayout(chipsContainer, BoxLayout.Y_AXIS);
        chipsContainer.setLayout(chipsLayout);

        chipsContainer.setPreferredSize(new Dimension((frame.getWidth() / 4), frame.getHeight()));

//        this.chipsView.setBackground(Color.BLACK);
        this.chipsView.setPreferredSize(new Dimension(frame.getWidth() / 4, ((frame.getHeight() / 4) * 3) + (frame.getHeight() / 4) - 20));
        this.chipsView.setMinimumSize(new Dimension(frame.getWidth() / 3, frame.getHeight() / 3));
        this.chipsView.setMaximumSize(new Dimension(frame.getWidth() / 4, frame.getHeight() / 3));
        this.chipsView.setAlignmentX(Component.LEFT_ALIGNMENT);
        chipsContainer.add(this.chipsView);



        this.bettingView.setBackground(Color.BLACK);

//        bettingView.setPreferredSize(new Dimension(frame.getWidth() / 3, frame.getHeight() / 6));
//        bettingView.setMaximumSize(new Dimension(frame.getWidth() / 4, frame.getHeight() / 6));

        this.bettingView.setAlignmentX(Component.LEFT_ALIGNMENT);


        chipsContainer.add(this.bettingView);







        container.add(chipsContainer);


//        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
//                "/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/png/2_of_clubs.png"));
        frame.pack();




        frame.invalidate(); // can look through each and repaint to make sure everything renders on first init,
        // this doesn't seem to work consistenly





    }

    void init(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
