package uk.ac.cf.GUI;

import uk.ac.cf.playingcards.Rank;
import uk.ac.cf.playingcards.Suit;

public class EnumToCardPath {
    public static String imgPathFromRankAndSuitEnums(Rank rank, Suit suit){
        StringBuilder imgPath = new StringBuilder();

        if((int) rank.ordinal() != 0 && rank.ordinal() < 10) {
            imgPath.append((int) rank.ordinal() + 1);
            imgPath.append("_of_");
        }else if(rank.ordinal() == 0){
            imgPath.append("ace_of_");
        }else{
            switch (rank){
                case JACK:
                    imgPath.append("jack_of_");
                    break;
                case QUEEN:
                    imgPath.append("queen_of_");
                    break;
                case KING:
                    imgPath.append("king_of_");
                    break;

            }
        }

        switch (suit){
            case CLUBS:
                imgPath.append("clubs.png");
                break;
            case SPADES:
                imgPath.append("spades.png");
                break;
            case HEARTS:
                imgPath.append("hearts.png");
                break;
            case DIAMONDS:
                imgPath.append("diamonds.png");
                break;
        }

        return imgPath.toString();
    }
}
