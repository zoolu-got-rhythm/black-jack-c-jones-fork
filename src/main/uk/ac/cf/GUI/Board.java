package uk.ac.cf.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

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



        container.setBorder(new EmptyBorder(0, 0, 0, 0));

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

        JPanel p2 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(p2, BoxLayout.Y_AXIS);
        p2.setBackground(Color.ORANGE);
//        p2.setBorder(new EmptyBorder(0, 0, 0, 0));
        p2.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, frame.getHeight()));
//        p2.setSize(p2D.width, 40);
//        p2.setBounds(insets.left + 50, insets.top + 50, 100, 100);
        Dimension p2D = p2.getPreferredSize();

        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
        p4.setBackground(Color.BLUE);

        JLabel textComputer = new JLabel("computer");
        p4.add(textComputer);

        p2.add(p4);

        JPanel p5 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                int width = getWidth();
                int height = getHeight();

                for(int i = 0; i < 4; i ++){
//                    if(i % 2 == 0){
//                        g.setColor(Color.MAGENTA);
//                    }else{
//                        g.setColor(Color.BLACK);
//                    }
                    g.setColor(Color.WHITE);
//                    g.fillRect(i * (getWidth() / 10), 0, width / 10, height);
                    g.fillRoundRect(i * (getWidth() / 5) + 20, 30, width / 5 - 20, (width / 5) + 20, 5, 5);
                }

            }
        };

        p5.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 200));
        p5.setBackground(Color.CYAN);
        JLabel text = new JLabel("player");
        p5.add(text);
        p2.add(p5);


        JPanel p6 = new JPanel();
        p6.setPreferredSize(new Dimension((frame.getWidth() / 4) * 3, 50));
        p6.setBackground(Color.CYAN);

        FlowLayout fl2 = new FlowLayout(FlowLayout.CENTER);
        p6.setLayout(fl2);

        JButton stay = new JButton("stay");
        p6.add(stay);

        JButton card = new JButton("card");
        p6.add(card);


        p2.add(p6);


        container.add(p2);






        JPanel p3 = new JPanel();
        p3.setBackground(Color.GREEN);
//        p3.setBorder(new EmptyBorder(0, 0, 0, 0));

        p3.setPreferredSize(new Dimension((frame.getWidth() / 4), frame.getHeight()));

        container.add(p3);

//        JPanel p3 = new JPanel();
//        p3.setBackground(Color.RED);
////        p3.setBounds(insets.left + 150, insets.top + 150, 200, 40);
//        p3.add(new Button("stay"));
//        p3.add(new Button("card"));

//        container.add(p3);


//        JButton b = new JButton("dsaf");
//        p2.add(b);
//
//        JPanel p3 = new JPanel();
//        p3.setBackground(Color.RED);
//        p3.setSize(100, 100);




//        frame.getContentPane().add(p2);
//        frame.getContentPane().add(p3);
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
