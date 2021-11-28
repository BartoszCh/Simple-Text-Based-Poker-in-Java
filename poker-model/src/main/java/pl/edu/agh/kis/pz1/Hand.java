package pl.edu.agh.kis.pz1;

public enum Hand {
    ROYAL_FLUSH (10),
    STRAIGHT_FLUSH (9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT (5),
    THREE_OF_A_KIND (4),
    TWO_PAIR(3),
    PAIR(2),
    HIGHEST_CARD(1);

    public int value;
    Hand(int value) {
        this.value = value;
    }
}
