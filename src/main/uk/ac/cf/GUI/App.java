package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Chips;

public class App {
    public static void main(String[] args) {
        CardView playerCards = new CardView("player");
        CardView houseCards = new CardView("house"); // computer
        NavigationView navView = new NavigationView();
        ChipsView chipsView = new ChipsView();
        BettingView bettingView = new BettingView();

        // add observer
        Board board = new Board(houseCards, playerCards, navView, chipsView, bettingView);
//        board.createAndShowGui();
        board.init();
    }
}
