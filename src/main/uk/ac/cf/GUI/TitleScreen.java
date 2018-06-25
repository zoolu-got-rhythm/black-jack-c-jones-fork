package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class TitleScreen extends JPanel implements Observer {
    private final Map<Tip, String> tips;
//    private Tip[] tipsArray = {Tip.MIN_BUY_IN, Tip.HOW_TO_WIN, Tip.CARD_OR_STAY};
    private String currentTip = "";
    private String displayCurrentTipState = "";
    private Timer textScrollTimer;
    private Tip currentTipEnum;
    private Game model;

    TitleScreen(Game model) {
        this.model = model;
        this.tips = new HashMap();
        this.tips.put(Tip.MIN_BUY_IN, "minimum buy in is 3 chips, insert value and hit 'bet'");
        this.tips.put(Tip.HOW_TO_WIN, "get your stack of chips to reach the finish line to win");
        this.tips.put(Tip.CARD_OR_STAY, "click 'card' to draw a card, or 'stay' to stick with hand");

        super.setBackground(Color.BLACK);
        this.setCurrentTipAndDecideToRunAnimation(Tip.HOW_TO_WIN, 2000, 70);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setCurrentTipAndDecideToRunAnimation(Tip.MIN_BUY_IN, 0, 30);
            }
        }, 10000);
    }

    private void startTextScroll(int delay, int period){
        this.textScrollTimer = new Timer();
        this.textScrollTimer.scheduleAtFixedRate(new TimerTask() {
            private int i = 0;
            @Override
            public void run() {
                i++;

                displayCurrentTipState = currentTip.substring(0, i);
                repaint();

                if(i >= currentTip.length()) {
                    textScrollTimer.cancel();
                    i = 0;
                }
            }
        }, delay, period);
    }

    public void setCurrentTipAndDecideToRunAnimation(Tip newCurrentTipEnum, int delay, int period) {
        Boolean shouldReRunTextScroll = newCurrentTipEnum != this.currentTipEnum;
        this.currentTipEnum = newCurrentTipEnum;
        this.currentTip = this.tips.get(this.currentTipEnum);
        if(shouldReRunTextScroll){
            if(this.textScrollTimer != null)
                this.textScrollTimer.cancel();
            startTextScroll(delay, period);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        int width = super.getWidth();
        int height = super.getHeight();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GREEN);

        g.drawString(displayCurrentTipState, 5, (height / 2) + 4);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(model.getPlacedBets().isEmpty())
            setCurrentTipAndDecideToRunAnimation(Tip.MIN_BUY_IN, 0, 30);
        if(model.getPlacedBets().size() > 1)
            setCurrentTipAndDecideToRunAnimation(Tip.CARD_OR_STAY, 0, 30);
    }
}
