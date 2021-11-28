package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/** klasa pl.edu.agh.kis.pz1.Deck ktora przechowuje talie wygenerowanych kart
 *
 */
public class Deck {
    public static final int DECK_SIZE = 52;
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {return cards;}

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    Deck(List<Card> cards){
        this.cards = cards;
    }

    /**
     * fabryka kart tworząca posortowaną talie
     * @return
     */
    public static List<Card> factory(){
        List<Card> newDeck = new LinkedList<>();
        for (Suit suit : Suit.values()){
            for (Rank rank :Rank.values()){
                newDeck.add(new Card(rank, suit));
            }
        }
        return newDeck;
    }

    /**
     * potasowanie posortowanej talii
     * @return
     */
    public List<Card> shuffle() {
        List<Card> shuffledCards = this.cards;
        Collections.shuffle(shuffledCards);
        return shuffledCards;
    }
}
