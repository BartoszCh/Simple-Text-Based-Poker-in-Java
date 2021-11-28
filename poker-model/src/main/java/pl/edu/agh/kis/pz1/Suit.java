package pl.edu.agh.kis.pz1;

public enum Suit {
    DIAMONDS(2),
    SPADES(4),
    CLUBS(1),
    HEARTS(3);

    public int value;

    public int getValue(){
        return value;
    }

    Suit(int value) {
        this.value = value;
    }
}