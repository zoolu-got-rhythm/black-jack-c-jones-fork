package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Chips;
import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

public class App {
    public static void main(String[] args) {

        int score = 10;

        // model
        Player playerA = new Player("player", score);
        Player playerB = new Player("house", 10);
        Game model = new Game(playerA, playerB);

        // views
        CardView playerCards = new CardView(model, "player");
        CardView houseCards = new CardView(model, "house"); // computer

        // controler
        Controller controller = new Controller(model, houseCards);

        // views
        NavigationView navView = new NavigationView(controller);
        ChipsView chipsView = new ChipsView(model);
        BettingView bettingView = new BettingView(controller);
        TurnView turnView = new TurnView(model);

        // view
        Board board = new Board(houseCards, playerCards, navView, chipsView, bettingView, turnView);

        // add observer

        model.addObserver(playerCards);
        model.addObserver(houseCards);
        model.addObserver(chipsView);
        model.addObserver(turnView);
        // add chips view
//        board.createAndShowGui();

        // create view
        board.init();

        controller.placeBet();
    }
}
