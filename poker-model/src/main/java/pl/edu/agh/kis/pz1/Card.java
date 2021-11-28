package pl.edu.agh.kis.pz1;

public class Card {

    public Rank rank;
    public Suit suit;

    Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        return this.rank + " OF " + this.suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }


}
