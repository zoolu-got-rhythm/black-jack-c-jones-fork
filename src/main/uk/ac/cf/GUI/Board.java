package uk.ac.cf.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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

//        p.setSize(50,50);
//        p.setBackground(Color.green);
//        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
//        container.setSize(600, 600);
//        p.setOpaque(false);

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.black);
        frame.setContentPane(container);



        Insets insets = container.getInsets();

//        Container


        JPanel p2 = new JPanel();
        p2.setBackground(Color.ORANGE);
        p2.setBounds(insets.left + 50, insets.top + 50, 100, 100);

        container.add(p2);


        JPanel p3 = new JPanel();
        p3.setBackground(Color.RED);
        p3.setBounds(insets.left + 150, insets.top + 150, 200, 40);
        p3.add(new Button("stay"));
        p3.add(new Button("card"));

        container.add(p3);


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
