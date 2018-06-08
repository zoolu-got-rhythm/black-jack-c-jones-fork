package uk.ac.cf.blackjack;

public class Chips {
    private int currentBalance;

    Chips(int startingBalance){
        this.currentBalance = startingBalance;
    }

    public void addChips(int amount){
        this.currentBalance += amount;
    }

    public void removeChips(int amount){
        this.currentBalance -= amount;
    }

    public void transfer(Chips otherPeronsChips, int amount){
        // may not need this
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
