package uk.ac.cf;

import uk.ac.cf.blackjack.Game;

public class App {
    public static void main(String[] args) {
        Game model = new Game("player", "house");
        View view = new View();
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        // start the game
        model.dealCards(2, true);


    }
}
