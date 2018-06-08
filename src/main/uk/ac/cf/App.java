package uk.ac.cf;

import uk.ac.cf.blackjack.Game;
import uk.ac.cf.blackjack.Player;

public class App {

    public static void main(String[] args) {
        int score = 10;


        Game model;
        View view;
        Controller controller;

        while(true) {

            System.out.println("WELCOME TO RAINBOW BLACKJACK (21), GOOD LUCK!");
            System.out.println("------------------------------------------------------");


            Player playerA = new Player("player", score);
            Player playerB = new Player("house", 10);
            model = new Game(playerA, playerB);
            view = new View();
            model.addObserver(view);
            controller = new Controller(model, view);
            // start the game
            controller.initGame();
            System.out.println("game ended \n-----------------------------------------");
            score = playerA.getChips().getCurrentBalance();
            if(score >= 100){
                System.out.println("YOU'VE WON!!!!!!!");
            }
        }
    }
}
