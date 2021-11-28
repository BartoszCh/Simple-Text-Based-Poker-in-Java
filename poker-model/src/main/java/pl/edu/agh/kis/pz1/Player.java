package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int PLAYER_SIZE = 5;
    public String playerName = "Guest";
    public List<Card> cards = new ArrayList<>();
    public Hand currentHand = Hand.HIGHEST_CARD;

    public Player (List<Card> cards){
        MainModel.sortCards(cards);
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public static int getPlayerSize() {
        return PLAYER_SIZE;
    }

    public void setGuest(int i){
        playerName = "Guest " + i;
    }

    public void showCards(){
        for(int i=0; i < PLAYER_SIZE; i++){
            System.out.println( this.cards.get(i).toString());
        }
        System.out.println("\n");
    }


}
