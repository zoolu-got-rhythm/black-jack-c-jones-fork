package uk.ac.cf.GUI;

import uk.ac.cf.blackjack.Chips;
import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

public class App {
    public static void main(String[] args) {

        int score = 10;

        // model
        Player playerA = new Player("player", score);
        Player playerB = new Player("house", 10000);
        Game model = new Game(playerA, playerB);

        // views
        CardView playerCards = new CardView(model, "player");
        CardView houseCards = new CardView(model, "house"); // computer

        TurnView houseTurnView = new TurnView(model, "house");
        TurnView playerTurnView = new TurnView(model, "player");

        // controler
        Controller controller = new Controller(model, houseCards);

        // views
        NavigationView navView = new NavigationView(controller, model);
        ChipsView chipsView = new ChipsView(model);
        BettingView bettingView = new BettingView(model, controller);
        ChipsCountView chipsCountView = new ChipsCountView(model);

        // title screen view
        TitleScreen titleScreen = new TitleScreen(model);


        // view
        Board board = new Board(houseCards, playerCards, navView, chipsView, bettingView, playerTurnView, houseTurnView, titleScreen,
                chipsCountView);

        // add observer
        model.addObserver(playerCards);
        model.addObserver(houseCards);
        model.addObserver(chipsView);
        model.addObserver(playerTurnView);
        model.addObserver(houseTurnView);
        model.addObserver(navView);
        model.addObserver(bettingView);
        model.addObserver(chipsCountView);
        model.addObserver(titleScreen);
        // add chips view
//        board.createAndShowGui();

        // create view
        board.init();

//        controller.placeBet();
    }
}
