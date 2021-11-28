package pl.edu.agh.kis.pz1;

import junit.framework.TestCase;

public class RankTest extends TestCase {

    public void testGetValue() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(card.rank.getValue(), 14);
    }
}