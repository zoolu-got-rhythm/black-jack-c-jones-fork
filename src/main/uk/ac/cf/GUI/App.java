package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Chips;
import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

public class App {
    public static void main(String[] args) {

        int score = 10;
        Player playerA = new Player("player", score);
        Player playerB = new Player("house", 10);
        Game model = new Game(playerA, playerB);
        Controller controller = new Controller(model);

        CardView playerCards = new CardView(model, "player");
        CardView houseCards = new CardView(model, "house"); // computer
        NavigationView navView = new NavigationView(controller);
        ChipsView chipsView = new ChipsView(model);
        BettingView bettingView = new BettingView(controller);


        Board board = new Board(houseCards, playerCards, navView, chipsView, bettingView);

        // add observer

        model.addObserver(playerCards);
        model.addObserver(houseCards);
        model.addObserver(chipsView);
        // add chips view
//        board.createAndShowGui();
        board.init();

        controller.placeBet();
    }
}
