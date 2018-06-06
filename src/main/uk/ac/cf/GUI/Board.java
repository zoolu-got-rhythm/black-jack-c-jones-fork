package uk.ac.cf.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Board extends JPanel {

    private static final int DIM_WIDTH = 140;
    private static final int DIM_HEIGHT = 220;
    private static final int SQ_SIZE = 80;

    boolean black = true;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
        String split  = "ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";

        normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        split  += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";

        normal += "0123456789";
        split  += "0ƖᄅƐㄣϛ9ㄥ86";

//        char[] c = {'\u2764'};
//        RTextLine text = new RTextLine();
        String upsidedownSymbol = "";
        upsidedownSymbol += split.charAt(normal.indexOf('A'));



        g.setColor(Color.GRAY);

        g.fillRoundRect(2, 2, 80, 120, 10, 10);

        g.setColor(Color.WHITE);
//                    g.fillRect(50, 50, SQ_SIZE, SQ_SIZE);
        g.fillRoundRect(3, 3, 80, 120, 10, 10);


        g.setColor(Color.RED);
        g.drawString("7", 10, 25);
        g.drawString("\u2764", 10, 38);

//        System.out.println(upsidedownSymbol);
//        g.drawString(upsidedownSymbol, 60, 20);
//                    g.drawChars(c, 50, 50, 50, 50);

        Font f = new Font("Dialog", Font.ROMAN_BASELINE, 45);
        g.setFont(f);

        g.drawString("\u2764", 25, 78);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/Users/slime/Documents/blackJackCarlJonesFork/src/main/uk/ac/cf/GUI/Ace.jpg"));
        } catch (IOException e) {
        }

        g.drawImage(img, 120, 80, 100, 130, null);
        g.drawImage(img, 120 + 100, 80, 100, 130, null);
        g.drawImage(img, 120 + (100 * 2), 80, 100, 130, null);

        g.drawImage(img, 120, 200, 100, 130, null);
        g.drawImage(img, 120 + 100, 200, 100, 130, null);
        g.drawImage(img, 120 + (100 * 2), 200, 100, 130, null);

    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();

        frame.setBackground(Color.green);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

        Button stay = new Button("stay");
        Button card = new Button("card");
        card.setSize(50, 50);
        stay.setSize(50, 50);
        JPanel p = new JPanel();
        p.setSize(100, 100);
        p.setBackground(Color.RED);
        p.add(stay);
        p.add(card);
        frame.add(p);
        Board b = new Board();
        b.setSize(400, 400);
        b.setBackground(Color.ORANGE);
        frame.add(b);

//        frame.add(b);

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
